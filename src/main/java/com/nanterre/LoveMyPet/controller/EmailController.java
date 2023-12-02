package com.nanterre.LoveMyPet.controller;

import com.nanterre.LoveMyPet.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailSenderService emailSenderService;

    @PostMapping("/send")
    public String sendEmail() {
        try {
            String fixedToEmail = "challenge.faizdev@gmail.com";  // Adresse e-mail codée en dur à des fins de test
            String fixedSubject = "Fixed Subject";  // Sujet fixe à des fins de test
            String fixedBody = "Fixed Body Content";  // Corps fixe à des fins de test

            System.out.println("Received request with to: " + fixedToEmail + ", subject: " + fixedSubject + ", body: " + fixedBody);
            emailSenderService.sendSimpleEmail(fixedToEmail, fixedSubject, fixedBody);
            return "Email sent successfully!";
        } catch (Exception e) {
            return "Error sending email: " + e.getMessage();
        }
    }
}



