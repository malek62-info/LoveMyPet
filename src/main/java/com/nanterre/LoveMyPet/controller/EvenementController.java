package com.nanterre.LoveMyPet.controller;

import com.nanterre.LoveMyPet.model.Evenement;
import com.nanterre.LoveMyPet.model.Inscription;
import com.nanterre.LoveMyPet.model.Person;
import com.nanterre.LoveMyPet.service.EvenementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/evenements")
public class EvenementController {

    private final EvenementService evenementService;

    public EvenementController(EvenementService evenementService) {
        this.evenementService = evenementService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addEvenement(@RequestPart("imageFile") MultipartFile imageFile,
                                               @ModelAttribute Evenement evenement) {


        try {
            if (imageFile != null && !imageFile.isEmpty()) {
                // Spécifiez le chemin de votre dossier d'images dans les ressources
                String imageFolderPath = "src/main/resources/static/evenements";
                String fileName = imageFile.getOriginalFilename();
                Path filePath = Paths.get(imageFolderPath, fileName);

                // Écrivez le fichier image dans le dossier spécifié
                Files.write(filePath, imageFile.getBytes());

                // Set the image URL in the event object
                evenement.setImageUrl(fileName);
            }
        } catch (IOException e) {
            // Utilisez un logger pour enregistrer l'erreur
            return new ResponseEntity<>("Erreur lors de la gestion de l'image", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        evenementService.createEvenement(evenement);
        return new ResponseEntity<>("Nouvel événement ajouté", HttpStatus.OK);
    }



    @GetMapping("/non-expired")
    public ResponseEntity<List<String>> getNonExpiredEventLinks() {
        LocalDate today = LocalDate.now();
        List<Evenement> nonExpiredEvents = evenementService.findNonExpiredEvents(today);

        List<String> eventLinks = nonExpiredEvents.stream()
                .map(evenement -> "/api/evenements/non-expired/" + evenement.getIdEvenement())
                .collect(Collectors.toList());

        return ResponseEntity.ok(eventLinks);
    }
    @GetMapping("/non-expired/{eventId}")
    public ResponseEntity<Map<String, Object>> getNonExpiredEventById(@PathVariable Integer eventId) {
        Evenement evenement = evenementService.getEvenementById(eventId);

        if (evenement == null) {
            return ResponseEntity.notFound().build();
        }

        Map<String, Object> evenementMap = toEvenementMapWithLinks(evenement);

        return ResponseEntity.ok(evenementMap);
    }

    private Map<String, Object> toEvenementMapWithLinks(Evenement evenement) {
        Map<String, Object> evenementMap = new HashMap<>();
        evenementMap.put("idEvenement", evenement.getIdEvenement());
        evenementMap.put("titre", evenement.getTitre());
        evenementMap.put("date", evenement.getDate().toString());
        evenementMap.put("place", evenement.getPlace());
        evenementMap.put("imageName", evenement.getImageUrl());

        // Ajouter des liens hypertextes
        evenementMap.put("details", "/api/evenements/non-expired/" + evenement.getIdEvenement());

        return evenementMap;
    }

    @GetMapping("/user-events")
    public ResponseEntity<List<Map<String, Object>>> getUserEvents(@RequestParam("userId") Integer userId) {
        // Vérifier si l'ID de l'utilisateur est valide
        if (userId != null) {
            // Récupérer les événements de l'utilisateur depuis le service
            List<Evenement> userEvents = evenementService.getUserEvents(userId);

            // Convertir les événements en une liste de maps
            List<Map<String, Object>> eventList = userEvents.stream()
                    .map(this::toEvenementMapWithLinks)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(eventList);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }



}
