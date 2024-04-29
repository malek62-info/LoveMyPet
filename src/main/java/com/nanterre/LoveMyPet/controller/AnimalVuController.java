package com.nanterre.LoveMyPet.controller;

import com.nanterre.LoveMyPet.service.AnimalVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
