package com.bobbyakyong.messaging.service;

import com.bobbyakyong.messaging.domain.EmailRequest;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmailProducer {

    private final JmsTemplate jmsTemplate;

    public EmailProducer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendToQueue(EmailRequest request) {
        jmsTemplate.convertAndSend("email-queue", request);
    }
}
