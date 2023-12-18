package com.nanterre.LoveMyPet.controller;

import com.nanterre.LoveMyPet.service.ScheduledEmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scheduled-email")
public class ScheduledEmailController {

    @Autowired
    private ScheduledEmailService scheduledEmailService;

    @GetMapping("/send-now")
    public String sendEmailNow() {
        // Endpoint to manually trigger the email sending immediately
        scheduledEmailService.sendEmailToUsersWithCurrentFeedingTime();
        return "Email sending triggered!";
    }

    // You can add more endpoints for additional actions related to scheduled emails if needed
}



