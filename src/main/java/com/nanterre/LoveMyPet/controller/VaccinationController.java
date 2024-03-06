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
    public ResponseEntity<Vaccination> getVaccination_Details(@PathVariable("idVaccination") Integer idVaccination) {
        Vaccination vaccination = vaccinationService.getVaccinationById(idVaccination);
        if (vaccination != null) {
            return new ResponseEntity<>(vaccination, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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




    @PostMapping("vaccination/add")
    public ResponseEntity<String> addVaccination(@RequestBody Vaccination vaccination) {
        vaccinationService.addVaccination(vaccination);
        return ResponseEntity.ok("Vaccination added successfully");

    }



    @PutMapping("vaccination/update/{id}")
    public ResponseEntity<Vaccination> updateVaccination(@PathVariable Integer id, @RequestBody Vaccination vaccinationDetails) {
        Vaccination updatedVaccination = vaccinationService.updateVaccination(id, vaccinationDetails);
        if (updatedVaccination != null) {
            return ResponseEntity.ok(updatedVaccination);
        } else {
            return ResponseEntity.notFound().build();
        }
    }





}


