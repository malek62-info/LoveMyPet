package com.nanterre.LoveMyPet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.nanterre.LoveMyPet.model.Heure;
import com.nanterre.LoveMyPet.model.Traitement;
import com.nanterre.LoveMyPet.service.TraitementService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/traitement")
public class TraitementController {
    @Autowired
    private TraitementService traitementService;

    @GetMapping("/animal/{idAnimal}")
    public List<String> getTraitementLinksByAnimalId(@PathVariable Integer idAnimal) {
        return traitementService.getTraitementLinksByAnimalId(idAnimal);
    }

    @GetMapping("/{idTraitement}")
    public Traitement getTraitementDetailsById(@PathVariable Integer idTraitement) {
        return traitementService.getTraitementDetailsById(idTraitement);
    }

    @PostMapping("/add")
    public ResponseEntity<Map<String, Object>> addTraitement(@RequestPart("ordonnanceFile") MultipartFile ordonnanceFile, Traitement traitement) {
        Map<String, Object> response = new HashMap<>();
        try {
            if (ordonnanceFile != null && !ordonnanceFile.isEmpty()) {
                // Spécifiez le chemin de votre dossier d'images dans les ressources
                String dossierImages = "src/main/resources/static/images/ordonnances";
                String nomDuFichier = ordonnanceFile.getOriginalFilename();

                // Vérifiez si nomDuFichier est nul avant de remplacer les espaces
                if (nomDuFichier != null) {
                    nomDuFichier = nomDuFichier.replaceAll("\\s", "-");
                }

                Path cheminFichier = Paths.get(dossierImages, nomDuFichier);

                // Écrivez le fichier image dans le dossier spécifié
                Files.write(cheminFichier, ordonnanceFile.getBytes());

                // Assurez-vous que l'URL stockée dans la base de données est relative
                // et compatible avec le chemin des ressources statiques
                String urlRelative = nomDuFichier;
                traitement.setFichierUrl(urlRelative);
            }

            // Sauvegardez le traitement dans la base de données
            Traitement savedTraitement = traitementService.saveTraitement(traitement);

            // Récupérez l'ID du traitement nouvellement ajouté
            Integer traitementId = savedTraitement.getIdTraitement();

            // Ajoutez l'ID du traitement à la réponse
            response.put("id", traitementId);

            // Retournez la réponse avec l'ID du traitement
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            e.printStackTrace();
            response.put("error", "Erreur lors de la gestion de l'image");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        } catch (Exception e) {
            e.printStackTrace();
            response.put("error", "Erreur lors de l'ajout du traitement");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
    
    

    // Récupérer les heures associées à un traitement
    @GetMapping("/{idTraitement}/heures")
    public ResponseEntity<List<Heure>> getHeuresByTraitementId(@PathVariable Integer idTraitement) {
        Traitement traitement = traitementService.getTraitementDetailsById(idTraitement);
        if (traitement != null) {
            List<Heure> heures = traitement.getHeures();
            return ResponseEntity.ok(heures);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    
    @GetMapping("/details/{idTraitement}")
    public ResponseEntity<Traitement> getTraitementDetails(@PathVariable Integer idTraitement) {
        Traitement traitement = traitementService.getTraitementDetailsById(idTraitement);
        if (traitement != null) {
            return ResponseEntity.ok(traitement);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
