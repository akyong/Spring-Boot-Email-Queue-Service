/**
 * Copyright (c) 2025 Bobby Akyong
 * Licensed under the MIT License
 * Author: https://www.bobbyakyong.com | bobbyakyong@gmail.com
 */

package com.bobbyakyong.messaging.service;

import com.bobbyakyong.messaging.domain.EmailRequest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

/**
 * spring Boot with 3.x version is no longer using
 * import javax.mail.MessagingException;
 * import javax.mail.internet.MimeMessage;
 * Author use 3.4.3
 *
 * ⚠️ Note: use jakarta.mail.* , instead javax.mail.*.
 * */

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(EmailRequest request) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(request.getTo());
            helper.setSubject(request.getSubject());
            helper.setText(request.getBody(), true);
            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}

