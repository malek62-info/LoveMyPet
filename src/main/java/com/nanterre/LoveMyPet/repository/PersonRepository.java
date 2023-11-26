package com.nanterre.LoveMyPet.repository;

import com.nanterre.LoveMyPet.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    // Ajoutez ici des méthodes personnalisées si nécessaire
}
