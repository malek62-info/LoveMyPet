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
import java.util.stream.Collectors;


@Service
public class VaccinServiceImpl implements VaccinService {

    @Autowired
    private VaccinRepository vaccinRepository;

    public List<String> getAllVaccinReferences() {
        List<Vaccin> vaccins = vaccinRepository.findAll();
        return vaccins.stream().map(vaccin -> "vaccin/" + vaccin.getIdVaccin()).collect(Collectors.toList());
    }
    public Vaccin getVaccinById(Integer id) {
        Optional<Vaccin> vaccinOptional = vaccinRepository.findById(id);
        return vaccinOptional.orElse(null);
    }
}
