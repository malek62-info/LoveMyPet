package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.LostAnimal;

import java.util.List;

public interface LostAnimalService {
    List<LostAnimal> getAllLostAnimals();
    LostAnimal saveLostAnimal(LostAnimal lostAnimal);
    // Ajoute d'autres méthodes de service selon les besoins
}
