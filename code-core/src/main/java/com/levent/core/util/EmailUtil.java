package com.levent.core.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;

/**
 * @Author: guanxinyi
 * @CreateTime: 2024-10-18
 * @Description: 邮件工具类
 * @Version: 1.0
 */
@Slf4j
public class EmailUtil {
    //发送邮件的账号
    private static volatile String from;

    //双检加锁获取发送账户
    public static String getFrom() {
        if (from == null) {
            synchronized (EmailUtil.class) {
                if (from == null) {
                    from = SpringUtil.getConfig("spring.mail.from", "guan.levent@foxmail.com");
                }
            }
        }
        return from;
    }

    /**
     * springboot-email封装的发送邮件
     *
     * @param title
     * @param to
     * @param content
     * @return
     */
    public static boolean sendMail(String title, String to, String content) {
        try {
            JavaMailSender javaMailSender = SpringUtil.getBean(JavaMailSender.class);
            MimeMessage mimeMailMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage, true);
            mimeMessageHelper.setFrom(getFrom());
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(title);
            //邮件内容，第二个参数设置为true，支持html模板
            mimeMessageHelper.setText(content, true);
            // 解决 JavaMailSender no object DCH for MIME type multipart/mixed 问题
            Thread.currentThread().setContextClassLoader(EmailUtil.class.getClassLoader());
            javaMailSender.send(mimeMailMessage);
            return true;
        } catch (Exception e) {
            log.warn("sendEmail error {}@{}, {}", title, to, e);
            return false;
        }
    }
}
