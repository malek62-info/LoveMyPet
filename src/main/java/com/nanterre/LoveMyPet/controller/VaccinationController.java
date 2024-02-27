package com.nanterre.LoveMyPet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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



    @PutMapping("/update/{id}")
    public ResponseEntity<Vaccination> updateVaccination(@PathVariable Integer id, @RequestBody Vaccination vaccinationDetails) {
        Vaccination updatedVaccination = vaccinationService.updateVaccination(id, vaccinationDetails);
        if (updatedVaccination != null) {
            return ResponseEntity.ok(updatedVaccination);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    @GetMapping("/details/{id}")
    public ResponseEntity<Vaccination> getVaccinationDetails(@PathVariable Integer id) {
        Vaccination vaccination = vaccinationService.getVaccinationById(id);
        if (vaccination != null) {
            return new ResponseEntity<>(vaccination, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
