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
    @PostMapping("/updateImage/{idAnimal}")
    public ResponseEntity<String> updateAnimalImage(@PathVariable Integer idAnimal, @RequestParam("imageFile") MultipartFile imageFile) {
        if (imageFile != null && !imageFile.isEmpty()) {
            try {
                String dossierImages = "src/main/resources/static/images/animals";
                String nomDuFichier = imageFile.getOriginalFilename();
                Path cheminFichier = Paths.get(dossierImages, nomDuFichier);

                Files.write(cheminFichier, imageFile.getBytes());

                // Mettez à jour l'URL de l'image de l'animal dans la base de données
                infoAnimalService.updateAnimalImage(idAnimal, nomDuFichier);

                return ResponseEntity.ok("L'image de l'animal a été mise à jour avec succès.");
            } catch (IOException e) {
                e.printStackTrace();
                return new ResponseEntity<>("Erreur lors de la gestion de l'image", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return ResponseEntity.badRequest().body("Le fichier image ne peut pas être vide.");
        }
    }
    
}





