package com.nanterre.LoveMyPet.service;


import java.util.List;

import com.nanterre.LoveMyPet.model.Animal;

import com.nanterre.LoveMyPet.model.AnimalPerdu;
import com.nanterre.LoveMyPet.model.AnimalVu;




public interface AnimalPerduService {
    AnimalPerdu ajouterAnimalPerdu(Integer idAnimal, double latitude, double longitude);
    boolean animalExisteDeja(Integer idAnimal);

    List<Animal> getAnimalsWithinRadius(double latitude, double longitude) ;
    List<AnimalPerdu> findAnimalsLostByPersonId(Integer idPerson);
    void supprimerAnimalPerdu(Integer idAnimal);
}

