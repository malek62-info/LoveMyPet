package com.nanterre.LoveMyPet.controller;

import com.nanterre.LoveMyPet.model.Animal;
import com.nanterre.LoveMyPet.model.Candidature;
import com.nanterre.LoveMyPet.service.AnimalService;
import com.nanterre.LoveMyPet.service.AnimalServiceImpl;
import com.nanterre.LoveMyPet.service.CandidatureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/animal")
public class AnimalController {
    @Autowired
    private AnimalServiceImpl animalService;

    @Autowired
    private CandidatureServiceImpl candidatureService;

    //récuperre la liste des références d'animaux d'une person ( Idperson)
    @GetMapping("/person/{idPerson}")
    public List<String> getAnimalsReferenceByPersonId(@PathVariable Integer idPerson) {
        return animalService.getAnimalLinksByPersonId(idPerson);
    }

    @GetMapping("/{id}")
    public Animal getAnimalDetailsById(@PathVariable Integer id) {
        return animalService.getAnimalDetailsById(id);
    }

    //candidature pour adopter un animal
    @GetMapping("/{animalId}/candidatures")
    public List<String> getCandidaturesByAnimalId(@PathVariable Integer animalId) {
        return candidatureService.getCandidatureLinksByAnimalId(animalId);
    }
}
