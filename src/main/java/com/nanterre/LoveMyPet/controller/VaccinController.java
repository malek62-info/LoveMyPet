package com.nanterre.LoveMyPet.controller;

import com.nanterre.LoveMyPet.model.Vaccin;
import com.nanterre.LoveMyPet.service.VaccinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vaccin")
public class VaccinController {

    @Autowired
    private VaccinService vaccinService;
    @Autowired
    public VaccinController(VaccinService vaccinService) {
        this.vaccinService = vaccinService;
    }
    @GetMapping("/vaccins")
    public ResponseEntity<List<String>> getAllVaccins() {
        List<String> vaccinReferences = vaccinService.getAllVaccinReferences();
        return ResponseEntity.ok().body(vaccinReferences);
    }
    @GetMapping("/vaccins/{id}")
    public ResponseEntity<Vaccin> getVaccinById(@PathVariable Integer id) {
        Vaccin vaccin = vaccinService.getVaccinById(id);
        if (vaccin != null) {
            return ResponseEntity.ok().body(vaccin);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}