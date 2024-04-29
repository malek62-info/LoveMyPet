package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.AnimalVuEmail;
import com.nanterre.LoveMyPet.repository.AnimalVuEmailRepository;
import com.nanterre.LoveMyPet.repository.AnimalVuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduledAnimalVuEmailService {

    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    private AnimalVuRepository animalVuRepository;

    @Autowired
    private AnimalVuEmailRepository animalVuEmailRepository;

    @Scheduled(fixedRate = 60000)
    public void sendEmailToUsersWithScheduledAnimalVu() {
        try {
            List<Object[]> animalVuDetails = animalVuRepository.getEmailsByAnimalVue();

            for (Object[] animalVuDetail : animalVuDetails) {
                Long idAnimalVu = (Long) animalVuDetail[0];
                String nomAnimal = (String) animalVuDetail[1];
                String emailVoyeur = (String) animalVuDetail[2];
                String emailProprietaire = (String) animalVuDetail[3];
                
                 // Print variables to console
                System.out.println("ID de l'animal vu : " + idAnimalVu);
                System.out.println("Nom de l'animal : " + nomAnimal);
                System.out.println("Email du voyeur : " + emailVoyeur);
                System.out.println("Email du propriétaire : " + emailProprietaire);
                // Check if idAnimalVue already exists in AnimalVuEmail table
                AnimalVuEmail existingAnimalVuEmail = animalVuEmailRepository.findByIdAnimalVue(idAnimalVu);
                if (existingAnimalVuEmail != null) {
                    System.out.println("Nous avons déjà envoyé un email à : " + emailProprietaire + " pour l'animal avec id_animal_vu : " + idAnimalVu);
                }else {
                    System.out.println("go envoi le mail");
                    // Send email
                String subject = "Vous avez reçu une nouvelle concernant votre animal sur Love My Pet : " + nomAnimal;
                String body = "<html>" +
                "<head>" +
                "<style>" +
                "body {" +
                "    font-family: Arial, sans-serif;" +
                "    background-color: #f4f4f4;" +
                "}" +
                ".container {" +
                "    max-width: 600px;" +
                "    margin: 20px auto;" +
                "    padding: 20px;" +
                "    background-color: #ffffff;" +
                "    border-radius: 8px;" +
                "    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);" +
                "}" +
                "h1 {" +
                "    color: #333333;" +
                "}" +
                "p {" +
                "    color: #666666;" +
                "}" +
                "</style>" +
                "</head>" +
                "<body>" +
                "<div class='container'>" +
                "<h1>Cher utilisateur,</h1>" +
                "<p>Vous avez une nouvelle concernant votre animal perdu sur Love My Pet.</p>" +
                "<p>Cette nouvelle provient de l'email du voyeur.</p>" +
                "<p>Cordialement,<br>Love My Pet</p>" +
                "</div>" +
                "</body>" +
                "</html>";

                emailSenderService.sendHtmlEmail(emailProprietaire, subject, body);
                 
                // Save idAnimalVu to AnimalVuEmail table
                AnimalVuEmail newAnimalVuEmail = new AnimalVuEmail();
                newAnimalVuEmail.setIdAnimalVue(idAnimalVu);
                animalVuEmailRepository.save(newAnimalVuEmail);
           


                

                System.out.println("Email envoyé avec succès à " + emailProprietaire + " pour l'animal avec id_animal_vu : " + idAnimalVu);
                }

                
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de l'envoi des emails : " + e.getMessage());
        }
    }
}
