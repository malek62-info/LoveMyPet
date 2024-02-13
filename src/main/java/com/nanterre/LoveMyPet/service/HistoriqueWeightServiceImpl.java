package com.nanterre.LoveMyPet.service;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

import com.nanterre.LoveMyPet.model.HistoriqueWeight;
import com.nanterre.LoveMyPet.model.Vaccination;
import com.nanterre.LoveMyPet.repository.HistoriqueWeightRepository;


@Service
public class HistoriqueWeightServiceImpl implements HistoriqueWeightService {

	@PersistenceContext
    private EntityManager entityManager;
    
    @Autowired
    private HistoriqueWeightRepository historiqueWeightRepository;
    
    @Override 
    public List<String> getHistoriqueWeightLinksByAnimalId(Integer idAnimal) {
    	List<HistoriqueWeight> historiqueWeights = historiqueWeightRepository.findByAnimalId(idAnimal);
    	return historiqueWeights.stream().map(historiqueWeight ->"/historiqueWeight/" + historiqueWeight.getId()).collect(Collectors.toList());
    }
    public HistoriqueWeight getHistoriqueWeightDetailsById (Integer idHistoriqueWeight) {
        return historiqueWeightRepository.findById(idHistoriqueWeight).orElse(null);
    }
    @Override
    public List<HistoriqueWeight> getHistoriqueWeightByAnimalId(Integer idAnimal) {
        return historiqueWeightRepository.findByAnimalId(idAnimal);
    }

}
