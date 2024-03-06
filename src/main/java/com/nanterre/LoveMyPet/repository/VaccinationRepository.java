package com.nanterre.LoveMyPet.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nanterre.LoveMyPet.model.Vaccination;



@Repository
public interface VaccinationRepository extends JpaRepository<Vaccination, Integer> {


	List<Vaccination> findByIdAnimal(Integer animalId);

	Optional<Vaccination> findById(Integer idVaccination);

	//liste des email des personnes ayant un animal qui se vaccine aujourdh'ui dans 1 heure
	@Query(nativeQuery = true, value = "SELECT p.email, a.name AS animalName, " +
			"DATE_FORMAT(v.date, '%Y-%m-%d') AS vaccinationDate, " +
			"DATE_FORMAT(v.vaccination_time, '%H:%i') AS vaccinationTime, " +
			"v.vet_address AS vetAddress, v.vet_name AS vetName, " +
			"vac.vaccinename AS vaccineName, v.comment AS vaccinationComment " +
			"FROM vaccination v " +
			"JOIN animal a ON v.idanimal = a.idanimal " +
			"JOIN person p ON a.idperson = p.id_person " +
			"JOIN vaccin vac ON v.idvaccin = vac.idvaccin " +
			"WHERE v.date = DATE_ADD(CURDATE(), INTERVAL 1 MONTH)")
	List<Object[]> findVaccinationDetailsForEmails();





	}