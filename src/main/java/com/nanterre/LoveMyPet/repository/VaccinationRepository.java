package com.nanterre.LoveMyPet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nanterre.LoveMyPet.model.Vaccination;

@Repository
public interface VaccinationRepository extends JpaRepository<Vaccination, Integer> {
	// Méthode pour rechercher des vaccinations par ID d'animal
	List<Vaccination> findByIdAnimal(Integer animalId);
}
