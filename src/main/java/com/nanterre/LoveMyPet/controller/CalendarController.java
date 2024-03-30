package com.nanterre.LoveMyPet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nanterre.LoveMyPet.service.AnimalEvent;
import com.nanterre.LoveMyPet.service.EvenementAnimalServiceImpl;
import com.nanterre.LoveMyPet.service.GoogleAuthService;


import java.util.List;
import java.util.Map;

@Controller
public class CalendarController {

    @Autowired
    private GoogleAuthService googleAuthService;

    @Autowired
    public EvenementAnimalServiceImpl evenementAnimalServiceImpl;

    @GetMapping("/export-calendar")
    public String exportCalendar() {
        return "redirect:" + googleAuthService.getAuthorizationUrl();
    }

    @GetMapping("/oauth2callback")
    public String oauth2Callback(@RequestParam("code") String code) {
        String accessToken = googleAuthService.getAccessToken(code);
        if (accessToken != null) {
            return "redirect:/export-success";
        } else {
            return "redirect:/export-failure";
        }
    }

    
@PostMapping("/insert-event")
@ResponseBody
public String insertEvent(@RequestBody Map<String, String> requestData) {
    String code = requestData.get("code");
    String personId = requestData.get("personId");
    System.out.println("Code: " + code);
    System.out.println("Person ID: " + personId);

    if (code != null && personId != null) {
        String accessToken = googleAuthService.getAccessToken(code);
        if (accessToken != null) {
            // Récupérer les événements de traitement
            List<AnimalEvent> traitementEvents = evenementAnimalServiceImpl.getTraitementsAnimauxPersonne(Integer.parseInt(personId));
            System.out.println("Traitement Events:");
            if (!traitementEvents.isEmpty()) {
                for (AnimalEvent event : traitementEvents) {
                    System.out.println(event.getDate() + " " + event.getHeure() + " " + event.getTitre());
                    // Insérer cet événement dans Google Calendar
                    String eventId = googleAuthService.insertEvent(accessToken, event.getTitre(), event.getDate(), event.getHeure());
                    if (eventId != null) {
                        System.out.println("Événement de traitement inséré avec succès avec l'ID : " + eventId);
                    } else {
                        System.out.println("Échec de l'insertion de l'événement de traitement");
                    }
                }
            } else {
                System.out.println("Aucun événement de traitement à insérer.");
            }

            // Récupérer les événements de vaccination
            List<AnimalEvent> vaccinationEvents = evenementAnimalServiceImpl.getVaccinationsAnimauxPersonne(Integer.parseInt(personId));
            System.out.println("Vaccination Events:");
            if (!vaccinationEvents.isEmpty()) {
                for (AnimalEvent event : vaccinationEvents) {
                    System.out.println(event.getDate() + " " + event.getHeure() + " " + event.getTitre());
                    // Insérer cet événement dans Google Calendar
                    String eventId = googleAuthService.insertEvent(accessToken, event.getTitre(), event.getDate(), event.getHeure());
                    if (eventId != null) {
                        System.out.println("Événement de vaccination inséré avec succès avec l'ID : " + eventId);
                    } else {
                        System.out.println("Échec de l'insertion de l'événement de vaccination");
                    }
                }
            } else {
                System.out.println("Aucun événement de vaccination à insérer.");
            }

            return "Événements insérés avec succès pour la personne : " + personId;
        } else {
            return "Échec de l'obtention de l'access token";
        }
    } else {
        return "Paramètres manquants dans la requête";
    }
}

}
