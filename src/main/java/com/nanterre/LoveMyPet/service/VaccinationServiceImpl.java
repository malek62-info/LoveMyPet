package com.nanterre.LoveMyPet.service;

import org.springframework.beans.factory.annotation.Autowired;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

import com.nanterre.LoveMyPet.model.Vaccination;
import com.nanterre.LoveMyPet.repository.VaccinationRepository;


@Service
public class VaccinationServiceImpl implements VaccinationService {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Autowired
    private VaccinationRepository vaccinationRepository;

    @Override
    public Vaccination saveVaccination(Vaccination vaccination) {
        return vaccinationRepository.save(vaccination);
    }


    
    @Override 
    public List<String> getVaccinationLinksByAnimalId(Integer idAnimal) {
    	List<Vaccination> vaccinations = vaccinationRepository.findByAnimalId(idAnimal);
    	return vaccinations.stream().map(vaccination ->"/vaccination/" + vaccination.getIdVaccination()).collect(Collectors.toList());
    }

    public Vaccination getVaccinationDetailsById (Integer idVaccination) {
        return vaccinationRepository.findById(idVaccination).orElse(null);
    }
    
}
