package com.nanterre.LoveMyPet.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.nanterre.LoveMyPet.model.Animal;
import com.nanterre.LoveMyPet.model.HistoriqueWeight;
import com.nanterre.LoveMyPet.service.HistoriqueWeightService;
import com.nanterre.LoveMyPet.service.HistoriqueWeightServiceImpl;

import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/historiqueWeight")
public class HistoriqueWeightController {
    @Autowired
    private HistoriqueWeightServiceImpl historiqueWeightService;
    
    @GetMapping("animal/{idAnimal}")
    public List<String> getVaccinationReferenceByAnimalId(@PathVariable Integer idAnimal) {
    	return historiqueWeightService.getHistoriqueWeightLinksByAnimalId(idAnimal);
    }
    @GetMapping("/{id}")
    public HistoriqueWeight getHistoriqueWeightDetailsById(@PathVariable Integer id) {
        return historiqueWeightService.getHistoriqueWeightDetailsById(id);
    }
    @GetMapping("/data/{idAnimal}")
    public ResponseEntity<List<HistoriqueWeight>> getHistoriqueWeightDataByAnimalId(@PathVariable Integer idAnimal) {
        List<HistoriqueWeight> historiqueWeights = historiqueWeightService.getHistoriqueWeightByAnimalId(idAnimal);
        return new ResponseEntity<>(historiqueWeights, HttpStatus.OK);
    }
}