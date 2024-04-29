package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.AnimalVu;
import com.nanterre.LoveMyPet.repository.AnimalVuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalVuServiceImpl implements AnimalVuService {

    private final AnimalVuRepository animalVuRepository;

    @Autowired
    public AnimalVuServiceImpl(AnimalVuRepository animalVuRepository) {
        this.animalVuRepository = animalVuRepository;
    }

    @Override
    public List<Object[]> getEmailsByAnimalVue() {
        return animalVuRepository.getEmailsByAnimalVue();
    }
}
