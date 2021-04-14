package com.codeyancy.cn.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author Zjy
 * @date 2021/4/13 10:46
 */
@Component
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Async
    public void sendMail(String email,String code){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("邮箱验证<zhjinyang@163.com>");
        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject("邮箱登录验证码");
        simpleMailMessage.setText(code);
        javaMailSender.send(simpleMailMessage);

    }
}
