package com.nanterre.LoveMyPet.service;

import java.util.List;

import com.nanterre.LoveMyPet.model.AnimalPerdu;

public interface AnimalPerduService {
    AnimalPerdu ajouterAnimalPerdu(Integer idAnimal, double latitude, double longitude);
    List<AnimalPerdu> findAnimalsLostByPersonId(Integer idPerson);
    void supprimerAnimalPerdu(Integer idAnimal);

}