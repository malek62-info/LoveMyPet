package com.nanterre.LoveMyPet.service;


import java.util.List;

public interface EvenementAnimalService {
    List<AnimalEvent> getVaccinationsAnimauxPersonne(Integer idPersonne);
    List<AnimalEvent> getTraitementsAnimauxPersonne(Integer idPersonne);
}

