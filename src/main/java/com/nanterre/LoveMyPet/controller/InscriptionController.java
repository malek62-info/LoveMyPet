package com.nanterre.LoveMyPet.controller;

import com.nanterre.LoveMyPet.model.Evenement;
import com.nanterre.LoveMyPet.model.Inscription;
import com.nanterre.LoveMyPet.model.Person;
import com.nanterre.LoveMyPet.repository.EvenementRepository;
import com.nanterre.LoveMyPet.repository.InscriptionRepository;
import com.nanterre.LoveMyPet.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inscription")
public class InscriptionController {

    @Autowired
    private InscriptionRepository inscriptionRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private EvenementRepository evenementRepository;

    @PostMapping("/add")
    public String addInscription(@RequestParam Integer idEvenement, @RequestParam Integer idPerson) {
        try {
            // Fetch Person and Evenement from repositories
            Person person = personRepository.findById(idPerson).orElse(null);
            Evenement evenement = evenementRepository.findById(idEvenement).orElse(null);

            if (person != null && evenement != null) {
                // Create a new Inscription
                Inscription inscription = new Inscription();
                inscription.setPersonne(person);
                inscription.setEvenement(evenement);

                // Save the Inscription to the database
                inscriptionRepository.save(inscription);

                return "Inscription added successfully!";
            } else {
                return "Person or Evenement not found!";
            }
        } catch (Exception e) {
            return "Error adding inscription: " + e.getMessage();
        }
    }
}