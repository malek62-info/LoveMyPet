package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.repository.VaccinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ScheduledVaccinationService {

    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    private VaccinationRepository vaccinationRepository;



    // Cette fonction envoie des e-mails toutes les jours a 6h du matin
    @Scheduled(cron = "0 0 6 * * ?")
    public void sendEmailToUsersWithScheduledVaccination() {
        try {
            List<Object[]> vaccinationDetails = vaccinationRepository.findVaccinationDetailsForEmails();

            for (Object[] vaccinationDetail : vaccinationDetails) {
                System.out.println(Arrays.toString(vaccinationDetail));
            }

            for (Object[] vaccinationDetail : vaccinationDetails) {
                if (vaccinationDetail != null && vaccinationDetail.length == 8) {
                    String userEmail = (String) vaccinationDetail[0];
                    String animalName = (String) vaccinationDetail[1];
                    String vaccinationDate = (String) vaccinationDetail[2];
                    String vaccinationTime = (String) vaccinationDetail[3];
                    String vetAddress = (String) vaccinationDetail[4];
                    String vetName = (String) vaccinationDetail[5];
                    String vaccineName = (String) vaccinationDetail[6];
                    String vaccinationComment = (String) vaccinationDetail[7];

                    String subject = "LoveMyPet Rappel - Vaccination de "+animalName+" dans 1 mois  ";

                    // Corps de l'e-mail avec HTML et CSS
                    String body = "<html><head>"
                            + "<style>"
                            + "body {font-family: Arial, sans-serif;}"
                            + ".container {max-width: 600px; margin: 0 auto;}"
                            + ".header {background-color: #000; color: white; padding: 20px; text-align: center;}"
                            + ".content {padding: 20px;}"
                            + ".content p {margin-bottom: 10px; color: #000;}"
                            + ".content p span {font-weight: bold;}"
                            + ".footer {background-color: #f4f4f4; padding: 20px; text-align: center;}"
                            + "</style>"
                            + "</head><body>"
                            + "<div class='container'>"
                            + "<div class='header'><h2>LoveMyPet Rappel</h2></div>"
                            + "<div class='content'>"
                            + "<p>Bonjour</p>"
                            + "<p>C'est bientôt l'heure pour <span>" + animalName + "</span> de se faire vacciner.</p>"
                            + "<p><span>Date de vaccination :</span> " + vaccinationDate + "</p>"
                            + "<p><span>Heure de vaccination :</span> " + vaccinationTime + "</p>"
                            + "<p><span>Vétérinaire :</span> " + vetName + "</p>"
                            + "<p><span>Adresse du vétérinaire :</span> " + vetAddress + "</p>"
                            + "<p><span>Type de vaccin :</span> " + vaccineName + "</p>"
                            + "<p>N'oubliez pas d'emmener votre animal chez le vétérinaire à l'heure prévue.</p>"
                            + "<p>Merci de prendre soin de votre animal!</p>"
                            + "<p>Vos commentaires : " + vaccinationComment + "</p>"
                            + "<a href=\"https://imgbb.com/\"><img src=\"https://i.ibb.co/fFy4WsQ/vaccination-chien.jpg\" alt=\"vaccination-chien\" width=\"200px\" style=\"border-radius: 10px; display: block; margin: 0 auto;\"></a>"
                            + "</div><div class='footer'>Cordialement<br/>LoveMyPet</div></div>"
                            + "</body></html>";

                    emailSenderService.sendHtmlEmail(userEmail, subject, body);

                    System.out.println("Email sent successfully to " + userEmail + " (Vaccinnation Email)");
                }
            }
        } catch (Exception e) {
            System.out.println("Error sending emails: " + e.getMessage());
        }
    }
}
