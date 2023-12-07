package com.nanterre.LoveMyPet.controller;

import com.nanterre.LoveMyPet.service.EmailSenderService;
import com.nanterre.LoveMyPet.service.FeedingScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    private FeedingScheduleService feedingScheduleService;

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

    // Cette fonction envoie des e-mails toutes les 1 minute si une adresse correspond.
    @Scheduled(fixedDelay = 60000) 
    public String sendEmailToUsersWithCurrentFeedingTime() {
        try {
            List<String> userEmails = feedingScheduleService.getUsersWithCurrentFeedingTime();

            for (String userEmail : userEmails) {
                String subject = "LoveMyPet Rappel - N'oubliez pas de nourrir votre animal!";

                // Corps de l'e-mail avec HTML et CSS
                String body = "<html><head>"
                        + "<style>"
                        + "body {font-family: Arial, sans-serif;}"
                        + ".container {max-width: 600px; margin: 0 auto;}"
                        + ".header {background-color: #4CAF50; color: white; padding: 10px; text-align: center;}"
                        + ".content {padding: 20px;}"
                        + "</style>"
                        + "</head><body>"
                        + "<div class='container'>"
                        + "<div class='header'><h2>LoveMyPet Rappel</h2></div>"
                        + "<div class='content'>"
                        + "<p>Bonjour,</p>"
                        + "<p>C'est l'heure de nourrir votre animal!</p>"
                        + "<p>N'oubliez pas de donner à votre animal son repas quotidien.</p>"
                        + "<img src='https://i.ibb.co/K9wxgyz/email-img.jpg' alt='email-img' border='0'/>"
                        + "<p>Merci de prendre soin de votre animal!</p>"
                        + "</div> Cordialement </div>"
                        + "</div> LoveMyPet </div>"
                        + "</body></html>";

                emailSenderService.sendHtmlEmail(userEmail, subject, body);
            }

            return "Emails sent successfully!";
        } catch (Exception e) {
            return "Error sending emails: " + e.getMessage();
        }
    }


}



