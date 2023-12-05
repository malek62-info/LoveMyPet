package com.nanterre.LoveMyPet.controller;

import com.nanterre.LoveMyPet.model.Adoption;
import com.nanterre.LoveMyPet.model.Animal;
import com.nanterre.LoveMyPet.service.AnimalService;
import com.nanterre.LoveMyPet.service.AnimalServiceImpl;
import com.nanterre.LoveMyPet.service.AdoptionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/adoption")
public class AdoptionController {

    private final AdoptionServiceImpl adoptionService;
    private final AnimalServiceImpl animalService;

    @Autowired
    public AdoptionController(AnimalServiceImpl animalService , AdoptionServiceImpl adoptionService) {
        this.animalService = animalService;
        this.adoptionService = adoptionService;
    }


    @GetMapping("adoptions")
    public List<String> getAllAdoptionUrls() {
        return adoptionService.getAllAdoptionUrls();
    }


   @GetMapping("/{idAdoption}")
    public Map<String, Object> getAdoptionDetails(@PathVariable Integer idAdoption) {
        return adoptionService.getAdoptionDetails(idAdoption);
    }

    @DeleteMapping("/{idAdoption}")
   public ResponseEntity<String> deleteAdoption(@PathVariable Integer idAdoption) {
       adoptionService.deleteAdoption(idAdoption);
       return ResponseEntity.ok("L'adoption a été supprimée avec succès.");
   }










}
