package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.Vaccination;


import java.util.List;
import java.util.Optional;

public interface VaccinationService {
    List<String> getVaccinationsByAnimalId(Integer idAnimal);
    Optional<Vaccination> getVaccinationById(Integer idVaccination);
}