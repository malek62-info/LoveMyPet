package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.Heure;
import com.nanterre.LoveMyPet.model.Traitement;
import java.util.List;

public interface TraitementService {
	Traitement saveTraitement(Traitement traitement);

	List<String> getTraitementLinksByAnimalId(Integer idAnimal);

	Traitement getTraitementDetailsById(Integer idTraitement);

	void ajouterHeure(Integer idTraitement, Heure heure);

	List<Heure> getHeuresByTraitementId(Integer idTraitement);

	void updateHeure(Integer idHeure, Heure newHeure);
}
