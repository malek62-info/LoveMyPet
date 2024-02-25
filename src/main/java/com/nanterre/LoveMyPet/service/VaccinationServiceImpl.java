package com.nanterre.LoveMyPet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nanterre.LoveMyPet.model.Vaccination;
import com.nanterre.LoveMyPet.repository.VaccinationRepository;

@Service
public class VaccinationServiceImpl implements VaccinationService {

    @Autowired
    private VaccinationRepository vaccinationRepository;

    public void addVaccination(Vaccination vaccination) {
        vaccinationRepository.save(vaccination);
    }
}
