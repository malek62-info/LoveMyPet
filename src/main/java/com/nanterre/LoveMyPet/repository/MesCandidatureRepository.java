package com.nanterre.LoveMyPet.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.nanterre.LoveMyPet.model.Candidature;

	

@Repository
public interface MesCandidatureRepository extends JpaRepository<Candidature, Integer> {
	 List<Candidature>  findByPersonIdPerson(Integer IdPerson);
}
	