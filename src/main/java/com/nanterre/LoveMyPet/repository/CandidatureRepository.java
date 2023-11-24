package com.nanterre.LoveMyPet.repository;

import com.nanterre.LoveMyPet.model.Candidature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatureRepository extends JpaRepository<Candidature, Integer> {
}
