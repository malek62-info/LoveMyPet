package com.nanterre.LoveMyPet.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nanterre.LoveMyPet.model.FeedingTime;
import com.nanterre.LoveMyPet.service.implementations.FeedingTimeServiceImpl;
import java.time.LocalTime;

@RestController
@RequestMapping("/api/feeding-times")
public class FeedingTimeController {

    @Autowired
    private FeedingTimeServiceImpl feedingTimeService;

    // Ajouter un horaire d'alimentation
    @PostMapping("/add")
    public ResponseEntity<String> ajouterHoraireAlimentation(@RequestBody FeedingTime feedingTime) {
        try {
            feedingTimeService.addFeedingTime(feedingTime);
            return ResponseEntity.ok("Horaire d'alimentation ajouté avec succès.");
        } catch (RuntimeException e) {
            // Capture l'exception spécifique (FeedingTimeConflictException) et renvoie un
            // message approprié
            if (e.getMessage().contains("Feeding time already exists for the same animal at the specified time.")) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Cet horaire est déjà planifié pour l'animal.");
            } else {
                // Gère d'autres exceptions de manière générique
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur interne du serveur.");
            }
        }
    }

    // la liste des feedingtime d'un animal
    @GetMapping("/{idAnimal}")
    public List<String> getFeedingTimesReferenceByAnimalId(@PathVariable Integer idAnimal) {
        return feedingTimeService.getAnimalFeedingTimesReferences(idAnimal);
    }

    // detail d'un feedingtime

    @GetMapping("/time/{id}")
    public ResponseEntity<FeedingTime> getFeedingTimeDetails(@PathVariable Integer id) {
        FeedingTime feedingTime = feedingTimeService.getFeedingTimeDetailsById(id);

        if (feedingTime != null) {
            return ResponseEntity.ok().body(feedingTime);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // supprimer
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFeedingTime(@PathVariable Integer id) {
        try {
            feedingTimeService.deleteFeedingTime(id);
            return ResponseEntity.ok("L'heure a étét supprimer");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting feeding time.");
        }
    }

    // Mettre à jour l'heure d'alimentation
    @PutMapping("update/{id}")
    public ResponseEntity<?> updateFeedingTime(
            @PathVariable Integer id,
            @RequestBody FeedingTime updatedFeedingTime) {

        try {
            feedingTimeService.updateFeedingTime(id, updatedFeedingTime);
            return new ResponseEntity<>("Mise à jour réussie.", HttpStatus.OK);
        } catch (RuntimeException e) {
            // Retourne uniquement le message d'erreur dans la réponse
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
