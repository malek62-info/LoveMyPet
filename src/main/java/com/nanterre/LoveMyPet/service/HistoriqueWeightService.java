package com.nanterre.LoveMyPet.service;
import java.util.List;

import com.nanterre.LoveMyPet.model.HistoriqueWeight;

public interface HistoriqueWeightService {
	List<String> getHistoriqueWeightLinksByAnimalId(Integer idAnimal);
	HistoriqueWeight getHistoriqueWeightDetailsById (Integer idHistoriqueWeight);
	List<HistoriqueWeight> getHistoriqueWeightByAnimalId(Integer idAnimal) ;
   
}
