package com.nanterre.LoveMyPet.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.List;
import com.nanterre.LoveMyPet.repository.EvenementRepository;

@Service
public class ScheduledEventService {

    @Autowired
    private EvenementRepository evenementRepository;

    @Autowired
    private EmailSenderService emailSenderService; // Injectez votre service existant

    @Scheduled(cron = "0 0 0 * * *") // tentative d'envoie de mail tous les jours à 00h00
    public void envoyerEmailsRappelEvenements() {
        List<Object[]> results = evenementRepository.findEmailsAndEventDetailsForReminders();

        for (Object[] result : results) {
            String email = (String) result[0];
            String firstName = (String) result[1];
            String lastName = (String) result[2];
            String eventName = (String) result[3];
            String eventPlace = (String) result[4];

            // Envoi de l'e-mail de rappel en utilisant votre service existant
            envoyerEmailRappel(email, firstName, lastName, eventName, eventPlace);
        }
    }

    private void envoyerEmailRappel(String email, String firstName, String lastName, String eventName, String eventPlace) {
        try {
            String subject = "Rappel pour l'événement: " + eventName;
            String body = "<html>"
                    + "<body style=\"font-family: Arial, sans-serif;\">"
                    + "<h2 style=\"color: #008080;\">Rappel pour l'événement: " + eventName + "</h2>"
                    + "<p>Bonjour " + firstName + " " + lastName + ",</p>"
                    + "<p>Ceci est un rappel pour l'événement \"" + eventName + "\" prévu à l'endroit \"" + eventPlace + "\".</p>"
                    + "<p>N'oubliez pas d'y participer!</p>"
                    + "<br>"
                    + "<img src=\"https://i.ibb.co/C89P4JY/logo.png\" alt=\"LoveMyPet Logo\" width=\"200px\" style=\"border-radius: 10px;\">"
                    + "<br><br>"
                    + "<p style=\"color: #008080;\">Cordialement,<br>Votre Application LoveMyPet</p>"
                    + "</body>"
                    + "</html>";


            // Utilisez votre service existant pour envoyer l'e-mail
            emailSenderService.sendHtmlEmail(email, subject, body);

            System.out.println("E-mail de rappel envoyé à : " + email);
        } catch (Exception e) {
            System.err.println("Erreur lors de l'envoi de l'e-mail de rappel à : " + email);
            e.printStackTrace();
        }
    }
}


