package com.nanterre.LoveMyPet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller

public class Controleur {
	
	
	// pour afficher la page qui permet de faire la calcule
	    @GetMapping("/Calcule") // cette page on a choisier d'ajouer le /Calculer pour la 
	    public String showpage() {
	        return "Calculer";
	    }
	    
	    // cette methode permer de fair le calculer et elle retourne la page avec le resultat affiché
	    @PostMapping("/Calcule")// Cette annotation spécifie que cette méthode gère les requêtes POST envoyées à l'URL "/calcule"
	    // cette annotation on la trouve dans le la commeande Post dans le fichier HTML.
	    public String calculate(int num1, int num2, Model model) {
	        int result = num1 + num2;
	        model.addAttribute("result", num1 + " + " + num2 + " = " + result);
	        return "Calculer";
	    }   
	    
	}


