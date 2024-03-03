package com.nanterre.LoveMyPet.repository;


import com.nanterre.LoveMyPet.model.Vaccin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccinRepository extends JpaRepository<Vaccin, Integer> {
    Vaccin findByVaccinName(String vaccinName);


}
