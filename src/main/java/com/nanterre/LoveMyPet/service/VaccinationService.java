package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.Vaccination;


import java.util.List;

public interface VaccinationService {
    Vaccination saveVaccination(Vaccination vaccination);
    List<String> getVaccinationLinksByAnimalId(Integer idAnimal);
    Vaccination getVaccinationDetailsById (Integer idVaccination);
}
