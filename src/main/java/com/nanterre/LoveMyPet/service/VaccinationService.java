package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.Vaccination;



import java.util.List;


public interface VaccinationService {
    List<String> getVaccinationsByAnimalId(Integer idAnimal);


    List<Object[]> getVaccinationDetailsForEmails();

    void addVaccination(Vaccination vaccination);

    public Vaccination updateVaccination(Integer id, Vaccination vaccinationDetails) ;

    public Vaccination getVaccinationById(Integer id);



    }

