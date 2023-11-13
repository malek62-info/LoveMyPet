package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.Animal;
import com.nanterre.LoveMyPet.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;

@Service

public class AnimalServiceImpl implements AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    @Override
    public Iterable<Animal> getAvailableAnimals() {
        return animalRepository.findByAdoptedFalse();
    }

    @Override
    public Iterable<Animal> searchAnimalsByKeyword(String keyword) {
        return animalRepository.searchByKeyword(keyword);
    }

    @Override
    public Iterable<Animal> filterAnimals(Date dateOfBirth, Double weight, String race, String category, Integer gender) {
        return animalRepository.filterAnimals(dateOfBirth, weight, race, category, gender);
    }

    @Override
    public Iterable<Animal> getUserAnimals(Integer userId) {
        System.out.println("Fetching animals for user with ID: " + userId);
        Iterable<Animal> animals = animalRepository.findAllByIdPersonAndAdopted(userId, true);
        System.out.println("Fetched animals: " + animals);
        return animals;
    }
}
