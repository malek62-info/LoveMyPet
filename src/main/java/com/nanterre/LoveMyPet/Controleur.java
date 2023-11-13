package com.nanterre.LoveMyPet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller

public class Controleur {
	
	
  @GetMapping("/HomePage")
  public String homePage() {
      return "home";
  }
	  
  @GetMapping("/profile")
  public String profile() {
      return "profile";
  }
}