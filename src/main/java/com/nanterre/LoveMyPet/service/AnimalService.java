package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.Animal;

import org.springframework.stereotype.Service;

import java.util.Date;

public interface AnimalService {
    Iterable<Animal> getAvailableAnimals();

    Iterable<Animal> searchAnimalsByKeyword(String keyword);

    Iterable<Animal> filterAnimals(Date dateOfBirth, Double weight, String race, String category, Integer gender);

    Iterable<Animal> getUserAnimals(Integer userId);

}

