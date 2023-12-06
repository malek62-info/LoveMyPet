package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.Adoption;
import com.nanterre.LoveMyPet.model.Animal;
import com.nanterre.LoveMyPet.repository.AdoptionRepository;
import com.nanterre.LoveMyPet.repository.AnimalRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service

public class AnimalServiceImpl implements AnimalService {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private AnimalRepository animalRepository;
    private AdoptionRepository adoptionRepository;

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

}
