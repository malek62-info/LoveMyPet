package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.Candidature;
import com.nanterre.LoveMyPet.repository.CandidatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidatureServiceImpl implements CandidatureService {

    @Autowired
    private CandidatureRepository candidatureRepository;

    @Override
    public void saveCandidature(Candidature candidature) {
        candidatureRepository.save(candidature);
    }
}
