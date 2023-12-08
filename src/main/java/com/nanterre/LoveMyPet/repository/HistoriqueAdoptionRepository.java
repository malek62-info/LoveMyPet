package com.nanterre.LoveMyPet.repository;

import com.nanterre.LoveMyPet.model.HistoriqueAdoption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoriqueAdoptionRepository extends JpaRepository<HistoriqueAdoption, Integer> {
    // Ajoute des méthodes personnalisées si nécessaire
}
