package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.Adoption;
import com.nanterre.LoveMyPet.repository.AdoptionRepository;
import com.nanterre.LoveMyPet.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class AdoptionServiceImpl implements AdoptionService {

    private final AnimalRepository animalRepository;
    private final AdoptionRepository adoptionRepository;

    @Autowired
    public AdoptionServiceImpl(AnimalRepository animalRepository, AdoptionRepository adoptionRepository) {
        this.animalRepository = animalRepository;
        this.adoptionRepository = adoptionRepository;
    }
    //url adoption
    @Override
    public List<String> getAllAdoptionUrls() {
        List<Adoption> adoptions = adoptionRepository.findAll();
        return adoptions.stream()
                .map(adoption -> "/adoption/" + adoption.getIdAdoption())
                .collect(Collectors.toList());
    }


    @Override
    public Map<String, Object> getAdoptionDetails(Integer idAdoption) {
        Adoption adoption = adoptionRepository.findById(idAdoption).orElse(null);
        Map<String, Object> adoptionDetails = new HashMap<>();
        if (adoption != null) {
            adoptionDetails.put("adoptionId", adoption.getIdAdoption());
            adoptionDetails.put("animal", adoption.getAdoptedAnimal());
            adoptionDetails.put("startDate", adoption.getStartDate());
            adoptionDetails.put("endDate", adoption.getEndDate());
        }
        return adoptionDetails;
    }
    //Malek
    @Override
    public void saveAdoption(Adoption adoption) {
        adoptionRepository.save(adoption);
    }
    @Override
    public void deleteAdoption(Integer idAdoption) {
        try {
            adoptionRepository.deleteById(idAdoption);
            // Ajoute des logs pour indiquer le succès
            System.out.println("Adoption supprimée avec succès. ID: " + idAdoption);
        } catch (Exception e) {
            // Ajoute des logs pour indiquer l'échec
            System.err.println("Erreur lors de la suppression de l'adoption. ID: " + idAdoption);
            e.printStackTrace();
            throw new RuntimeException("Erreur lors de la suppression de l'adoption.", e);
        }
    }

}