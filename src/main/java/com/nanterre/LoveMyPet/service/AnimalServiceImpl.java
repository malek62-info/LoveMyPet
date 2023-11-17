package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.Animal;
import com.nanterre.LoveMyPet.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class AnimalServiceImpl implements AnimalService {

   @Autowired
    private AnimalRepository animalRepository;
 /*
    @Override
    public Iterable<Animal> getAvailableAnimals() {
        return animalRepository.findByAdoptedFalse();
    }

    @Override
    public Iterable<Animal> searchAnimalsByKeyword(String keyword) {
        return animalRepository.searchByKeyword(keyword);
    }

    @Override
    public Iterable<Animal> filterAnimals(Date dateOfBirth, Double weight, String race, String category, Integer gender) {
        return animalRepository.filterAnimals(dateOfBirth, weight, race, category, gender);
    }
  */

   /*public List<Animal> getAnimalsByPersonId(Integer idPerson) {
       return animalRepository.findByIdPerson(idPerson);
   }*/

    //récupération des références des animaux de Id Person
   @Override
   public List<String> getAnimalLinksByPersonId(Integer idPerson) {
       List<Animal> animals = animalRepository.findByIdPerson(idPerson);
       return animals.stream()
               .map(animal -> "/animal/" + animal.getId())
               .collect(Collectors.toList());
   }

   //récupération des détail de l'animal
    public Animal getAnimalDetailsById(Integer id) {
        return animalRepository.findById(id).orElse(null);
    }
}
