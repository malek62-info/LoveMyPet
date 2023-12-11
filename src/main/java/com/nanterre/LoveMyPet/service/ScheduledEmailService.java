package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.service.implementations.FeedingTimeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ScheduledEmailService {

    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    private FeedingTimeServiceImpl feedingTimeService;

    // generation comfirmation code
    private String generateConfirmationCode() {
        // Utilisation de UUID pour générer un code unique
        UUID uuid = UUID.randomUUID();
        String confirmationCode = uuid.toString();
        // par exemple, en prenant les 8 premiers caractères
        confirmationCode = confirmationCode.substring(0, 8);

        return confirmationCode;
    }

    // Cette fonction envoie des e-mails toutes les 1 minute si une adresse correspond.
    @Scheduled(fixedRate = 60000)
    public void sendEmailToUsersWithCurrentFeedingTime() {
        try {
            List<Object[]> userDetails = feedingTimeService.getInfosCurrentFeedingTimes();

            for (Object[] userDetail : userDetails) {
                if (userDetail != null && userDetail.length == 7) {
                    String userEmail = (String) userDetail[0];
                    String userName = (String) userDetail[1];
                    Integer userId = (Integer) userDetail[2];
                    Integer animalId = (Integer) userDetail[3];
                    String animalName = (String) userDetail[4];
                    //String animalImageUrl = (String) userDetail[5]; Image de l'animal
                    Integer feedingTimeId = (Integer) userDetail[6];
                    String confirmationCode = generateConfirmationCode();


                    String subject = "LoveMyPet Rappel - N'oubliez pas de nourrir votre animal!";


                    // Corps de l'e-mail avec HTML et CSS
                    String body = "<html><head>"
                            + "<style>"
                            + "body {font-family: Arial, sans-serif;}"
                            + ".container {max-width: 600px; margin: 0 auto;}"
                            + ".header {background-color: #4CAF50; color: white; padding: 10px; text-align: center;}"
                            + ".content {padding: 20px;}"
                            + "span {color: red;}"
                            + "</style>"
                            + "</head><body>"
                            + "<div class='container'>"
                            + "<div class='header'><h2>LoveMyPet Rappel</h2></div>"
                            + "<div class='content'>"
                            + "<p>Bonjour " + userName + ",</p>"
                            + "<p>C'est l'heure de nourrir <span>" + animalName + " </span> </p>"
                            + "<p>Cliquez sur le bouton ci-dessous pour confirmer que vous avez nourri votre animal :</p>"
                            + "<a href='http://localhost:8086/feeding-confirmation/confirm?personId=" + userId + "&animalId=" + animalId + "&feedingTimeId=" + feedingTimeId + "&confirmationCode=" + confirmationCode + "' style='display: inline-block; padding: 10px 20px; background-color: #4CAF50; color: white; text-decoration: none;'>Confirmer</a>"
                            + "<img src='https://i.ibb.co/K9wxgyz/email-img.jpg' alt='email-img' border='0'/>"
                            + "<p>N'oubliez pas de donner à votre animal son repas quotidien.</p>"
                            + "<p>Merci de prendre soin de votre animal!</p>"
                            + "</div> Cordialement </div>"
                            + "</div> LoveMyPet </div>"
                            + "</body></html>";
                    emailSenderService.sendHtmlEmail(userEmail, subject, body);

                    System.out.println("Email sent successfully for " + userName);
                }
            }
        } catch (Exception e) {
            System.out.println("Error sending emails: " + e.getMessage());
        }
    }
}
