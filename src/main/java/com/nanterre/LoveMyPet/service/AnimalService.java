package com.nanterre.LoveMyPet.service;


import com.nanterre.LoveMyPet.model.Animal;

public interface AnimalService {
    public Animal saveAnimal(Animal animal);
    public Animal findAnimalById(Integer id);


}