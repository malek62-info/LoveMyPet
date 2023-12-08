package com.nanterre.LoveMyPet.controller;

import com.nanterre.LoveMyPet.model.Candidature;
import com.nanterre.LoveMyPet.service.CandidatureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animal/{animalId}/candidature")
public class CandidatureController {
    @Autowired
    private CandidatureServiceImpl candidatureService;

    @GetMapping("/{candidatureId}")
    public Candidature getCandidatureDetailsByAnimalIdAndCandidatureId(
            @PathVariable Integer animalId,
            @PathVariable Integer candidatureId) {
        return candidatureService.getCandidatureDetailsByAnimalIdAndCandidatureId(animalId, candidatureId);
    }
    @DeleteMapping("/{candidatureId}")
    public ResponseEntity<String> deleteCandidature(
            @PathVariable Integer animalId,
            @PathVariable Integer candidatureId) {
        Candidature candidature = candidatureService.getCandidatureDetailsByAnimalIdAndCandidatureId(animalId, candidatureId);
        
        if (candidature != null) {
            candidatureService.deleteCandidature(candidature);
            return ResponseEntity.ok("Candidature supprimée avec succès");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}




