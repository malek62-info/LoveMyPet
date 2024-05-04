package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.AnimalVu;

import com.nanterre.LoveMyPet.repository.AnimalVuRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class AnimalVuServiceImpl implements AnimalVuService {

    private final AnimalVuRepository animalVuRepository;

    @Override
    public List<Object[]> getEmailsByAnimalVue() {
        return animalVuRepository.getEmailsByAnimalVue();
    }

    @Autowired
    public AnimalVuServiceImpl(AnimalVuRepository animalVuRepository) {
        this.animalVuRepository = animalVuRepository;
    }

    @Override
    public void ajouterAnimalVu(AnimalVu animalVu) {
        animalVuRepository.save(animalVu);
    }

    @Override
    public List<AnimalVu> getAnimalCoordsById(Integer idAnimal) {
        return animalVuRepository.findAllByidAnimal(idAnimal);
    }

    @Override
    @Transactional
    public void supprimerAnimalVu(Integer idAnimal) {
        animalVuRepository.deleteByIdAnimal(idAnimal);
    }

}
