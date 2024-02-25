package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.Traitement;
import com.nanterre.LoveMyPet.repository.TraitementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
