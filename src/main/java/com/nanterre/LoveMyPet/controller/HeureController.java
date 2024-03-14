package com.nanterre.LoveMyPet.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.nanterre.LoveMyPet.model.Heure;
import com.nanterre.LoveMyPet.model.Traitement;
import com.nanterre.LoveMyPet.repository.HeureRepository;
import com.nanterre.LoveMyPet.service.HeureService;
import com.nanterre.LoveMyPet.service.TraitementService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/heure")
public class HeureController {
	 @Autowired
	    private HeureRepository heureRepository;
	@Autowired
    private TraitementService traitementService;
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

    
    @PutMapping("/modifier/{idTraitement}")
    public ResponseEntity<String> modifierHeuresTraitement(@PathVariable Integer idTraitement, @RequestBody List<String> heures) {
        try {
            // Récupérer le traitement correspondant à l'ID
            Traitement traitement = traitementService.getTraitementDetailsById(idTraitement);
            
            if (traitement == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aucun traitement trouvé pour l'ID spécifié : " + idTraitement);
            }
            
            // Supprimer les heures existantes associées à ce traitement
            List<Heure> heuresExistantes = heureRepository.findByTraitement(traitement);
            heureRepository.deleteAll(heuresExistantes);

            // Formater les heures en objets Date et les associer au traitement
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm", Locale.FRANCE);
            for (String heureStr : heures) {
                Date heureDate = dateFormat.parse(heureStr);
                Heure nouvelleHeure = new Heure();
                nouvelleHeure.setHeure(heureDate);
                nouvelleHeure.setTraitement(traitement);
                heureRepository.save(nouvelleHeure);
            }

            return ResponseEntity.ok("Heures de traitement mises à jour avec succès");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la mise à jour des heures de traitement");
        }
    }




    
   

    






}