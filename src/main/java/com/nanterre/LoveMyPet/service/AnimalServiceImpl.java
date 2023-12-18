package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.Adoption;
import com.nanterre.LoveMyPet.model.Advice;
import com.nanterre.LoveMyPet.model.Animal;
import com.nanterre.LoveMyPet.model.FeedingTime;
import com.nanterre.LoveMyPet.repository.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service

public class AnimalServiceImpl implements AnimalService {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private AnimalRepository animalRepository;
    private final  AdoptionRepository adoptionRepository;

    @Autowired
    public AnimalServiceImpl(AdoptionRepository adoptionRepository) {
        this.adoptionRepository = adoptionRepository;
    }

    @Override
    public List<String> getAnimalLinksByPersonId(Integer idPerson) {
        List<Animal> animals = animalRepository.findByIdPerson(idPerson);
        return animals.stream()
                .map(animal -> "/animal/" + animal.getId())
                .collect(Collectors.toList());
    }

    // récupération des détail de l'animal
    public Animal getAnimalDetailsById(Integer id) {
        return animalRepository.findById(id).orElse(null);
    }

    // références des animaux a adopté

    @Override
    public List<String> getAdoptionUrlsForAnimals() {
        List<Adoption> adoptions = adoptionRepository.findAll();

        // Utilisez la fonction stream et map pour générer les URLs d'adoption pour
        // chaque animal
        List<String> adoptionUrlsForAnimals = adoptions.stream()
                .map(adoption -> {
                    Animal adoptedAnimal = adoption.getAdoptedAnimal();
                    if (adoptedAnimal != null) {
                        // Générez l'URL d'adoption pour cet animal
                        return "/adoption/animal/" + adoptedAnimal.getId();
                    } else {
                        // Gérez le cas où l'animal n'est pas défini (peut-être à des fins de
                        // validation)
                        return null;
                    }
                })
                .filter(Objects::nonNull) // Filtrer les éventuelles valeurs nulles
                .collect(Collectors.toList());

        return adoptionUrlsForAnimals;
    }

    @Override
    public Animal saveAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    @Override
    public Animal findAnimalById(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public void updateAnimalPerson(Integer idAnimal, Integer newPersonId) {
        Animal animal = animalRepository.findById(idAnimal).orElse(null);

        if (animal != null) {
            animal.setIdPerson(newPersonId);
            animalRepository.save(animal);
        }
    }

    //mise a jour du champs isScheduled


    @Service
    public static class FeedingTimeServiceImpl implements CandidatureService.FeedingTimeService {

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

    @Service
    public static class AdviceServiceImpl implements AdoptionServiceImpl.AdviceService { // Implémenter l'interface

        @Autowired
        private AdviceRepository adviceRepository;


        //référence de toutes les advices
        @Override
        public List<String> getAllAdviceReferences() {
            List<Advice> advices = adviceRepository.findAll();
            return advices.stream()
                    .map(advice -> "advice/" + advice.getAdviceId())
                    .collect(Collectors.toList());
        }

        //récupérer une advice précise a partir de lid
        @Override
        public Map<String, Object> getAdviceDetails(Integer adviceId) {
            Advice advice = adviceRepository.findById(adviceId).orElse(null);

            if (advice == null) {
                // Gérer le cas où l'avis n'est pas trouvé
                return null;
            }

            return mapAdviceToDetails(advice);
        }

        private Map<String, Object> mapAdviceToDetails(Advice advice) {
            Map<String, Object> adviceDetails = new HashMap<>();
            adviceDetails.put("adviceId", advice.getAdviceId());  // Ajout de l'ID de l'avis
            adviceDetails.put("authorName", advice.getAuthor().getFirstName() + " " + advice.getAuthor().getLastName());
            adviceDetails.put("textAdvice", advice.getTextAdvice());
            adviceDetails.put("imageUrl", advice.getImageUrl());
            adviceDetails.put("likeCount", advice.getLikeCount());
            adviceDetails.put("dislikeCount", advice.getDislikeCount());
            return adviceDetails;
        }

    }
}
