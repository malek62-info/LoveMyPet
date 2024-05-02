package com.nanterre.LoveMyPet.service;

import java.util.List;

import com.nanterre.LoveMyPet.model.Animal;


public interface AnimalPerduService {
     List<Animal> getAnimalsWithinRadius(double latitude, double longitude) ;

}