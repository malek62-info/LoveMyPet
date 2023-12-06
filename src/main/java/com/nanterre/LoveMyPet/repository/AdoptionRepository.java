package com.nanterre.LoveMyPet.repository;

import com.nanterre.LoveMyPet.model.Adoption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface AdoptionRepository extends JpaRepository<Adoption, Integer> {


}
