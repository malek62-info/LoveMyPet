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
    
    @GetMapping("/infoAnimal")
    public String infoAnimal() {
        return "infoanimal";
    }

    /* Feeding */

    	  
    @GetMapping("/choicetime")
    public String TimeChoiceAnimal(){
        return "TimeChoiceAnimal.html";
    }


    @GetMapping("/alertes_new")
    public String alertes_new(){
        return "alertes_new";
    }


    @GetMapping("/Veterinaires")
    public String map() {
        return "Veterinaires";
    }

    @GetMapping("/parc")
    public String parc() {
        return "parc";
    }

    @GetMapping("/Map")
    public String donate() {
        return "Map";
    }


    /*publication */
       @GetMapping("/publications")
    public String publication() {
        return "publications";
    }
}
