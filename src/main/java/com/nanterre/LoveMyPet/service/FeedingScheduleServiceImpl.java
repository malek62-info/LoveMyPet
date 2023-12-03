package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.Animal;
import com.nanterre.LoveMyPet.model.FeedingSchedule;
import com.nanterre.LoveMyPet.model.FeedingTime;
import com.nanterre.LoveMyPet.model.Person;
import com.nanterre.LoveMyPet.repository.AnimalRepository;
import com.nanterre.LoveMyPet.repository.FeedingScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FeedingScheduleServiceImpl implements FeedingScheduleService {

    @Autowired
    private FeedingScheduleRepository feedingScheduleRepository;

    @Autowired
    private AnimalRepository animalRepository;

    @Override
    @Transactional
    public FeedingSchedule createFeedingSchedule(FeedingSchedule feedingSchedule) {
        // Vous pouvez ajouter une logique de validation ou de traitement ici

        // Assurez-vous que les relations bidirectionnelles sont correctement gérées
        for (FeedingTime feedingTime : feedingSchedule.getFeedingTimes()) {
            feedingTime.setFeedingSchedule(feedingSchedule);
        }


        

           // Mettez à jour le champ isScheduled à true dans l'entité Animal associée
        Animal animal = feedingSchedule.getAnimal();
        if (animal != null) {
            animalRepository.updateIsScheduled(animal.getId(), true);
        }

        // Enregistrez le feedingSchedule avec ses feedingTimes
        return feedingScheduleRepository.save(feedingSchedule);
    }

    // La liste de spersonne qui ont un animal qui a un feedingtimme == maintenant

    public List<String> getUsersWithCurrentFeedingTime() {
        return feedingScheduleRepository.findEmailsForCurrentFeedingTime();
    }


    public List<LocalTime> getFeedingTimesForAnimal(Long animalId) {
        Optional<FeedingSchedule> feedingScheduleOptional = feedingScheduleRepository.findByAnimalId(animalId);

        if (feedingScheduleOptional.isPresent()) {
            FeedingSchedule feedingSchedule = feedingScheduleOptional.get();
            return feedingSchedule.getFeedingTimes()
                    .stream()
                    .map(FeedingTime::getFeedingTime)
                    .collect(Collectors.toList());
        } else {
            // Gérer le cas où l'animal n'a pas de programme d'alimentation
            return Collections.emptyList();
        }
    }
}
