package com.nanterre.LoveMyPet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.nanterre.LoveMyPet.model.Animal;
import com.nanterre.LoveMyPet.service.AnimalService;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/animal")
@CrossOrigin
public class AnimalController {
    @Autowired
    private AnimalService animalService;

    @PostMapping("/add")
    public ResponseEntity<String> addAnimal(@RequestPart("imageFile") MultipartFile imageFile, Animal animal) {
        if (imageFile != null && !imageFile.isEmpty()) {
            try { animal.setAdopted(true);
                // Spécifiez le chemin de votre dossier d'images dans les ressources
                String dossierImages = "C:\\Users\\malek\\Desktop\\LoveMyPetV2\\LoveMyPet\\src\\main\\resources\\AnimalImages";
                String nomDuFichier = imageFile.getOriginalFilename();
                Path cheminFichier = Paths.get(dossierImages, nomDuFichier);

                // Écrivez le fichier image dans le dossier spécifié
                Files.write(cheminFichier, imageFile.getBytes());

                // Stockez le nom du fichier image dans la base de données
                animal.setImageUrl(nomDuFichier);

                // Votre code de gestion du fichier image ici
            } catch (IOException e) {
                e.printStackTrace();
                return new ResponseEntity<>("Erreur lors de la gestion de l'image", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        // Enregistrez l'animal avec le nom du fichier de l'image (si applicable)
        animalService.saveAnimal(animal);
        return new ResponseEntity<>("Nouvel animal ajouté", HttpStatus.OK);
    }
}
