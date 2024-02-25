package com.nanterre.LoveMyPet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.nanterre.LoveMyPet.model.Heure;
import com.nanterre.LoveMyPet.model.Traitement;
import com.nanterre.LoveMyPet.repository.HeureRepository;
import com.nanterre.LoveMyPet.repository.TraitementRepository;

@Service
public class TraitementServiceImpl implements TraitementService {

    @Autowired
    private TraitementRepository traitementRepository;
    @Autowired
    private HeureRepository heureRepository;

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
    public void ajouterHeure(Integer idTraitement, Heure heure) {
        Traitement traitement = traitementRepository.findById(idTraitement).orElse(null);
        if (traitement != null) {
            heure.setTraitement(traitement);
            traitement.getHeures().add(heure);
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
    
    @Override
    public void updateHeure(Integer idHeure, Heure newHeure) {
        // Récupérer l'heure existante à partir de la base de données en utilisant son ID
        Optional<Heure> existingHeureOptional = heureRepository.findById(idHeure);

        if (existingHeureOptional.isPresent()) {
            Heure existingHeure = existingHeureOptional.get();

            // Mettre à jour les champs de l'heure existante avec les nouvelles valeurs
            existingHeure.setHeure(newHeure.getHeure()); // Mettez à jour l'heure (ou tout autre champ que vous souhaitez mettre à jour)

            // Enregistrer les modifications dans la base de données
            heureRepository.save(existingHeure);
        } else {
            // Gérer le cas où l'heure avec l'ID spécifié n'existe pas
            throw new RuntimeException("Heure avec l'ID " + idHeure + " non trouvée");
        }
    }

}
