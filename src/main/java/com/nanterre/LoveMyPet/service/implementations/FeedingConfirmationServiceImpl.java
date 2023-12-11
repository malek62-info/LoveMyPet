package com.nanterre.LoveMyPet.service.implementations;

import com.nanterre.LoveMyPet.model.Animal;
import com.nanterre.LoveMyPet.model.FeedingConfirmation;
import com.nanterre.LoveMyPet.model.FeedingTime;
import com.nanterre.LoveMyPet.model.Person;
import com.nanterre.LoveMyPet.repository.AnimalRepository;
import com.nanterre.LoveMyPet.repository.FeedingConfirmationRepository;
import com.nanterre.LoveMyPet.repository.FeedingTimeRepository;
import com.nanterre.LoveMyPet.repository.PersonRepository;
import com.nanterre.LoveMyPet.service.interfaces.FeedingConfirmationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class FeedingConfirmationServiceImpl implements FeedingConfirmationService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private FeedingTimeRepository feedingTimeRepository;

    @Autowired
    private FeedingConfirmationRepository feedingConfirmationRepository;

    @Override
    public boolean confirmFeeding(Integer personId, Integer animalId, Integer feedingTimeId, String confirmationCode) {
        // Logique de confirmation

        // Vérifier si une confirmation existe déjà
        if (feedingConfirmationRepository.existsByPersonIdAndAnimalIdAndFeedingTimeId(personId, animalId, feedingTimeId, confirmationCode)) {
            // Si une confirmation existe déjà, ne rien faire
            return false;  // Confirmation échouée
        }

        // Enregistrez la confirmation dans la base de données
        FeedingConfirmation feedingConfirmation = new FeedingConfirmation();
        feedingConfirmation.setPersonId(personId);
        feedingConfirmation.setAnimalId(animalId);
        feedingConfirmation.setFeedingTimeId(feedingTimeId);
        feedingConfirmation.setConfirmationCode(confirmationCode);

        // Définir la date de confirmation comme la date actuelle
        feedingConfirmation.setConfirmationDate(new Date());

        feedingConfirmationRepository.save(feedingConfirmation);

        return true;  // Confirmation réussie
    }


}



