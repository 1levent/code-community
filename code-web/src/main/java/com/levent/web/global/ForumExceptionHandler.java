package com.levent.web.global;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: guanxinyi
 * @CreateTime: 2024-10-10
 * @Description: 全局异常处理器
 * @Version: 1.0
 */
@Slf4j
@Order(-100)
public class ForumExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        return null;
    }
}
