package com.nanterre.LoveMyPet.controller;

import com.nanterre.LoveMyPet.model.Animal;
import com.nanterre.LoveMyPet.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/adoption")
public class AdoptionController {

    private final AnimalService animalService;

    @Autowired
    public AdoptionController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/animaux")
    public List<String> getAdoptionUrlsForAnimals() {
        return animalService.getAdoptionUrlsForAnimals();
    }

    //récupération des détails d'un animal adopté
    @GetMapping("/animal/{id}")
    public Animal getAnimalDetailsById(@PathVariable Integer id) {
        return animalService.getAnimalDetailsById(id);
    }
}
