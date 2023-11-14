package com.nanterre.LoveMyPet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class Controlleur {
	
	
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
	    
	    @GetMapping("/profile")
	    public String profile() {
	        return "profile";
	    }

	   
	    
	}


