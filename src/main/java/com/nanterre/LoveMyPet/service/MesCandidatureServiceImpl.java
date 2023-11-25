package com.nanterre.LoveMyPet.service;


import org.springframework.beans.factory.annotation.Autowired;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

import com.nanterre.LoveMyPet.model.Candidature;
import com.nanterre.LoveMyPet.repository.MesCandidatureRepository;



@Service
public class MesCandidatureServiceImpl implements MesCandidatureService {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Autowired
    private MesCandidatureRepository candidatureRepository;


    
    @Override 
    public List<String> getCandidatureLinksByPersonId(Integer IdPerson) {
    	List<Candidature> candidatures = candidatureRepository.findByPersonIdPerson(IdPerson);
    	return candidatures.stream().map(candidature ->"/mescandidature/" + candidature.getIdCandidature()).collect(Collectors.toList());
    }

    public Candidature getCandidatureDetailsById (Integer idCandidature) {
        return candidatureRepository.findById(idCandidature).orElse(null);
    }
    
}