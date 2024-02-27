package com.nanterre.LoveMyPet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nanterre.LoveMyPet.model.Vaccination;
import com.nanterre.LoveMyPet.repository.VaccinationRepository;

import java.util.Optional;

@Service
public class VaccinationServiceImpl implements VaccinationService {

    @Autowired
    private VaccinationRepository vaccinationRepository;

    public void addVaccination(Vaccination vaccination) {
        vaccinationRepository.save(vaccination);
    }

    // Méthode pour mettre à jour une vaccination
    public Vaccination updateVaccination(Integer id, Vaccination vaccinationDetails) {
        // Recherche de la vaccination existante par son identifiant
        Optional<Vaccination> optionalVaccination = vaccinationRepository.findById(id);
        if (optionalVaccination.isPresent()) {
            Vaccination existingVaccination = optionalVaccination.get();
            // Mettre à jour les attributs de la vaccination existante avec les nouvelles valeurs
            existingVaccination.setDate(vaccinationDetails.getDate());
            existingVaccination.setVaccinationTime(vaccinationDetails.getVaccinationTime());
            existingVaccination.setVetAddress(vaccinationDetails.getVetAddress());
            existingVaccination.setVetName(vaccinationDetails.getVetName());
            existingVaccination.setComment(vaccinationDetails.getComment());
            // Sauvegarder la vaccination mise à jour dans la base de données
            return vaccinationRepository.save(existingVaccination);
        } else {
            return null; // La vaccination n'existe pas, donc elle ne peut pas être mise à jour
        }
    }


    @Override
    public Vaccination getVaccinationById(Integer id) {
        return vaccinationRepository.findById(id).orElse(null);
    }




    }
