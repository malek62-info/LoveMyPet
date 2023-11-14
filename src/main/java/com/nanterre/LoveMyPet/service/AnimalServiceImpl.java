package com.nanterre.LoveMyPet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nanterre.LoveMyPet.model.Animal;
import com.nanterre.LoveMyPet.repository.AnimalRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
@Service

public class AnimalServiceImpl implements AnimalService{
	  @PersistenceContext
	    private EntityManager entityManager;
	    @Autowired
	    private AnimalRepository animalRepository;

	    @Override
	    public Animal saveAnimal(Animal animal) {
	        return animalRepository.save(animal);
	    }

		@Override
		public Animal findAnimalById(Integer id) {
			// TODO Auto-generated method stub
			return null;
		}

	  
}
