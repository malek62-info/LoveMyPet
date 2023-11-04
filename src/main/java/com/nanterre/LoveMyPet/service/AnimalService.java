package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.Animal;
import com.nanterre.LoveMyPet.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {
    @Autowired
    private AnimalRepository animalRepository;

    public Iterable<Animal> getAvailableAnimals() {
        return animalRepository.findByAdoptedFalse();
    }

    public Iterable<Animal> searchAnimalsByKeyword(String keyword) {
        return animalRepository.searchByKeyword(keyword);
    }

    public Iterable<Animal> filterAnimals(Integer age, Double weight, String race, String category) {
        return animalRepository.filterAnimals(age, weight, race, category);
    }
}

