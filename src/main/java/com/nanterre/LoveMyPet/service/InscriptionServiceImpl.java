package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.Evenement;
import com.nanterre.LoveMyPet.model.Inscription;
import com.nanterre.LoveMyPet.model.Person;
import com.nanterre.LoveMyPet.repository.EvenementRepository;
import com.nanterre.LoveMyPet.repository.InscriptionRepository;
import com.nanterre.LoveMyPet.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscriptionServiceImpl implements InscriptionService {

    @Autowired
    private InscriptionRepository inscriptionRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private EvenementRepository evenementRepository;

    @Override
    public void addInscription(Integer idEvenement, Integer idPerson) {
        Person person = personRepository.findById(idPerson).orElse(null);
        Evenement evenement = evenementRepository.findById(idEvenement).orElse(null);

        if (person != null && evenement != null) {
            Inscription inscription = new Inscription();
            inscription.setPersonne(person);
            inscription.setEvenement(evenement);

            inscriptionRepository.save(inscription);
        }
    }




    // Add other service methods as needed
}
