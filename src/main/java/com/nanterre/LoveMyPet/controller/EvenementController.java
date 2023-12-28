package com.nanterre.LoveMyPet.controller;
import com.nanterre.LoveMyPet.model.Evenement;
import com.nanterre.LoveMyPet.model.Person;
import com.nanterre.LoveMyPet.service.EvenementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/evenements")
public class EvenementController {

    private final EvenementService evenementService;

    public EvenementController(EvenementService evenementService) {
        this.evenementService = evenementService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addEvenement(@RequestPart("imageFile") MultipartFile imageFile,
                                               @RequestParam("titre") String titre,
                                               @RequestParam("date") String dateStr,
                                               @RequestParam("place") String place,
                                               @RequestParam("createurId") Integer createurId) {
        try {
            LocalDate date = LocalDate.parse(dateStr);

            Evenement evenement = new Evenement();
            evenement.setTitre(titre);
            evenement.setDate(date);
            evenement.setPlace(place);

            // Settez directement l'ID du créateur sans vérifier son existence
            Person createur = new Person();
            createur.setIdPerson(createurId);
            evenement.setCreateur(createur);

            if (imageFile != null && !imageFile.isEmpty()) {
                String dossierImages = "src/main/resources/static/images/evenements";
                String nomDuFichier = imageFile.getOriginalFilename();
                Path cheminFichier = Paths.get(dossierImages, nomDuFichier);

                Files.write(cheminFichier, imageFile.getBytes());
                evenement.setImageUrl(nomDuFichier);
            }

            evenementService.createEvenement(evenement);
            return new ResponseEntity<>("Nouvel événement ajouté", HttpStatus.OK);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Erreur lors de la gestion de l'image", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/non-expired/{eventId}")
    public ResponseEntity<Map<String, Object>> getNonExpiredEventById(@PathVariable Integer eventId) {
        Evenement evenement = evenementService.getEvenementById(eventId);

        if (evenement == null) {
            return ResponseEntity.notFound().build();
        }

        Map<String, Object> evenementMap = toEvenementMapWithLinks(evenement);

        return ResponseEntity.ok(evenementMap);
    }

    private Map<String, Object> toEvenementMapWithLinks(Evenement evenement) {
        Map<String, Object> evenementMap = new HashMap<>();
        evenementMap.put("idEvenement", evenement.getIdEvenement());
        evenementMap.put("titre", evenement.getTitre());
        evenementMap.put("date", evenement.getDate().toString());
        evenementMap.put("place", evenement.getPlace());

        // Ajouter des liens hypertextes
        evenementMap.put("details", "/api/evenements/non-expired/" + evenement.getIdEvenement());

        return evenementMap;
    }
}
