package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.Heure;
import com.nanterre.LoveMyPet.model.Traitement;

import java.util.List;
import java.util.Optional;

public interface TraitementService {
    List<String> getTraitementsByAnimalId(Integer animalId);
    Optional<Traitement> getTraitementById(Integer traitementId);

	Traitement saveTraitement(Traitement traitement);

	List<String> getTraitementLinksByAnimalId(Integer idAnimal);

	Traitement getTraitementDetailsById(Integer idTraitement);

	void ajouterHeure(Integer idTraitement, List<Heure> heures);

	List<Heure> getHeuresByTraitementId(Integer idTraitement);
	
	Optional<Traitement> updateTraitement(Integer traitementId, Traitement traitementModifie);
	
	List<Traitement> getTraitementsDetailsByAnimalId(Integer animalId);
}
