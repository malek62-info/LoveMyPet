package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.Traitement;

import java.util.List;
import java.util.Optional;

public interface TraitementService {
    List<String> getTraitementsByAnimalId(Integer animalId);
    Optional<Traitement> getTraitementById(Integer traitementId);
}

