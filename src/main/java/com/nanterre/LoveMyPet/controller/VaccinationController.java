package com.nanterre.LoveMyPet.controller;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nanterre.LoveMyPet.model.Vaccination;
import com.nanterre.LoveMyPet.service.VaccinationService;



import java.util.List;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class VaccinationController {

    @Autowired
    private VaccinationService vaccinationService;

    // les références des vaccination de l'animal 1 par ex
    @GetMapping("/vaccinations/{idAnimal}")
    public ResponseEntity<List<String>> getVaccinationsByAnimalId(@PathVariable("idAnimal") Integer idAnimal) {
        List<String> vaccinations = vaccinationService.getVaccinationsByAnimalId(idAnimal);
        if (vaccinations.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(vaccinations, HttpStatus.OK);
    }

    // details d'une vaccination
    @GetMapping("/vaccination/{idVaccination}")
    public ResponseEntity<Vaccination> getVaccinationDetails(@PathVariable("idVaccination") Integer idVaccination) {
        Optional<Vaccination> vaccinationOptional = vaccinationService.getVaccinationById(idVaccination);
        if (vaccinationOptional.isPresent()) {
            return new ResponseEntity<>(vaccinationOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}