package com.nanterre.LoveMyPet.controller;

import com.nanterre.LoveMyPet.model.HistoriqueAdoption;
import com.nanterre.LoveMyPet.service.HistoriqueAdoptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/historiqueadoption")
public class HistoriqueAdoptionController {

    @Autowired
    private HistoriqueAdoptionService historiqueAdoptionService;

    @PostMapping("/ajouteradoption")
    public ResponseEntity<String> ajouterAdoption(@RequestBody Map<String, Object> requestBody) {
        Integer idAnimal = (Integer) requestBody.get("idAnimal");
        Integer idPerson = (Integer) requestBody.get("idPerson");
        String endDateString = (String) requestBody.get("endDate");

        if (idAnimal != null && idPerson != null && endDateString != null) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date endDate = dateFormat.parse(endDateString);

                historiqueAdoptionService.ajouterAdoption(idAnimal, idPerson, endDate);
                return ResponseEntity.ok("L'adoption a été ajoutée avec succès.");
            } catch (ParseException e) {
                return ResponseEntity.badRequest().body("Le format de la date endDate est incorrect.");
            }
        } else {
            return ResponseEntity.badRequest().body("Les identifiants de l'animal, de la personne et la date endDate sont nécessaires.");
        }
    }
}
