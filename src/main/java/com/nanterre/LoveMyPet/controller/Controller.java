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

    @GetMapping("/candidature")
    public String showCandidatureByAnimalId ( Model model) {
        return "candidatureadoption";
    }
    
	@GetMapping("/suivi")
    public String showVaccinations(Model model) {
		return "suivi";
	}
    @GetMapping("/mesCandidatures")
    public String showCandidatures(Model model) {
        return "mescandidatures";
    }

    @GetMapping("/AddPerson")
    public String showpage() {
        return "AddPersonne";
    }
    
    @GetMapping("/AddAnimal")
    public String showpageaddAnimal() {
        return "AddAnimal";
    }
    
    @GetMapping("/login")
    public String showpagelogin() {
        return "login";
    }

    @GetMapping("/")
    public String homePage() {
        return "home";
    }
	  
    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }



}
