package com.nanterre.LoveMyPet.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nanterre.LoveMyPet.model.Vaccination;



@Repository
public interface VaccinationRepository extends JpaRepository<Vaccination, Integer> {
	List<Vaccination> findByAnimalId(Integer idAnimal);
	Optional<Vaccination> findById(Integer idVaccination);
}
	