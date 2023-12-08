package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.Candidature;
import com.nanterre.LoveMyPet.repository.CandidatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CandidatureServiceImpl implements CandidatureService {

    @Autowired
    private CandidatureRepository candidatureRepository;

    @Override
    /*public List<Candidature> getCandidaturesByAnimalId(Integer animalId) {
        return candidatureRepository.getCandidaturesByAnimalId(animalId);
    }*/

    public List<String> getCandidatureLinksByAnimalId(Integer animalId) {
        List<Candidature> candidatures = candidatureRepository.getCandidaturesByAnimalId(animalId);
        return candidatures.stream()
                .map(candidature -> String.format("/animal/%d/candidature/%d", animalId, candidature.getIdCandidature()))
                .collect(Collectors.toList());
    }

    @Override
    public Candidature getCandidatureDetailsByAnimalIdAndCandidatureId(Integer animalId, Integer candidatureId) {
        Optional<Candidature> optionalCandidature = candidatureRepository.findById(candidatureId);
        if (optionalCandidature.isPresent()) {
            Candidature candidature = optionalCandidature.get();
            if (candidature.getAdoption().getIdAnimal().equals(animalId)) {
                return candidature;
            }
        }
        return null;
    }

    @Override
    public void saveCandidature(Candidature candidature) {
        candidatureRepository.save(candidature);
    }
    @Override
    public void deleteCandidature(Candidature candidature) {
        candidatureRepository.delete(candidature);
    }
    
}
