package com.nanterre.LoveMyPet.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.nanterre.LoveMyPet.model.Animal;
import com.nanterre.LoveMyPet.model.Vaccin;
import com.nanterre.LoveMyPet.model.Vaccination;
import com.nanterre.LoveMyPet.service.VaccinationService;
import com.nanterre.LoveMyPet.service.VaccinationServiceImpl;

import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/vaccination")
public class VaccinationController {
    @Autowired
    private VaccinationServiceImpl vaccinationService;
    
    @GetMapping("animal/{idAnimal}")
    public List<String> getVaccinationReferenceByAnimalId(@PathVariable Integer idAnimal) {
    	return vaccinationService.getVaccinationLinksByAnimalId(idAnimal);
    }
    @GetMapping("/{idVaccination}")
    public Vaccination getVaccinationDetailsById(@PathVariable Integer idVaccination) {
        return vaccinationService.getVaccinationDetailsById(idVaccination);
    }
    
    @PostMapping("/add")
    public String add( Vaccination vaccination,
    		@RequestParam(name = "animal") Integer animalId) {
        vaccinationService.saveVaccination(vaccination);
        return "Nouvelle vaccination ajoutée";
    }
}