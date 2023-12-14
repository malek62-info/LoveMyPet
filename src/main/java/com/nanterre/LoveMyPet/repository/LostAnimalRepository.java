package com.nanterre.LoveMyPet.repository;

import com.nanterre.LoveMyPet.model.LostAnimal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LostAnimalRepository extends JpaRepository<LostAnimal, Integer> {
    // Ajoute des méthodes spécifiques au besoin
}
