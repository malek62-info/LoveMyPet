package com.nanterre.LoveMyPet.controller;

import com.nanterre.LoveMyPet.model.Adoption;
import com.nanterre.LoveMyPet.model.Animal;
import com.nanterre.LoveMyPet.model.Candidature;
import com.nanterre.LoveMyPet.service.AdoptionService;
import com.nanterre.LoveMyPet.service.AnimalService;
import com.nanterre.LoveMyPet.service.AnimalServiceImpl;
import com.nanterre.LoveMyPet.service.CandidatureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/animal")
public class AnimalController {
    @Autowired
    private AnimalServiceImpl animalService;

    @Autowired
    private AdoptionService adoptionService;
    @Autowired
    private CandidatureServiceImpl candidatureService;

    @PostMapping("/add")
    public ResponseEntity<String> addAnimal(@RequestPart("imageFile") MultipartFile imageFile, Animal animal) {
        if (imageFile != null && !imageFile.isEmpty()) {
            try {
                // Spécifiez le chemin de votre dossier d'images dans les ressources
                String dossierImages = "src/main/resources/static/images/animals";
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

    // récuperre la liste des références d'animaux d'une person ( Idperson)
    @GetMapping("/person/{idPerson}")
    public List<String> getAnimalsReferenceByPersonId(@PathVariable Integer idPerson) {
        return animalService.getAnimalLinksByPersonId(idPerson);
    }

    @GetMapping("/{id}")
    public Animal getAnimalDetailsById(@PathVariable Integer id) {
        return animalService.getAnimalDetailsById(id);
    }

    // candidature pour adopter un animal
    @GetMapping("/{animalId}/candidatures")
    public List<String> getCandidaturesByAnimalId(@PathVariable Integer animalId) {
        return candidatureService.getCandidatureLinksByAnimalId(animalId);
    }

    @PostMapping("/addadoption")
    public ResponseEntity<Map<String, String>> addAdoption(@RequestBody Adoption adoption) {
        try {
            // Si la date de fin est nulle, définissez-la sur "0000-01-01" ou une autre
            // valeur par défaut
            if (adoption.getEndDate() == null) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date defaultEndDate = dateFormat.parse("0000-01-01"); // Utilisez la date que vous préférez

                adoption.setEndDate(defaultEndDate);
            }

            // Vous pouvez également définir ici l'ID de l'animal, par exemple,
            // adoption.setIdAnimal(1);
            // Votre logique d'ajout d'adoption
            adoptionService.saveAdoption(adoption);

            Map<String, String> response = new HashMap<>();
            response.put("message", "Nouvelle adoption ajoutée");

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "Erreur lors de l'ajout de l'adoption");

            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
