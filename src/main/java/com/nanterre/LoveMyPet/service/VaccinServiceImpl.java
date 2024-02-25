package com.nanterre.LoveMyPet.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nanterre.LoveMyPet.model.Vaccin;
import com.nanterre.LoveMyPet.repository.VaccinRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class VaccinServiceImpl implements VaccinService {

    @Autowired
    private VaccinRepository vaccinRepository;

    @Override
    @Transactional
    public void loadDataFromJson(String jsonFilePath) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<Vaccin> vaccinList = objectMapper.readValue(new File(jsonFilePath),
                    new TypeReference<List<Vaccin>>() {});

            System.out.println("Nombre de vaccins à sauvegarder : " + vaccinList.size()); // Débogage : afficher le nombre de vaccins à sauvegarder

            vaccinRepository.saveAll(vaccinList);

            System.out.println("Données chargées avec succès à partir du fichier JSON.");
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture des données à partir du fichier JSON : " + e.getMessage());
        }
    }

    @Override
    public List<String> getAllVaccinNames() {
        List<Vaccin> vaccins = vaccinRepository.findAll();
        List<String> vaccinNames = new ArrayList<>();
        for (Vaccin vaccin : vaccins) {
            vaccinNames.add(vaccin.getVaccinName());
        }
        return vaccinNames;
    }

    public Integer findVaccinIdByName(String vaccinName) {
        Vaccin vaccin = vaccinRepository.findByVaccinName(vaccinName);
        if (vaccin != null) {
            return vaccin.getIdVaccin();
        }
        return null; // Ou lancez une exception si le vaccin n'est pas trouvé
    }


}
