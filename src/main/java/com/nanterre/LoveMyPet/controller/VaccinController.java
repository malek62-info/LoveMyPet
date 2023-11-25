package com.nanterre.LoveMyPet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nanterre.LoveMyPet.model.Vaccin;
import com.nanterre.LoveMyPet.service.VaccinService;

@RestController
@RequestMapping("/vaccin")
public class VaccinController {
    private final VaccinService vaccinService;

    @Autowired
    public VaccinController(VaccinService vaccinService) {
        this.vaccinService = vaccinService;
    }

    @GetMapping("/all")
    public Iterable<Vaccin> getAllVaccins() {
        return vaccinService.getAllVaccins();
    }
    
}
