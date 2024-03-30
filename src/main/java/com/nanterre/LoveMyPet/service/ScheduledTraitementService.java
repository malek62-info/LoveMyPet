package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.repository.TraitementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ScheduledTraitementService {

    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    private TraitementRepository traitementRepository;

    // Cette fonction envoie des e-mails  pour les traitements
    @Scheduled(fixedRate = 60000)
    public void sendEmailToUsersWithScheduledTraitement() {
        try {
            List<Object[]> traitementDetails = traitementRepository.findEmailAndTreatmentDetails();

          /*  for (Object[] traitementDetail : traitementDetails) {
                System.out.println(Arrays.toString(traitementDetail));
            }*/

            for (Object[] traitementDetail : traitementDetails) {
                if (traitementDetail != null && traitementDetail.length == 6) {

                    String userEmail = (String) traitementDetail[0];         // email de la personne
                    String nom_medicament = (String) traitementDetail[1];   // nom du médicament
                    String nom_traitement = (String) traitementDetail[2];    // nom du traitement
                    String date_traitement = (String) traitementDetail[3];   // date du traitement
                    String nom_animal = (String) traitementDetail[4];        // nom de l'animal
                    String heure_traitement = (String) traitementDetail[5];  // heure du traitement


                /*    System.out.println("Email: " + userEmail);
                    System.out.println("Médicament: " + nom_medicament);
                    System.out.println("Traitement: " + nom_traitement);
                    System.out.println("Date du traitement: " + date_traitement);
                    System.out.println("Animal: " + nom_animal);
                    System.out.println("Heure du traitement: " + heure_traitement);*/


                    String subject = "LoveMyPet Rappel - Traitement pour " + nom_animal ;

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
                            + "<p>Bonjour,</p>"
                            + "<p>Il est maintenant temps de donner le traitement à <span>" + nom_animal + "</span>.</p>"
                            + "<p><span>Date du traitement :</span> " + date_traitement + "</p>"
                            + "<p><span>Heure du traitement :</span> " + heure_traitement + "</p>"
                            + "<p><span>Médicament :</span> " + nom_medicament + "</p>"
                            + "<p><span>Nom du traitement :</span> " + nom_traitement + "</p>"
                            + "<p>N'oubliez pas de donner le traitement à votre animal à l'heure prévue.</p>"
                            + "<p>Merci de prendre soin de votre animal!</p>"
                            + "<div style=\"text-align: center; margin-top: 20px;\"><a href=\"https://imgbb.com/\"><img src=\"https://i.ibb.co/YWY5Tbf/s-l1200.webp\" alt=\"vaccination-chien\" width=\"200px\" style=\"border-radius: 10px; display: block; margin: 0 auto;\"></a></div>"
                            + "</div><div class='footer'>Cordialement<br/>LoveMyPet</div></div>"
                            + "</body></html>";



                    emailSenderService.sendHtmlEmail(userEmail, subject, body);

                    System.out.println("Email sent successfully to " + userEmail + " (Traitement Email)");
                }
            }
        } catch (Exception e) {
            System.out.println("Error sending emails: " + e.getMessage());
        }
    }
}
