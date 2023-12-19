package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.FeedingTime;
import com.nanterre.LoveMyPet.repository.FeedingTimeRepository;
import com.nanterre.LoveMyPet.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeedingTimeServiceImpl implements FeedingTimeService {

    @Autowired
    private FeedingTimeRepository feedingTimeRepository;

    @Autowired
    private PersonRepository personRepository;
    // ajouter une feedingtime
    @Override
    public void addFeedingTime(FeedingTime feedingTime) {
        if (!feedingTimeRepository.existsByAnimalAndFeedingTime(feedingTime.getAnimal(),
                feedingTime.getFeedingTime())) {
            feedingTimeRepository.save(feedingTime);
        } else {
            // Throw an exception with a message indicating the conflict
            throw new RuntimeException("Feeding time already exists for the same animal at the specified time.");
        }
    }

    // la liste des feeding time d'un animal
    @Override
    public List<String> getAnimalFeedingTimesReferences(Integer idAnimal) {
        List<FeedingTime> feedingTimes = feedingTimeRepository.findByAnimalId(idAnimal);
        return feedingTimes.stream()
                .map(feedingTime -> "time/" + feedingTime.getId())
                .collect(Collectors.toList());
    }

    // detail feedingtime
    @Override
    public FeedingTime getFeedingTimeDetailsById(Integer id) {
        return feedingTimeRepository.findById(id).orElse(null);
    }

    // supprimer un feeding time
    @Override
    public void deleteFeedingTime(Integer id) {
        feedingTimeRepository.deleteById(id);
    }

    @Override
    public FeedingTime updateFeedingTime(Integer id, FeedingTime updatedFeedingTime) {
        FeedingTime existingFeedingTime = feedingTimeRepository.findById(id).orElse(null);

        if (existingFeedingTime != null) {
            // Vérifier si l'animal a déjà une alerte à la nouvelle heure
            if (!feedingTimeRepository.existsByAnimalAndFeedingTime(updatedFeedingTime.getAnimal(), updatedFeedingTime.getFeedingTime())) {
                // Mise à jour des champs nécessaires
                existingFeedingTime.setAnimal(updatedFeedingTime.getAnimal());
                existingFeedingTime.setFeedingTime(updatedFeedingTime.getFeedingTime());

                // Ajoutez ici la logique de validation ou de traitement, si nécessaire

                return feedingTimeRepository.save(existingFeedingTime);
            } else {
                // Si une alerte existe déjà à cette heure, vous pouvez gérer l'erreur ici
                throw new RuntimeException("L'animal a déjà une alerte à cette heure.");
            }
        } else {
            throw new RuntimeException("L'élément n'a pas été trouvé avec l'ID : " + id);
        }
    }

    //list email feedingtime == now
    @Override
    public List<Object[]> getInfosCurrentFeedingTimes() {
        return feedingTimeRepository.findEmailsAndAnimalDetailsForUsersWithCurrentFeedingTime();
    }



}

