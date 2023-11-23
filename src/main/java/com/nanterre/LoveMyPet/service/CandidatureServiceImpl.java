package com.nanterre.LoveMyPet.service;


import org.springframework.beans.factory.annotation.Autowired;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

import com.nanterre.LoveMyPet.model.Candidature;
import com.nanterre.LoveMyPet.repository.CandidatureRepository;


@Service
public class CandidatureServiceImpl implements CandidatureService {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Autowired
    private CandidatureRepository candidatureRepository;


    
    @Override 
    public List<String> getCandidatureLinksByPersonId(Integer idPerson) {
    	List<Candidature> candidatures = candidatureRepository.findByPersonIdPerson(idPerson);
    	return candidatures.stream().map(candidature ->"/candidature/" + candidature.getIdCandidature()).collect(Collectors.toList());
    }

    public Candidature getCandidatureDetailsById (Integer idCandidature) {
        return candidatureRepository.findById(idCandidature).orElse(null);
    }
    
}
