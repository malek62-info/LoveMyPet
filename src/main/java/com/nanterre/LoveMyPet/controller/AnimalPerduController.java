package com.nanterre.LoveMyPet.controller;


import com.nanterre.LoveMyPet.model.Animal;
import com.nanterre.LoveMyPet.model.AnimalPerdu;
import com.nanterre.LoveMyPet.service.AnimalPerduService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.nanterre.LoveMyPet.model.AnimalPerdu;
import com.nanterre.LoveMyPet.service.AnimalPerduService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import java.util.List;







@RestController
@RequestMapping("/api/animalperdu")
public class AnimalPerduController {

    private final AnimalPerduService animalPerduService;

    @Autowired
    public AnimalPerduController(AnimalPerduService animalPerduService) {
        this.animalPerduService = animalPerduService;
    }


    @GetMapping("/animals-within-radius")
    public List<Animal> getAnimalsWithinRadius(@RequestParam double latitude, @RequestParam double longitude) {
        return animalPerduService.getAnimalsWithinRadius(latitude, longitude);
    }


    @PostMapping("/ajouter")
    public ResponseEntity<?> ajouterAnimalPerdu(@RequestBody AnimalPerdu animalPerdu) {
        try {
            /*Vérifiez d'abord si l'animal n'existe pas déjà
            if (animalPerduService.animalExisteDeja(animalPerdu.getIdAnimal())) {
                return new ResponseEntity<>("L'animal existe déjà.", HttpStatus.BAD_REQUEST);
            }*/

            // Ajoutez l'animal perdu si ce n'est pas déjà existant
            AnimalPerdu nouvelAnimalPerdu = animalPerduService.ajouterAnimalPerdu(animalPerdu.getIdAnimal(), animalPerdu.getLatitude(), animalPerdu.getLongitude());
            return new ResponseEntity<>(nouvelAnimalPerdu, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Erreur lors de l'ajout de l'animal perdu.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/verifier/{animalId}")
    public ResponseEntity<?> verifierAnimalPerdu(@PathVariable Integer animalId) {
        try {
            // Vérifiez si l'animal est déjà déclaré perdu
            boolean declarePerdu = animalPerduService.animalExisteDeja(animalId);
            Map<String, Boolean> response = new HashMap<>();
            response.put("declarePerdu", declarePerdu);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Erreur lors de la vérification de l'animal perdu.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}

