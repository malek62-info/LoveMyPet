package com.nanterre.LoveMyPet.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nanterre.LoveMyPet.model.Traitement;

@Repository
public interface TraitementRepository extends JpaRepository<Traitement, Integer> {
    List<Traitement> findByAnimalId(Integer animalId);
}
