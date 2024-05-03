package com.nanterre.LoveMyPet.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nanterre.LoveMyPet.repository.AnimalPerduRepository;
import com.nanterre.LoveMyPet.repository.AnimalRepository;
import com.nanterre.LoveMyPet.model.Animal;
import com.nanterre.LoveMyPet.model.AnimalPerdu;

import com.nanterre.LoveMyPet.model.AnimalPerdu;
import com.nanterre.LoveMyPet.model.AnimalVu;
import com.nanterre.LoveMyPet.repository.AnimalPerduRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AnimalPerduServiceImpl implements AnimalPerduService {

    @Autowired
    private AnimalPerduRepository animalPerduRepository;


    @Autowired
    private AnimalRepository animalRepository; // Supposons que vous avez un repository pour les animaux

    @Override
    public List<Animal> getAnimalsWithinRadius(double latitude, double longitude) {
        // Constantes pour la conversion de degrés en radians
        final double RADIUS_EARTH = 6371.0; // Rayon de la Terre en kilomètres

        // Convertir la latitude et la longitude de degrés en radians
        double userLatitudeRad = Math.toRadians(latitude);
        double userLongitudeRad = Math.toRadians(longitude);

        // Liste pour stocker les animaux dans le rayon de 30 km
        List<Animal> animalsWithinRadius = new ArrayList<>();

        // Récupérer tous les animaux perdus de la base de données
        List<AnimalPerdu> allAnimalsPerdu = animalPerduRepository.findAll();

        // Parcourir tous les animaux perdus et vérifier leur distance par rapport à la position de l'utilisateur
        for (AnimalPerdu animalPerdu : allAnimalsPerdu) {
            double animalLatitudeRad = Math.toRadians(animalPerdu.getLatitude());
            double animalLongitudeRad = Math.toRadians(animalPerdu.getLongitude());

            // Calculer la différence de latitude et de longitude
            double deltaLatitude = animalLatitudeRad - userLatitudeRad;
            double deltaLongitude = animalLongitudeRad - userLongitudeRad;

            // Calculer la distance entre l'animal perdu et l'utilisateur en utilisant la formule de Haversine
            double a = Math.pow(Math.sin(deltaLatitude / 2), 2) +
                       Math.cos(userLatitudeRad) * Math.cos(animalLatitudeRad) *
                       Math.pow(Math.sin(deltaLongitude / 2), 2);
            double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
            double distance = RADIUS_EARTH * c;

            if (distance <= 30.0) {
                    Optional<Animal> optionalAnimal = animalRepository.findById(animalPerdu.getIdAnimal());
                    optionalAnimal.ifPresent(animalsWithinRadius::add);
            }
        }

        return animalsWithinRadius;
    }





    @Override
    public AnimalPerdu ajouterAnimalPerdu(Integer idAnimal, double latitude, double longitude) {
        AnimalPerdu animalPerdu = new AnimalPerdu(idAnimal, latitude, longitude);
        return animalPerduRepository.save(animalPerdu);
    }

    @Override
    public boolean animalExisteDeja(Integer idAnimal) {
        return animalPerduRepository.existsByIdAnimal(idAnimal);
    }
}

