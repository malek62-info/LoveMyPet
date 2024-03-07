package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.Heure;
import com.nanterre.LoveMyPet.model.Traitement;
import com.nanterre.LoveMyPet.repository.TraitementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TraitementServiceImpl implements TraitementService {

    @Autowired
    private TraitementRepository traitementRepository;

    @Override
    public List<String> getTraitementsByAnimalId(Integer animalId) {
        List<Traitement> liste = traitementRepository.findByAnimalId(animalId);
        return  liste.stream()
                .map(x -> "traitement/" + x.getIdTraitement())
                .collect(Collectors.toList());

    }


    @Override
    public Optional<Traitement> getTraitementById(Integer traitementId) {
        return traitementRepository.findById(traitementId);
    }


 @Override
    public Traitement saveTraitement(Traitement traitement) {
        return traitementRepository.save(traitement);
    }

    @Override
    public List<String> getTraitementLinksByAnimalId(Integer idAnimal) {
        List<Traitement> traitements = traitementRepository.findByAnimalId(idAnimal);
        return traitements.stream().map(traitement -> "/traitement/" + traitement.getIdTraitement()).collect(Collectors.toList());
    }

    @Override
    public Traitement getTraitementDetailsById(Integer idTraitement) {
        return traitementRepository.findById(idTraitement).orElse(null);
    }
    
    @Override
    public void ajouterHeure(Integer idTraitement, List<Heure> heures) {
        Traitement traitement = traitementRepository.findById(idTraitement).orElse(null);
        if (traitement != null) {
            // Associer chaque heure au traitement et les enregistrer
            heures.forEach(heure -> {
                heure.setTraitement(traitement);
                traitement.getHeures().add(heure);
            });
            traitementRepository.save(traitement);
        }
    }

    @Override
    public List<Heure> getHeuresByTraitementId(Integer idTraitement) {
        Traitement traitement = traitementRepository.findById(idTraitement).orElse(null);
        if (traitement != null) {
            return traitement.getHeures();
        }
        return Collections.emptyList();
    }
    

}