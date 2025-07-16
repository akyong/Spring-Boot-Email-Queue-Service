package com.bobbyakyong.messaging.controller;

import com.bobbyakyong.messaging.domain.EmailRequest;
import com.bobbyakyong.messaging.service.EmailProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    private final EmailProducer emailProducer;

    public EmailController(EmailProducer emailProducer) {
        this.emailProducer = emailProducer;
    }

    @PostMapping
    public ResponseEntity<String> send(@RequestBody EmailRequest request) {
        emailProducer.sendToQueue(request);
        return ResponseEntity.ok("Email request submitted to queue.");
    }
}

