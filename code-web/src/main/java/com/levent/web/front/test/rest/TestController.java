package com.levent.web.front.test.rest;

import com.levent.api.model.exception.ForumAdviceException;
import com.levent.api.model.vo.ResVo;
import com.levent.api.model.vo.Status;
import com.levent.api.model.vo.constants.StatusEnum;
import com.levent.core.util.EmailUtil;
import com.levent.core.util.SpringUtil;
import com.levent.web.front.test.vo.EmailReqVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author levent
 * @Description: 测试类
 */
@Slf4j
@RestController
@RequestMapping(path = "test")
public class TestController {
    private AtomicInteger cnt = new AtomicInteger(1);

    /**
     * 测试ControllerAdvice
     * @return
     */
    @RequestMapping(path = "testControllerAdvice")
    @ResponseBody
    public String testControllerAdvice() {
        throw new ForumAdviceException(StatusEnum.ILLEGAL_ARGUMENTS_MIXED, "测试ControllerAdvice异常");
    }

    /**
     * 测试邮件发送
     *
     * @param req
     * @return
     */
//    @Permission(role = UserRole.ADMIN)
    @RequestMapping(path = "email")
    public ResVo<String> email(EmailReqVo req) {
        if (StringUtils.isBlank(req.getTo()) || req.getTo().indexOf("@") <= 0) {
            return ResVo.fail(Status.newStatus(StatusEnum.ILLEGAL_ARGUMENTS_MIXED, "非法的邮箱接收人"));
        }
        if (StringUtils.isBlank(req.getTitle())) {
            req.setTitle("技术派的测试邮件发送");
        }
        if (StringUtils.isBlank(req.getContent())) {
            req.setContent("技术派的测试发送内容");
        } else {
            // 测试邮件内容，不支持发送邮件正文，避免出现垃圾情况
            req.setContent(StringEscapeUtils.escapeHtml4(req.getContent()));
        }

        boolean ans = EmailUtil.sendMail(req.getTitle(), req.getTo(), req.getContent());
        log.info("测试邮件发送，计数：{}，发送内容：{}", cnt.addAndGet(1), req);
        return ResVo.ok(String.valueOf(ans));
    }

    /**
     * 发送html
     */
    @RequestMapping(path = "sendHtml")
    public void sendHtml() throws MessagingException {
        JavaMailSender javaMailSender = SpringUtil.getBean(JavaMailSender.class);
        MimeMessage mimeMailMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage, true);
        mimeMessageHelper.setFrom("guan.levent@foxmail.com");
        mimeMessageHelper.setTo("levent_guan@163.com");
        mimeMessageHelper.setSubject("SpringBoot测试邮件发送");

        //邮件内容
        mimeMessageHelper.setText("<h1>Hello World</h1> <br/> " +
                "<div> 欢迎点击 <a href=\"https://blog.hhui.top\">一灰灰博文地址</a><br/>" +
                " <img width=\"200px\" height=\"200px\" src=\"https://blog.hhui.top/hexblog/imgs/info/wx.jpg\"/>" +
                "</div>", true);

        javaMailSender.send(mimeMailMessage);
    }
}