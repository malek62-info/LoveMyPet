package com.nanterre.LoveMyPet.controller;

import com.nanterre.LoveMyPet.model.AnimalPerdu;
import com.nanterre.LoveMyPet.service.AnimalPerduService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/animalperdu")
public class AnimalPerduController {

    private final AnimalPerduService animalPerduService;

    @Autowired
    public AnimalPerduController(AnimalPerduService animalPerduService) {
        this.animalPerduService = animalPerduService;
    }

    @PostMapping("/ajouter")
    public ResponseEntity<?> ajouterAnimalPerdu(@RequestBody AnimalPerdu animalPerdu) {
        try {
            // Vérifiez d'abord si l'animal n'existe pas déjà
            if (animalPerduService.animalExisteDeja(animalPerdu.getIdAnimal())) {
                return new ResponseEntity<>("L'animal existe déjà.", HttpStatus.BAD_REQUEST);
            }

            // Ajoutez l'animal perdu si ce n'est pas déjà existant
            AnimalPerdu nouvelAnimalPerdu = animalPerduService.ajouterAnimalPerdu(animalPerdu.getIdAnimal(), animalPerdu.getLatitude(), animalPerdu.getLongitude());
            return new ResponseEntity<>(nouvelAnimalPerdu, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Erreur lors de l'ajout de l'animal perdu.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
