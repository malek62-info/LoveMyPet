package com.nanterre.LoveMyPet.controller;

import com.nanterre.LoveMyPet.model.Animal;
import com.nanterre.LoveMyPet.model.AnimalPerdu;
import com.nanterre.LoveMyPet.service.AnimalPerduService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnimalPerduController {

    @Autowired
    private AnimalPerduService animalPerduService;

    @GetMapping("/animals-within-radius")
    public List<Animal> getAnimalsWithinRadius(@RequestParam double latitude, @RequestParam double longitude) {
        return animalPerduService.getAnimalsWithinRadius(latitude, longitude);
    }
}