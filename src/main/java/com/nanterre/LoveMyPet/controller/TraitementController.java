package com.nanterre.LoveMyPet.controller;

import com.nanterre.LoveMyPet.model.Traitement;
import com.nanterre.LoveMyPet.service.TraitementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TraitementController {

    @Autowired
    private TraitementService traitementService;

    //liste des traitements de IdAnimal
    @GetMapping("/traitements/{animalId}")
    public List<String> getTraitementsByAnimalId(@PathVariable Integer animalId) {
        return traitementService.getTraitementsByAnimalId(animalId);
    }

    //detail traitement
    @GetMapping("/traitement/{traitementId}")
    public ResponseEntity<?> getTraitementById(@PathVariable Integer traitementId) {
        Optional<Traitement> traitementOptional = traitementService.getTraitementById(traitementId);
        if (traitementOptional.isPresent()) {
            return ResponseEntity.ok(traitementOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aucun traitement trouvé pour l'identifiant " + traitementId);
        }
    }
}
