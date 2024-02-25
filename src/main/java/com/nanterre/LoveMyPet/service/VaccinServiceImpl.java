package com.nanterre.LoveMyPet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nanterre.LoveMyPet.model.Vaccin;
import com.nanterre.LoveMyPet.repository.VaccinRepository;

@Service
public class VaccinServiceImpl implements VaccinService {

    @Autowired
    private VaccinRepository vaccinRepository;

    @Override
    public Iterable<Vaccin> getAllVaccins() {
        return vaccinRepository.findAll();
    }

    @Override
    public Vaccin getVaccinById(Integer id) {
        return null;
    }
}
