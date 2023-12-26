package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.Evenement;

import java.time.LocalDate;
import java.util.List;

public interface EvenementService {
    List<Evenement> getAllEvenements();
    Evenement getEvenementById(Integer id);
    Evenement createEvenement(Evenement evenement);
    // Autres méthodes selon les besoins

    List<Evenement> findNonExpiredEvents(LocalDate date);
}
