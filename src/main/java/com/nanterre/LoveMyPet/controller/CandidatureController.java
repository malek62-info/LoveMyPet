package com.nanterre.LoveMyPet.controller;

import com.nanterre.LoveMyPet.model.Candidature;
import com.nanterre.LoveMyPet.service.CandidatureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animal/{animalId}/candidature")
public class CandidatureController {
    @Autowired
    private CandidatureServiceImpl candidatureService;

    @GetMapping("/{candidatureId}")
    public Candidature getCandidatureDetailsByAnimalIdAndCandidatureId(
            @PathVariable Integer animalId,
            @PathVariable Integer candidatureId) {
        return candidatureService.getCandidatureDetailsByAnimalIdAndCandidatureId(animalId, candidatureId);
    }
}




