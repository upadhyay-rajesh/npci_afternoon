package com.mybanking.service;

import org.springframework.stereotype.Service;

@Service
public class EmailNotificationService {

    public void sendWelcomeEmail(String email) {
        // Simulates sending an email
        System.out.println("Sending welcome email to " + email);
    }
}

