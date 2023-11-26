package com.nanterre.LoveMyPet.repository;

import com.nanterre.LoveMyPet.model.Candidature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CandidatureRepository extends JpaRepository<Candidature, Integer> {

    @Query("SELECT c FROM Candidature c JOIN c.adoption a JOIN a.adoptedAnimal an WHERE an.id = :animalId")
    List<Candidature> getCandidaturesByAnimalId(@Param("animalId") Integer animalId);
}
