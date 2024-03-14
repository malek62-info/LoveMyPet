package com.nanterre.LoveMyPet.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
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
    public void updateHeure(Integer idHeure, Date nouvelleHeure) {
        Optional<Heure> heureOptional = heureRepository.findById(idHeure);
        if (heureOptional.isPresent()) {
            Heure heure = heureOptional.get();
            heure.setHeure(nouvelleHeure);
            heureRepository.save(heure);
        } else {
            throw new NoSuchElementException("L'heure avec l'ID spécifié n'existe pas : " + idHeure);
        }
    }
    
    @Override
    public void modifierHeureTraitement(Integer idTraitement, Date nouvelleHeure) {
        // Trouver l'heure associée à ce traitement (vous pouvez adapter cette logique selon vos besoins)
        List<Heure> heures = heureRepository.findByTraitementIdTraitement(idTraitement);
        if (!heures.isEmpty()) {
            // Supposons ici que vous voulez modifier seulement la première heure associée au traitement
            Heure premiereHeure = heures.get(0);
            premiereHeure.setHeure(nouvelleHeure);
            heureRepository.save(premiereHeure);
        } else {
            throw new NoSuchElementException("Aucune heure associée à ce traitement : " + idTraitement);
        }
    }

}
