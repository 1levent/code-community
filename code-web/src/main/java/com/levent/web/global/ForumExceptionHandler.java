package com.levent.web.global;

import com.levent.api.model.context.ReqInfoContext;
import com.levent.api.model.exception.ForumException;
import com.levent.api.model.vo.ResVo;
import com.levent.api.model.vo.Status;
import com.levent.api.model.vo.constants.StatusEnum;
import com.levent.core.util.JsonUtil;
import com.levent.core.util.SpringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.core.NestedRuntimeException;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.messaging.handler.annotation.support.MethodArgumentTypeMismatchException;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: guanxinyi
 * @CreateTime: 2024-10-10
 * @Description: 全局异常处理器
 * 工作原理主要基于 Spring MVC 的异常处理流程
 * @Version: 1.0
 */
@Slf4j
@Order(-100)
public class ForumExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        //根据异常类型，构建消息状态
        Status errStatus = buildToastMsg(ex);
        //根据请求和响应的类型来确定返回的异常信息的方式，一种是 REST 接口请求的异常，一种是针对普通页面请求的异常
        if (restResponse(request, response)) {
            // 表示返回json数据格式的异常提示信息
            if (response.isCommitted()) {
                // 如果返回已经提交过，直接退出即可
                return new ModelAndView();
            }

            try {
                response.reset();
                // 若是rest接口请求异常时，返回json格式的异常数据；而不是专门的500页面
                response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
                response.setHeader("Cache-Control", "no-cache, must-revalidate");
                response.getWriter().println(JsonUtil.toStr(ResVo.fail(errStatus)));
                response.getWriter().flush();
                response.getWriter().close();
                return new ModelAndView();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        //获取返回的视图页面类型
        String view = getErrorPage(errStatus, response);
        ModelAndView mv = new ModelAndView(view);
        response.setContentType(MediaType.TEXT_HTML_VALUE);
        mv.getModel().put("global", SpringUtil.getBean(GlobalInitService.class).globalAttr());
        mv.getModel().put("res", ResVo.fail(errStatus));
        mv.getModel().put("toast", JsonUtil.toStr(ResVo.fail(errStatus)));
        return mv;
    }

    private Status buildToastMsg(Exception ex) {
        if (ex instanceof ForumException) {
            return ((ForumException) ex).getStatus();
        } else if (ex instanceof AsyncRequestTimeoutException) {
            return Status.newStatus(StatusEnum.UNEXPECT_ERROR, "超时未登录");
        } else if (ex instanceof HttpMediaTypeNotAcceptableException) {
            return Status.newStatus(StatusEnum.RECORDS_NOT_EXISTS, ExceptionUtils.getStackTrace(ex));
        } else if (ex instanceof HttpRequestMethodNotSupportedException || ex instanceof MethodArgumentTypeMismatchException || ex instanceof IOException) {
            // 请求方法不匹配
            return Status.newStatus(StatusEnum.ILLEGAL_ARGUMENTS, ExceptionUtils.getStackTrace(ex));
        } else if (ex instanceof NestedRuntimeException) {
            log.error("unexpect NestedRuntimeException error! {}", ReqInfoContext.getReqInfo(), ex);
            return Status.newStatus(StatusEnum.UNEXPECT_ERROR, ex.getMessage());
        } else {
            log.error("unexpect error! {}", ReqInfoContext.getReqInfo(), ex);
            return Status.newStatus(StatusEnum.UNEXPECT_ERROR, ExceptionUtils.getStackTrace(ex));
        }
    }

    /**
     * 根据异常码解析需要返回的错误页面
     * @param status
     * @param response
     * @return
     */
    private String getErrorPage(Status status, HttpServletResponse response) {
        if (StatusEnum.is5xx(status.getCode())) {
            response.setStatus(500);
            return "error/500";
        } else if (StatusEnum.is403(status.getCode())) {
            response.setStatus(403);
            return "error/403";
        } else {
            response.setStatus(404);
            return "error/404";
        }
    }

    /**
     * 后台请求、api数据请求、上传图片等接口，返回json格式的异常提示信息
     * 其他异常，返回500的页面
     *
     * @param request
     * @param response
     * @return
     */
    private boolean restResponse(HttpServletRequest request, HttpServletResponse response) {
        if (request.getRequestURI().startsWith("/api/admin/") || request.getRequestURI().startsWith("/admin/")) {
            return true;
        }

        if (request.getRequestURI().startsWith("/image/upload")) {
            return true;
        }

        if (response.getContentType() != null && response.getContentType().contains(MediaType.APPLICATION_JSON_VALUE)) {
            return true;
        }

        if (isAjaxRequest(request)) {
            return true;
        }

        // 数据接口请求
        AntPathMatcher pathMatcher = new AntPathMatcher();
        if (pathMatcher.match("/**/api/**", request.getRequestURI())) {
            return true;
        }
        return false;
    }

    private boolean isAjaxRequest(HttpServletRequest request) {
        String requestedWith = request.getHeader("X-Requested-With");
        return "XMLHttpRequest".equals(requestedWith);
    }
}
