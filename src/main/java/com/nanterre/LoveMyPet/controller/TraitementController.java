package com.nanterre.LoveMyPet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nanterre.LoveMyPet.model.Heure;
import com.nanterre.LoveMyPet.model.Traitement;
import com.nanterre.LoveMyPet.service.TraitementService;

import java.util.List;

@RestController
@RequestMapping("/traitement")
public class TraitementController {
    @Autowired
    private TraitementService traitementService;

    @GetMapping("/animal/{idAnimal}")
    public List<String> getTraitementLinksByAnimalId(@PathVariable Integer idAnimal) {
        return traitementService.getTraitementLinksByAnimalId(idAnimal);
    }

    @GetMapping("/{idTraitement}")
    public Traitement getTraitementDetailsById(@PathVariable Integer idTraitement) {
        return traitementService.getTraitementDetailsById(idTraitement);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addTraitement(@RequestBody Traitement traitement) {
        traitementService.saveTraitement(traitement);
        return ResponseEntity.ok("Nouveau traitement ajouté");
    }
 // Ajouter une heure à un traitement
    @PostMapping("/{idTraitement}/heure")
    public ResponseEntity<String> ajouterHeure(@PathVariable Integer idTraitement, @RequestBody Heure heure) {
        traitementService.ajouterHeure(idTraitement, heure);
        return ResponseEntity.ok("Heure ajoutée avec succès");
    }

    // Récupérer les heures associées à un traitement
    @GetMapping("/{idTraitement}/heures")
    public ResponseEntity<List<Heure>> getHeuresByTraitementId(@PathVariable Integer idTraitement) {
        List<Heure> heures = traitementService.getHeuresByTraitementId(idTraitement);
        return ResponseEntity.ok(heures);
    }

    // Mettre à jour une heure associée à un traitement
    @PutMapping("/heure/{idHeure}")
    public ResponseEntity<String> updateHeure(@PathVariable Integer idHeure, @RequestBody Heure newHeure) {
        traitementService.updateHeure(idHeure, newHeure);
        return ResponseEntity.ok("Heure mise à jour avec succès");
    }
}
