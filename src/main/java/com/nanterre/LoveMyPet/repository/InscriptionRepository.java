package com.nanterre.LoveMyPet.repository;

import com.nanterre.LoveMyPet.model.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscriptionRepository extends JpaRepository<Inscription, Integer> {
    // You can add custom query methods here if needed
}
