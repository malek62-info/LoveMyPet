package com.nanterre.LoveMyPet.controller;

import jakarta.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.nanterre.LoveMyPet.model.Animal;
import com.nanterre.LoveMyPet.service.InfoAnimalServiceImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/infoanimal")
public class InfoAnimalController {
	@Autowired
    private InfoAnimalServiceImpl infoAnimalService;
    
    @GetMapping("/{idAnimal}")
    public Animal getCandidatureDetailsById(@PathVariable Integer idAnimal) {
        return infoAnimalService.getInfoAnimalDetailsById(idAnimal);
    }
    @PostMapping("/updateName/{idAnimal}")
    public ResponseEntity<String> updateAnimalName(@PathVariable Integer idAnimal, @RequestBody Map<String, String> requestBody) {
        String newName = requestBody.get("newName");

        if (newName != null && !newName.isEmpty()) {
            infoAnimalService.updateAnimalName(idAnimal, newName);
            return ResponseEntity.ok("Le nom de l'animal a été mis à jour avec succès.");
        } else {
            return ResponseEntity.badRequest().body("Le nouveau nom ne peut pas être vide.");
        }
    }

    @PostMapping("/updateWeight/{idAnimal}")
    public ResponseEntity<String> updateAnimalWeight(@PathVariable Integer idAnimal, @RequestBody Map<String, Double> requestBody) {
        Double newWeight = requestBody.get("newWeight");

        if (newWeight != null) {
            infoAnimalService.updateAnimalWeight(idAnimal, newWeight);
            return ResponseEntity.ok("Le poids de l'animal a été mis à jour avec succès.");
        } else {
            return ResponseEntity.badRequest().body("Le nouveau poids ne peut pas être vide.");
        }
    }
    
}





