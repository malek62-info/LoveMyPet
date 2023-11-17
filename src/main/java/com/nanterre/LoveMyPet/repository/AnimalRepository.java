package com.nanterre.LoveMyPet.repository;
import com.nanterre.LoveMyPet.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    List<Animal> findByIdPerson(Integer idPerson);



}
