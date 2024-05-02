package com.nanterre.LoveMyPet.repository;

import com.nanterre.LoveMyPet.model.Adoption;
import org.springframework.data.jpa.repository.JpaRepository;



public interface AdoptionRepository extends JpaRepository<Adoption, Integer> {


}
