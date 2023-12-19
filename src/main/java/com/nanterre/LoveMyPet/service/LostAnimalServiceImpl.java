package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.LostAnimal;
import com.nanterre.LoveMyPet.repository.LostAnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LostAnimalServiceImpl implements LostAnimalService {

    @Autowired
    private LostAnimalRepository lostAnimalRepository;

    @Override
    public List<LostAnimal> getAllLostAnimals() {
        return lostAnimalRepository.findAll();
    }

    @Override
    public LostAnimal saveLostAnimal(LostAnimal lostAnimal) {
        return lostAnimalRepository.save(lostAnimal);
    }

    // Implémente d'autres méthodes de service selon les besoins

}
