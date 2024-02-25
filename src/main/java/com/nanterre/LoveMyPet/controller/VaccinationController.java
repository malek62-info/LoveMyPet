package com.nanterre.LoveMyPet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nanterre.LoveMyPet.model.Vaccination;
import com.nanterre.LoveMyPet.service.VaccinationService;

@RestController
@RequestMapping("/vaccination")
public class VaccinationController {

    @Autowired
    private VaccinationService vaccinationService;

    @PostMapping("/add")
    public ResponseEntity<String> addVaccination(@RequestBody Vaccination vaccination) {
        vaccinationService.addVaccination(vaccination);
        return ResponseEntity.ok("Vaccination added successfully");
    }
}
