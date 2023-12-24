package com.nanterre.LoveMyPet.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nanterre.LoveMyPet.model.Animal;

@Repository
public interface InfoAnimalRepository extends JpaRepository<Animal, Integer> {
}

