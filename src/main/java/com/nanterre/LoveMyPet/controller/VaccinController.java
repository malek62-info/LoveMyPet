package com.nanterre.LoveMyPet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nanterre.LoveMyPet.model.Vaccin;
import com.nanterre.LoveMyPet.service.VaccinService;



@RestController
@RequestMapping("/vaccin")
public class VaccinController {

    @Autowired
    private VaccinService vaccinService;
 
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
