package com.nanterre.LoveMyPet.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.nanterre.LoveMyPet.model.Person;
import com.nanterre.LoveMyPet.service.PersonService;

import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/person")
@CrossOrigin
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping("/add")
    public String add(@RequestPart("imageFile") MultipartFile imageFile, Person person) {
        // Vérifiez si l'e-mail existe déjà dans la base de données
        Person existingPerson = personService.findPersonByEmail(person.getEmail());
        if (existingPerson != null) {
            return "L'e-mail existe déjà";
        }

        if (imageFile != null && !imageFile.isEmpty()) {
            try {
                // Spécifiez le chemin de votre dossier d'images dans les ressources
                String dossierImages = "C:\\Users\\malek\\Desktop\\LoveMyPetV2\\LoveMyPet\\src\\main\\resources\\PeronImages";
                String nomDuFichier = imageFile.getOriginalFilename();
                Path cheminFichier = Paths.get(dossierImages, nomDuFichier);

                // Écrivez le fichier image dans le dossier spécifié
                Files.write(cheminFichier, imageFile.getBytes());

                // Stockez le nom du fichier image dans la base de données
                person.setImageUrl(nomDuFichier);

                // Votre code de gestion du fichier image ici
            } catch (IOException e) {
                e.printStackTrace();
                return "Erreur lors de la gestion de l'image";
            }
        }

        // Enregistrez la personne avec le nom du fichier de l'image (si applicable)
        personService.savePerson(person);
        return "Nouvelle personne ajoutée";
    }

    
    

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session) {
        Person user = personService.findPersonByEmail(email);

        if (user != null && user.getPassword() != null && user.getPassword().equals(password)) {
            // Authentification réussie, stockez les informations dans la session
            session.setAttribute("userId", user.getIdPerson());
            session.setAttribute("email", email);
            return ResponseEntity.ok("Authentification réussie");
        } else {
            // Authentification échouée
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentification échouée");
        }
    }

    @GetMapping("/profile")
    public ResponseEntity<?> userProfile(HttpSession session) {
        Integer userId = (Integer) session.getAttribute("userId");
        String email = (String) session.getAttribute("email");

        if (userId == null || email == null) {
            // Utilisateur non connecté
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Utilisateur non connecté");
        }

        // Récupérez d'autres informations de l'utilisateur depuis la base de données si nécessaire
        Person user = personService.findPersonByEmail(email);

        if (user != null) {
            Integer id = user.getIdPerson();
            String name = user.getFirstName() + " " + user.getLastName();
            
            Map<String, Object> userData = new HashMap<>();
            userData.put("id", id);
            userData.put("name", name);

            return ResponseEntity.ok(userData);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Utilisateur non trouvé");
        }
    }



}
