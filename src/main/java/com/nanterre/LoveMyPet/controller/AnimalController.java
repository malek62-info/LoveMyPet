package com.nanterre.LoveMyPet.controller;

import com.nanterre.LoveMyPet.model.Animal;
import com.nanterre.LoveMyPet.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/*
@Controller
public class AnimalController {
    @Autowired
    private AnimalService animalService;

    @GetMapping("/adoption")
    public String showAvailableAnimals(Model model, @RequestParam(name = "age", required = false) Integer age,
                                       @RequestParam(name = "weight", required = false) Double weight,
                                       @RequestParam(name = "race", required = false) String race,
                                       @RequestParam(name = "category", required = false) String category,
                                       @RequestParam(name = "keyword", required = false) String keyword) {
        Iterable<Animal> animals;

        if (keyword != null && !keyword.isEmpty()) {
            // Faites appel à la méthode de service pour rechercher les animaux par mot-clé
            animals = animalService.searchAnimalsByKeyword(keyword);
        } else if (age != null || weight != null || race != null || category != null) {
            // Faites appel à la méthode de service pour filtrer les animaux
            animals = animalService.filterAnimals(age, weight, race, category);
        } else {
            animals = animalService.getAvailableAnimals();
        }

        if (!animals.iterator().hasNext()) {
            model.addAttribute("errorMessage", "Aucun animal correspondant n'a été trouvé.");
        }

        model.addAttribute("animals", animals);
        return "adoption"; // Assurez-vous d'avoir une page HTML nommée "adoption" pour afficher les résultats.
    }
}
*/

@RestController
@RequestMapping("/api")
public class AnimalController {
    @Autowired
    private AnimalService animalService;

    @GetMapping("/adoption")
    public Iterable<Animal> showAvailableAnimals(
            @RequestParam(name = "age", required = false) Integer age,
            @RequestParam(name = "weight", required = false) Double weight,
            @RequestParam(name = "race", required = false) String race,
            @RequestParam(name = "category", required = false) String category,
            @RequestParam(name = "keyword", required = false) String keyword) {
        Iterable<Animal> animals;

        if (keyword != null && !keyword.isEmpty()) {
            animals = animalService.searchAnimalsByKeyword(keyword);
        } else if (age != null || weight != null || race != null || category != null) {
            animals = animalService.filterAnimals(age, weight, race, category);
        } else {
            animals = animalService.getAvailableAnimals();
        }

        return animals;
    }
}
