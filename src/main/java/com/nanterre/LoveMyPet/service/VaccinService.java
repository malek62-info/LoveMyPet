package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.Vaccin;

public interface VaccinService {
    Iterable<Vaccin> getAllVaccins();
    Vaccin getVaccinById(Integer id);
}
