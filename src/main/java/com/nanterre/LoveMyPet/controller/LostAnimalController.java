package com.nanterre.LoveMyPet.controller;

import com.nanterre.LoveMyPet.model.LostAnimal;
import com.nanterre.LoveMyPet.service.LostAnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.List;


@RestController
@RequestMapping("/lost-animal")
public class LostAnimalController {

    @Autowired
    private LostAnimalService lostAnimalService;

    @PostMapping("/add")
    public ResponseEntity<String> addLostAnimal(@RequestPart("imageFile") MultipartFile imageFile, LostAnimal lostAnimal) {
        if (imageFile != null && !imageFile.isEmpty()) {
            try {
                String imagesDirectory = "src/main/resources/static/images/lost-animals";
                String fileName = imageFile.getOriginalFilename();
                Path filePath = Paths.get(imagesDirectory, fileName);

                Files.write(filePath, imageFile.getBytes());

                lostAnimal.setImageUrl(fileName);
            } catch (IOException e) {
                e.printStackTrace();
                return new ResponseEntity<>("Erreur lors de la gestion de l'image", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        lostAnimalService.saveLostAnimal(lostAnimal);
        return new ResponseEntity<>("Nouvel animal perdu ajouté", HttpStatus.OK);
    }

    @GetMapping("/list")
    public List<LostAnimal> getAllLostAnimals() {
        return lostAnimalService.getAllLostAnimals();
    }

    // Ajoute d'autres méthodes de contrôleur selon les besoins

}
