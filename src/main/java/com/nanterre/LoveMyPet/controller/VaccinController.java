package com.nanterre.LoveMyPet.controller;

import com.nanterre.LoveMyPet.model.Vaccin;
import com.nanterre.LoveMyPet.service.VaccinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vaccin")
public class VaccinController {

    @Autowired
    private VaccinService vaccinService;

    @PostMapping("/loadData")
    public String loadDataFromJson() {
        vaccinService.loadDataFromJson("src/main/resources/Json/Vaccin.json");
        return "Data loaded successfully from JSON file!";
    }



    @GetMapping("/names")
    public ResponseEntity<List<String>> getAllVaccinNames() {
        List<String> vaccinNames = vaccinService.getAllVaccinNames();
        return ResponseEntity.ok().body(vaccinNames);
    }


}



