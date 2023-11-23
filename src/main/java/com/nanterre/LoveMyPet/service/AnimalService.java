package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.Adoption;
import com.nanterre.LoveMyPet.model.Animal;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

public interface AnimalService {
    List<String> getAnimalLinksByPersonId(Integer idPerson);

    Animal getAnimalDetailsById(Integer id);

    List<String> getAdoptionUrlsForAnimals();


}

