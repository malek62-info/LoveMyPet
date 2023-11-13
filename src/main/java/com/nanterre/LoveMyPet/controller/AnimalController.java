package com.nanterre.LoveMyPet.controller;

import com.nanterre.LoveMyPet.model.Animal;
import com.nanterre.LoveMyPet.service.AnimalService;
import com.nanterre.LoveMyPet.service.AnimalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;


@RestController
@RequestMapping("/animal")
public class AnimalController {
    @Autowired
    private AnimalServiceImpl animalService;

    @GetMapping("/adoption")
    public Iterable<Animal> showAvailableAnimals(
            @RequestParam(name = "dateOfBirth", required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateOfBirth,
            @RequestParam(name = "weight", required = false) Double weight,
            @RequestParam(name = "race", required = false) String race,
            @RequestParam(name = "category", required = false) String category,
            @RequestParam(name = "gender", required = false) Integer gender,
            @RequestParam(name = "keyword", required = false) String keyword) {
        Iterable<Animal> animals;

        if (keyword != null && !keyword.isEmpty()) {
            animals = animalService.searchAnimalsByKeyword(keyword);
        } else if (atLeastOneFilterPresent(dateOfBirth, weight, race, category, gender)) {
            animals = animalService.filterAnimals(dateOfBirth, weight, race, category, gender);
        } else {
            animals = animalService.getAvailableAnimals();
        }

        return animals;
    }
    private boolean atLeastOneFilterPresent(Date dateOfBirth, Double weight, String race, String category, Integer gender) {
        return dateOfBirth != null || weight != null || race != null || category != null || gender != null;
    }

    @GetMapping("/useranimals")
    public Iterable<Animal> showUserAnimals(
            @RequestParam(name = "userId") Integer userId) {
        return animalService.getUserAnimals(userId);
    }

}
