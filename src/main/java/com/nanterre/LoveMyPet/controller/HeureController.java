package com.nanterre.LoveMyPet.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.nanterre.LoveMyPet.model.Heure;
import com.nanterre.LoveMyPet.model.Traitement;
import com.nanterre.LoveMyPet.service.HeureService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/heure")
public class HeureController {

    @Autowired
    private HeureService heureService;

    @PostMapping("/add/{idTraitement}")
    public ResponseEntity<Map<String, String>> ajouterHeure(@PathVariable Integer idTraitement, @RequestBody List<String> heures) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Map<String, String> response = new HashMap<>();

        try {
            for (String heureString : heures) {
                Date heure = dateFormat.parse(heureString);
                heureService.ajouterHeure(idTraitement, heure);
            }
            response.put("message", "Heures ajoutées avec succès");
            return ResponseEntity.ok(response);
        } catch (ParseException e) {
            response.put("message", "Format d'heure invalide.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }


    @GetMapping("/list/{idTraitement}")
    public ResponseEntity<List<Heure>> getHeuresByTraitementId(@PathVariable Integer idTraitement) {
        List<Heure> heures = heureService.getHeuresByTraitementId(idTraitement);
        return ResponseEntity.ok(heures);
    }

    @PutMapping("/update/{idHeure}")
    public ResponseEntity<String> updateHeure(@PathVariable Integer idHeure, @RequestBody Date newHeure) {
        heureService.updateHeure(idHeure, newHeure);
        return ResponseEntity.ok("Heure mise à jour avec succès");
    }
}