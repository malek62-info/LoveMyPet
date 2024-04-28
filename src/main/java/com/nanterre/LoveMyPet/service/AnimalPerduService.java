package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.AnimalPerdu;
import com.nanterre.LoveMyPet.model.AnimalVu;

public interface AnimalPerduService {
    AnimalPerdu ajouterAnimalPerdu(Integer idAnimal, double latitude, double longitude);
    boolean animalExisteDeja(Integer idAnimal);

}
