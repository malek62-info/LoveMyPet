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
	@GetMapping("/suivicomplet")
    public String suivicomplet(Model model) {
		return "suivicomplet";
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
    
    @GetMapping("/HistoriqueWeight")
    public String HistoriqueWeightGraph() {
        return "graphePoids";
    }
    
    


    /*Donation */

    @GetMapping("/donate")
    public String additems() {
        return "additems";
    }

    @GetMapping("/showdonations")
    public String itemstodonate() {
        return "itemstodonate";
    }

     @GetMapping("/mesdonations")
    public String mesdonations() {
        return "mesdonations";
    }

    @GetMapping("/itemspage")
    public String itemspage() {
        return "itemspage";
    }

    

    @GetMapping("/AddEvent")
    public String Evennement() {
        return "AddEvennement";
    }

    @GetMapping("/ShowEvent")
    public String Listevent() {
        return "ListEvents";
    }



    @GetMapping("/Addvaccin")
    public String Addvaccin() {
        return "Addvaccin";
    }

    @GetMapping("/updatevaccination")
    public String updatevaccination() {
        return "updatevaccination";
    }
}
