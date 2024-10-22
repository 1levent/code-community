package com.levent.web.global;

import com.levent.api.model.context.ReqInfoContext;
import com.levent.api.model.vo.user.dto.BaseUserInfoDTO;
import com.levent.core.util.NumUtil;
import com.levent.core.util.SessionUtil;
import com.levent.service.user.service.LoginService;
import com.levent.service.user.service.UserService;
import com.levent.web.config.GlobalViewConfig;
import com.levent.web.global.vo.GlobalVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.Optional;

/**
 * @Author: guanxinyi
 * @CreateTime: 2024-10-18
 * @Description: 全局初始化服务
 * @Version: 1.0
 */
@Slf4j
@Service
public class GlobalInitService {

    @Value("${env.name}")
    private String env;

    @Resource
    private UserService userService;

    @Resource
    private GlobalViewConfig globalViewConfig;
//
//    @Resource
//    private NotifyService notifyService;
//
//    @Resource
//    private SeoInjectService seoInjectService;
//
//    @Resource
//    private UserStatisticService userStatisticService;
//
//    @Resource
//    private SitemapService sitemapService;
    /**
     * 全局属性配置
     */
    public GlobalVo globalAttr() {
        GlobalVo vo = new GlobalVo();
        vo.setEnv(env);
        vo.setSiteInfo(globalViewConfig);
//        vo.setOnlineCnt(userStatisticService.getOnlineUserCnt());
//        vo.setSiteStatisticInfo(sitemapService.querySiteVisitInfo(null, null));
//        vo.setTodaySiteStatisticInfo(sitemapService.querySiteVisitInfo(LocalDate.now(), null));
//
//        if (ReqInfoContext.getReqInfo() == null || ReqInfoContext.getReqInfo().getSeo() == null || CollectionUtils.isEmpty(ReqInfoContext.getReqInfo().getSeo().getOgp())) {
//            Seo seo = seoInjectService.defaultSeo();
//            vo.setOgp(seo.getOgp());
//            vo.setJsonLd(JSONUtil.toJsonStr(seo.getJsonLd()));
//        } else {
//            Seo seo = ReqInfoContext.getReqInfo().getSeo();
//            vo.setOgp(seo.getOgp());
//            vo.setJsonLd(JSONUtil.toJsonStr(seo.getJsonLd()));
//        }

        try {
            if (ReqInfoContext.getReqInfo() != null && NumUtil.upZero(ReqInfoContext.getReqInfo().getUserId())) {
                vo.setIsLogin(true);
                vo.setUser(ReqInfoContext.getReqInfo().getUser());
                vo.setMsgNum(ReqInfoContext.getReqInfo().getMsgNum());
            } else {
                vo.setIsLogin(false);
            }

            HttpServletRequest request =
                    ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
            if (request.getRequestURI().startsWith("/column")) {
                vo.setCurrentDomain("column");
            } else if (request.getRequestURI().startsWith("/chat")) {
                vo.setCurrentDomain("chat");
            } else {
                vo.setCurrentDomain("article");
            }
        } catch (Exception e) {
            log.error("loginCheckError:", e);
        }
        return vo;
    }

    /**
     * 初始化用户信息
     *
     * @param reqInfo
     */
    public void initLoginUser(ReqInfoContext.ReqInfo reqInfo) {
        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        if (request.getCookies() == null) {
            return;
        }
        Optional.ofNullable(SessionUtil.findCookieByName(request, LoginService.SESSION_KEY))
                .ifPresent(cookie -> initLoginUser(cookie.getValue(), reqInfo));
    }

    public void initLoginUser(String session, ReqInfoContext.ReqInfo reqInfo) {
        BaseUserInfoDTO user = userService.getAndUpdateUserIpInfoBySessionId(session, null);
        reqInfo.setSession(session);
        if (user != null) {
            reqInfo.setUserId(user.getUserId());
            reqInfo.setUser(user);
            //todo 获取消息数量
//            reqInfo.setMsgNum(notifyService.queryUserNotifyMsgCount(user.getUserId()));
        }
    }
}
