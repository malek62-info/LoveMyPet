package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.Adoption;
import com.nanterre.LoveMyPet.repository.AdoptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class AdoptionServiceImpl implements AdoptionService{

    @Autowired
    private AdoptionRepository adoptionRepository;



    @Override
    public void saveAdoption(Adoption adoption) {
        adoptionRepository.save(adoption);
    }




}
