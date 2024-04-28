package com.nanterre.LoveMyPet.controller;

import com.nanterre.LoveMyPet.model.AnimalVu;
import com.nanterre.LoveMyPet.service.AnimalVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnimalVuController {

    private final AnimalVuService animalVuService;

    @Autowired
    public AnimalVuController(AnimalVuService animalVuService) {
        this.animalVuService = animalVuService;
    }

    @PostMapping("/api/animalvu/ajouter")
    public void ajouterAnimalVu(@RequestBody AnimalVu animalVu) {
        animalVuService.ajouterAnimalVu(animalVu);
    }
}
