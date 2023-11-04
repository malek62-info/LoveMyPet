package com.nanterre.LoveMyPet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GeneralController {

    @GetMapping("/adoption")
    public String showAdoptionPage(Model model) {
        // Ajoutez ici la logique pour récupérer les données à afficher dans la page HTML "adoption.html".
        // model.addAttribute("animals", animalService.getAvailableAnimals());
        return "adoption"; // Assurez-vous d'avoir un fichier HTML nommé "adoption.html" dans le dossier src/main/resources/templates.
    }

}
