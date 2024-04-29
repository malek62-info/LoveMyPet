package com.nanterre.LoveMyPet.service;


import com.nanterre.LoveMyPet.model.AnimalVu;

import java.util.List;

public interface AnimalVuService {

    void ajouterAnimalVu(AnimalVu animalVu);

    List<AnimalVu> getAnimalCoordsById(Integer idAnimal);



}
