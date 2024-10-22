package com.levent.web.front.login.wx.helper;


import com.levent.api.model.vo.user.wx.BaseWxMsgResVo;
import com.levent.api.model.vo.user.wx.WxImgTxtItemVo;
import com.levent.api.model.vo.user.wx.WxImgTxtMsgResVo;
import com.levent.api.model.vo.user.wx.WxTxtMsgResVo;
import com.levent.core.util.CodeGenerateUtil;
import com.levent.service.user.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Component
public class WxAckHelper {
    @Autowired
    private LoginService sessionService;
    @Autowired
    private WxLoginHelper qrLoginHelper;

//    @Autowired
//    private ChatgptService chatgptService;

    /**
     * 返回自动响应的文本
     *
     * @return
     */
    public BaseWxMsgResVo buildResponseBody(String eventType, String content, String fromUser) {
        // 返回的文本消息
        String textRes = null;
        // 返回的是图文消息
        List<WxImgTxtItemVo> imgTxtList = null;
        if ("subscribe".equalsIgnoreCase(eventType)) {
            // 订阅
            textRes = "感谢你\n";
        }
//        // 下面是关键词回复
//        else if (chatgptService.inChat(fromUser, content)) {
//            try {
//                textRes = chatgptService.chat(fromUser, content);
//            } catch (Exception e) {
//                log.error("派聪明 访问异常! content: {}", content, e);
//                textRes = "派聪明 出了点小状况，请稍后再试!";
//            }
//        }

        // 下面是回复图文消息
        else if ("加群".equalsIgnoreCase(content)) {
            WxImgTxtItemVo imgTxt = new WxImgTxtItemVo();
            imgTxt.setTitle("扫码加群");
            imgTxt.setDescription("卷起来！");
            imgTxt.setPicUrl("https://mmbiz.qpic.cn/mmbiz_jpg/sXFqMxQoVLGOyAuBLN76icGMb2LD1a7hBCoialjicOMsicvdsCovZq2ib1utmffHLjVlcyAX2UTmHoslvicK4Mg71Kyw/0?wx_fmt=jpeg");
            imgTxt.setUrl("https://mp.weixin.qq.com/s/aY5lkyKjLHWSUuEf1UT2yQ");
            imgTxtList = Arrays.asList(imgTxt);
        } else if ("admin".equalsIgnoreCase(content) || "后台".equals(content) || "002".equals(content)) {
            // admin后台登录，返回对应的用户名 + 密码
            textRes = "后台游客登录账号\n-----------\n登录用户名: guest\n登录密码: 123456";
        }
        // 微信公众号登录
        else if (CodeGenerateUtil.isVerifyCode(content)) {
            sessionService.autoRegisterWxUserInfo(fromUser);
            if (qrLoginHelper.login(content)) {
                textRes = "登录成功！";
            } else {
                textRes = "验证码过期了，刷新登录页面重试一下吧";
            }
        } else {
            textRes = "什么都没有了";
        }

        if (textRes != null) {
            WxTxtMsgResVo vo = new WxTxtMsgResVo();
            vo.setContent(textRes);
            return vo;
        } else {
            WxImgTxtMsgResVo vo = new WxImgTxtMsgResVo();
            vo.setArticles(imgTxtList);
            vo.setArticleCount(imgTxtList.size());
            return vo;
        }
    }
}
