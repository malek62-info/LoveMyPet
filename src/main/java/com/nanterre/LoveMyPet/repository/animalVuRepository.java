package com.nanterre.LoveMyPet.repository;

import com.nanterre.LoveMyPet.model.AnimalVu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface animalVuRepository extends JpaRepository <AnimalVu,Long>{
    List<AnimalVu> findAllByAnimalId(Long animalId);

}
