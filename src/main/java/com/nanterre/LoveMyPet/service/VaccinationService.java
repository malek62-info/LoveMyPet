package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.Vaccination;

public interface VaccinationService {
    void addVaccination(Vaccination vaccination);

    public Vaccination updateVaccination(Integer id, Vaccination vaccinationDetails) ;

    public Vaccination getVaccinationById(Integer id);



    }
