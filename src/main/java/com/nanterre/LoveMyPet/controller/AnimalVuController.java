package com.nanterre.LoveMyPet.controller;


import com.nanterre.LoveMyPet.service.AnimalVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nanterre.LoveMyPet.model.AnimalVu;
import com.nanterre.LoveMyPet.service.AnimalVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class AnimalVuController {

    private final AnimalVuService animalVuService;

    @Autowired
    public AnimalVuController(AnimalVuService animalVuService) {
        this.animalVuService = animalVuService;
    }


    @GetMapping("/emails-by-animal-vue")
    public ResponseEntity<Object> getEmailsByAnimalVue() {
        return ResponseEntity.ok(animalVuService.getEmailsByAnimalVue());
    }

    @PostMapping("/api/animalvu/ajouter")
    public void ajouterAnimalVu(@RequestBody AnimalVu animalVu) {
        animalVuService.ajouterAnimalVu(animalVu);
    }


    @GetMapping("/coords/{idAnimal}") // Utilisez le même nom de paramètre que dans la méthode du service
    public List<AnimalVu> getAnimalCoordsById(@PathVariable Integer idAnimal) {
        return animalVuService.getAnimalCoordsById(idAnimal);
    }




}
