package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.Evenement;
import com.nanterre.LoveMyPet.repository.EvenementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EvenementServiceImpl implements EvenementService {

    @Autowired
    private EvenementRepository evenementRepository;

    @Override
    public List<Evenement> getAllEvenements() {
        return evenementRepository.findAll();
    }

    @Override
    public Evenement getEvenementById(Integer id) {
        return evenementRepository.findById(id).orElse(null);
    }

    @Override
    public Evenement createEvenement(Evenement evenement) {
        return evenementRepository.save(evenement);
    }



    @Override
    public List<Evenement> findNonExpiredEvents(LocalDate date) {
        return evenementRepository.findByDateAfter(date);
    }
    // Autres méthodes selon les besoins
}
