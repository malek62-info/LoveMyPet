package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.HistoriqueAdoption;
import com.nanterre.LoveMyPet.repository.HistoriqueAdoptionRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class HistoriqueAdoptionServiceImpl implements HistoriqueAdoptionService {

    @Autowired
    private HistoriqueAdoptionRepository historiqueAdoptionRepository;

    @Transactional
    public void ajouterAdoption(Integer idAnimal, Integer idPerson, Date endDate) {
        HistoriqueAdoption historiqueAdoption = new HistoriqueAdoption();
        historiqueAdoption.setIdAnimal(idAnimal);
        historiqueAdoption.setIdPerson(idPerson);
        historiqueAdoption.setEndDate(endDate); // Utilisation de la date passée en paramètre

        historiqueAdoptionRepository.save(historiqueAdoption);
    }
}
