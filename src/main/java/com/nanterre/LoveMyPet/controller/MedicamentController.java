package com.nanterre.LoveMyPet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nanterre.LoveMyPet.model.Medicament;
import com.nanterre.LoveMyPet.service.MedicamentService;

@RestController
@RequestMapping("/medicament")
public class MedicamentController {
    private final MedicamentService medicamentService;

    @Autowired
    public MedicamentController(MedicamentService medicamentService) {
        this.medicamentService = medicamentService;
    }

    @GetMapping("/all")
    public Iterable<Medicament> getAllMedicaments() {
        return medicamentService.getAllMedicaments();
    }
    
}
