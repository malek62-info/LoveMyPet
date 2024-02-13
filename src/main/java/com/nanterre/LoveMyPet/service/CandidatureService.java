package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.*;
import com.nanterre.LoveMyPet.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CandidatureService {
    //public List<Candidature> getCandidaturesByAnimalId(Integer animalId);
    public List<String> getCandidatureLinksByAnimalId(Integer animalId);
    Candidature getCandidatureDetailsByAnimalIdAndCandidatureId(Integer animalId, Integer candidatureId);
    void saveCandidature(Candidature candidature);
    void deleteCandidature(Candidature candidature);




}

