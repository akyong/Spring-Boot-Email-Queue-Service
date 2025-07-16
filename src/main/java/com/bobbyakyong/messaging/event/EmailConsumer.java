/**
 * Copyright (c) 2025 Bobby Akyong
 * Licensed under the MIT License
 * Author: https://www.bobbyakyong.com | bobbyakyong@gmail.com
 */

package com.bobbyakyong.messaging.event;

import com.bobbyakyong.messaging.domain.EmailRequest;
import com.bobbyakyong.messaging.service.EmailService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    private final EmailService emailService;

    public EmailConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    @JmsListener(destination = "email-queue")
    public void receiveMessage(EmailRequest request) {
        emailService.sendEmail(request);
    }
}

