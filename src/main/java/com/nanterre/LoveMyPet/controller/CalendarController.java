package com.nanterre.LoveMyPet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nanterre.LoveMyPet.service.GoogleAuthService;

import java.time.LocalDate;

@Controller
public class CalendarController {

    @Autowired
    private GoogleAuthService googleAuthService;

    @GetMapping("/export-calendar")
    public String exportCalendar() {
        return "redirect:" + googleAuthService.getAuthorizationUrl();
    }

    @GetMapping("/oauth2callback")
    public String oauth2Callback(@RequestParam("code") String code) {
        String accessToken = googleAuthService.getAccessToken(code);
        if (accessToken != null) {
            // Exporter les événements du calendrier en utilisant l'access token
            // Une fois l'exportation terminée, vous pouvez invalider l'access token ou effacer toute information d'authentification stockée
            return "redirect:/export-success";
        } else {
            // Gérer l'erreur d'authentification
            return "redirect:/export-failure";
        }
    }

    @GetMapping("/insert-event")
    @ResponseBody
    public String insertEvent(@RequestParam("code") String code) {
        String accessToken = googleAuthService.getAccessToken(code);
        if (accessToken != null) {
            String eventSummary = "Example Event";
            LocalDate eventDate = LocalDate.of(2024, 3, 24); // Format de date : YYYY-MM-DD
            String eventId = googleAuthService.insertEvent(accessToken, eventSummary, eventDate);
            if (eventId != null) {
                return "Événement inséré avec succès avec l'ID : " + eventId;
            } else {
                return "Échec de l'insertion de l'événement";
            }
        } else {
            return "Échec de l'obtention de l'access token";
        }
    }
}
