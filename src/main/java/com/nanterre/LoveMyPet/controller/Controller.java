package com.nanterre.LoveMyPet.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/adoption")
    public String showAdoptionPage(Model model) {
        return "adoption";
    }

    @GetMapping("/mesanimaux")
    public String showAnimals(Model model) {
        return "mesanimaux";
    }
    
    @GetMapping("/HomePage")
    public String homePage() {
        return "home";
    }
  	  
    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }

    @GetMapping("/animal")
    public String showAnimal(Model model) {
        return "animal";
    }

}
