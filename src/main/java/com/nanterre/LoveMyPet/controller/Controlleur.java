package com.nanterre.LoveMyPet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class Controlleur {
	
	
	// pour afficher la page qui permet de faire la calcule
	    @GetMapping("/std") // cette page on a choisier d'ajouer le /Calculer pour la 
	    public String showpage() {
	        return "AddPersonne";
	    }
	    
	 // pour afficher la page qui permet de faire la calcule
	    @GetMapping("/AddAnimal") // cette page on a choisier d'ajouer le /Calculer pour la 
	    public String showpageaddAnimal() {
	        return "AddAnimal";
	    }
	    
	 // pour afficher la page qui permet de faire la calcule
	    @GetMapping("/login") // cette page on a choisier d'ajouer le /Calculer pour la 
	    public String showpagelogin() {
	        return "login";
	    }
	    
	    @GetMapping("/profile")
	    public String profile() {
	        return "profile";
	    }

	   
	    
	}


