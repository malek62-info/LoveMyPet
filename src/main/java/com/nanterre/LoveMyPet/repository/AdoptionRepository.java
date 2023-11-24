package com.nanterre.LoveMyPet.repository;

import com.nanterre.LoveMyPet.model.Adoption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdoptionRepository extends JpaRepository<Adoption, Integer> {

}
