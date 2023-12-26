package com.nanterre.LoveMyPet.service;

import org.springframework.beans.factory.annotation.Autowired;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

import com.nanterre.LoveMyPet.model.Animal;
import com.nanterre.LoveMyPet.model.HistoriqueWeight;
import com.nanterre.LoveMyPet.repository.InfoAnimalRepository;



@Service
public class InfoAnimalServiceImpl implements InfoAnimalService {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Autowired
    private InfoAnimalRepository animalInfoRepository;

    public Animal getInfoAnimalDetailsById (Integer idAnimal) {
        return animalInfoRepository.findById(idAnimal).orElse(null);
    }
    
    @Transactional
    public void updateAnimalName(Integer idAnimal, String newName) {
        Animal animal = animalInfoRepository.findById(idAnimal).orElse(null);
        if (animal != null) {
            animal.setName(newName);
            animalInfoRepository.save(animal);
        }
    }

    @Transactional
    public void updateAnimalWeight(Integer idAnimal, Double newWeight) {
        Animal animal = animalInfoRepository.findById(idAnimal).orElse(null);
        
        if (animal != null) {
            animal.setWeight(newWeight);
            animalInfoRepository.save(animal);
        }
        HistoriqueWeight historiqueWeight = new HistoriqueWeight();
        historiqueWeight.setIdAnimal(idAnimal);
        historiqueWeight.setWeight(newWeight);
        historiqueWeight.setDate(new Date());
        entityManager.persist(historiqueWeight);
    }
    
    @Transactional
    public void updateAnimalImage(Integer idAnimal, String imageUrl) {
        Animal animal = animalInfoRepository.findById(idAnimal).orElse(null);
        if (animal != null) {
            animal.setImageUrl(imageUrl);
            animalInfoRepository.save(animal);
        }
    }
	
    
}