package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.AnimalPerdu;
import com.nanterre.LoveMyPet.repository.AnimalPerduRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AnimalPerduServiceImpl implements AnimalPerduService {

    @Autowired
    private AnimalPerduRepository animalPerduRepository;

    @Override
    public AnimalPerdu ajouterAnimalPerdu(Integer idAnimal, double latitude, double longitude) {
        AnimalPerdu animalPerdu = new AnimalPerdu(idAnimal, latitude, longitude);
        return animalPerduRepository.save(animalPerdu);
    }

    @Override
    public List<AnimalPerdu> findAnimalsLostByPersonId(Integer idPerson) {
        return animalPerduRepository.findAllByPersonId(idPerson);
    }
}