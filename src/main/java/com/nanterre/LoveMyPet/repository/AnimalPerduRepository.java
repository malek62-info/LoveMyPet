package com.nanterre.LoveMyPet.repository;

import com.nanterre.LoveMyPet.model.AnimalPerdu;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AnimalPerduRepository extends JpaRepository<AnimalPerdu,Long> {



    boolean existsByIdAnimal(Integer idAnimal);


}

