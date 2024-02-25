package com.nanterre.LoveMyPet.repository;

import com.nanterre.LoveMyPet.model.Traitement;
import com.nanterre.LoveMyPet.model.Vaccination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TraitementRepository extends JpaRepository<Traitement, Integer> {
    List<Traitement> findByAnimalId(Integer animalId);
    Optional<Traitement> findById(Integer id);
}
