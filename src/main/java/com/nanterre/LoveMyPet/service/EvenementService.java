package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.Evenement;
import com.nanterre.LoveMyPet.model.Inscription;
import com.nanterre.LoveMyPet.model.Person;
import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.util.List;

public interface EvenementService {
    List<Evenement> getAllEvenements();
    Evenement getEvenementById(Integer id);
    Evenement createEvenement(Evenement evenement);
    // Autres méthodes selon les besoins

    List<Evenement> findNonExpiredEvents(LocalDate date);

    List<Evenement> getUserEvents(Integer idPerson);

    @Transactional
    void deleteEvenementAndInscriptions(Integer idEvenement);
    @Transactional
     void deleteEvenement(Integer evenementId);




}
