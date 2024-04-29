package com.nanterre.LoveMyPet.repository;

import com.nanterre.LoveMyPet.model.AnimalVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface animalVuRepository extends JpaRepository <AnimalVu,Long>{
    List<AnimalVu> findAllByidAnimal(Integer idAnimal);

}
