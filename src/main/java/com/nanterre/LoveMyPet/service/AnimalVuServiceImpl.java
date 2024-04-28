package com.nanterre.LoveMyPet.service;
import com.nanterre.LoveMyPet.model.AnimalVu;
import com.nanterre.LoveMyPet.repository.animalVuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalVuServiceImpl implements AnimalVuService {
    private final animalVuRepository animalVuRepository;

    @Autowired
    public AnimalVuServiceImpl(animalVuRepository animalVuRepository) {
        this.animalVuRepository = animalVuRepository;
    }

    @Override
    public void ajouterAnimalVu(AnimalVu animalVu) {
        animalVuRepository.save(animalVu);
    }



}
