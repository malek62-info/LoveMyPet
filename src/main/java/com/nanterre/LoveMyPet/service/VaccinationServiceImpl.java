package com.nanterre.LoveMyPet.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.nanterre.LoveMyPet.model.Vaccination;
import com.nanterre.LoveMyPet.repository.VaccinationRepository;


@Service
public class VaccinationServiceImpl implements VaccinationService {

    @Autowired
    private VaccinationRepository vaccinationRepository;


    @Override
    public List<String> getVaccinationsByAnimalId(Integer idAnimal) {
        List<Vaccination> list = vaccinationRepository.findByAnimalId(idAnimal);
        return list.stream()
                .map(x -> "/vaccination/" + x.getIdVaccination())
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Vaccination> getVaccinationById(Integer idVaccination) {
        return vaccinationRepository.findById(idVaccination);
    }

    //liste email

    @Override
    public List<Object[]> getVaccinationDetailsForEmails() {
        return vaccinationRepository.findVaccinationDetailsForEmails();
    }



}
