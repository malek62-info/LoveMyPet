package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.Animal;

import java.util.List;

public interface AnimalService {
    List<String> getAnimalLinksByPersonId(Integer idPerson);

    Animal getAnimalDetailsById(Integer id);

    List<String> getAdoptionUrlsForAnimals();

    public Animal saveAnimal(Animal animal);
    public Animal findAnimalById(Integer id);
    void updateAnimalPerson(Integer idAnimal, Integer newPersonId);


    interface FeedingConfirmationService {
        public boolean confirmFeeding(Integer personId, Integer animalId, Integer feedingTimeId, String confirmationCode);
    }
}

