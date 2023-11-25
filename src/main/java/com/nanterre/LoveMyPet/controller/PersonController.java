package com.nanterre.LoveMyPet.controller;

import com.nanterre.LoveMyPet.model.Adoption;
import com.nanterre.LoveMyPet.model.Candidature;
import com.nanterre.LoveMyPet.model.Person;
import com.nanterre.LoveMyPet.service.CandidatureService;
import com.nanterre.LoveMyPet.service.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServiceImpl personService;
    @Autowired
    private CandidatureService candidatureService;

    @GetMapping("/{id}")
    public Person getPersonDetailsById(@PathVariable Integer id) {
        return personService.getPersonDetailsById(id);
    }


    @PostMapping("/addcandidature")
    public ResponseEntity<String> addCandidature(
            @RequestParam("idPerson") Integer idPerson,
            @RequestParam("idAdoption") Integer idAdoption,
            @RequestParam("dateCandidature") String dateCandidature) {
        try {
            // Création d'une candidature avec les données reçues
            Candidature candidature = new Candidature();
            candidature.setDateCandidature(new Date());

            // Utilisation des ID reçus
            Person person = new Person();
            person.setId(idPerson);
            candidature.setPerson(person);

            Adoption adoption = new Adoption();
            adoption.setIdAdoption(idAdoption);
            candidature.setAdoption(adoption);

            // Enregistrement de la candidature
            candidatureService.saveCandidature(candidature);

            return new ResponseEntity<>("Candidature ajoutée avec succès", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Erreur lors de l'ajout de la candidature", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
