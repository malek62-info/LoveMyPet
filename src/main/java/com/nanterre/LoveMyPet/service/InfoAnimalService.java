package com.nanterre.LoveMyPet.service;


import com.nanterre.LoveMyPet.model.Animal;
import java.util.List;

public interface InfoAnimalService {
    Animal getInfoAnimalDetailsById (Integer idAnimal);
    void updateAnimalName(Integer idAnimal, String newName);
    void updateAnimalWeight(Integer idAnimal, Double newWeight);
}
