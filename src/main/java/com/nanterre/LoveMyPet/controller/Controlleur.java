package com.nanterre.LoveMyPet.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class Controlleur {
	
	
		@GetMapping("/suivi")
    	public String showVaccinations(Model model) {
        return "suivi";
		}
        @GetMapping("/mesCandidatures")
    	public String showCandidatures(Model model) {
        return "mescandidatures";
    }


	   
	    
	}


