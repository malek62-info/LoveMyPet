package com.nanterre.LoveMyPet.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.nanterre.LoveMyPet.model.Heure;
import com.nanterre.LoveMyPet.model.Traitement;
import com.nanterre.LoveMyPet.repository.HeureRepository;
import com.nanterre.LoveMyPet.repository.TraitementRepository;

@Service
public class HeureServiceImpl implements HeureService {

    @Autowired
    private TraitementRepository traitementRepository;

    @Autowired
    private HeureRepository heureRepository;

    @Override
    public void ajouterHeure(Integer idTraitement, Date heure) {
        Traitement traitement = traitementRepository.findById(idTraitement).orElse(null);
        if (traitement != null) {
            Heure newHeure = new Heure();
            newHeure.setHeure(heure);
            newHeure.setTraitement(traitement);
            heureRepository.save(newHeure);
        }
    }

    @Override
    public List<Heure> getHeuresByTraitementId(Integer idTraitement) {
        return heureRepository.findByTraitementIdTraitement(idTraitement);
    }

    @Override
    public void updateHeure(Integer idHeure, Date newHeure) {
        // Implémentez la logique de mise à jour de l'heure en fonction de l'ID de l'heure
        // Assurez-vous de mettre à jour l'heure dans la table Heure
    }
}
