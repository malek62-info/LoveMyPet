package com.nanterre.LoveMyPet.controller;

import com.nanterre.LoveMyPet.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import com.nanterre.LoveMyPet.model.FeedingSchedule;
import com.nanterre.LoveMyPet.service.FeedingScheduleServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/feeding-schedules")
public class FeedingScheduleController {

    @Autowired
    private FeedingScheduleServiceImpl feedingScheduleService;

    @PostMapping
    public ResponseEntity<String> createFeedingSchedule(@RequestBody FeedingSchedule feedingSchedule) {
        FeedingSchedule createdSchedule = feedingScheduleService.createFeedingSchedule(feedingSchedule);
        int feedingFrequency = feedingSchedule.getFeedingFrequency();

        String successMessage = String.format("Feeding schedule created for %d times a day at the specified hours.", feedingFrequency);
        return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
    }

    // récupérer la liste des utilisateurs avec un repas planifié à l'heure actuelle

    // Exécute la méthode toutes les 1 seconde
    @Scheduled(fixedRate = 1000)
    @ResponseBody
    public String displayUsersWithCurrentFeedingTime() {
        try {
            List<String> emails = feedingScheduleService.getUsersWithCurrentFeedingTime();

            if (emails.isEmpty()) {
                return "Aucun utilisateur trouvé.";
            } else {
                for (String email : emails) {
                    System.out.println("E-mail : " + email);
                }
                return "E-mails affichés dans la console.";
            }
        } catch (Exception e) {
            // Gérez les exceptions selon vos besoins
            e.printStackTrace();
            return "Erreur lors de la récupération des utilisateurs avec un repas planifié à l'heure actuelle.";
        }
    }


}
