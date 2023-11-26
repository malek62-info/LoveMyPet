package com.nanterre.LoveMyPet.service;


import com.nanterre.LoveMyPet.model.Adoption;
import com.nanterre.LoveMyPet.model.Animal;
import com.nanterre.LoveMyPet.repository.AdoptionRepository;
import com.nanterre.LoveMyPet.repository.AnimalRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class AnimalServiceTest {

    @Mock
    private AnimalRepository animalRepository;

    @Mock
    private AdoptionRepository adoptionRepository;

    @InjectMocks
    private AnimalServiceImpl animalService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAnimalLinksByPersonId() {
        // Créez une personne et une liste d'animaux pour le test
        Animal animal1 = new Animal();
        animal1.setId(1);

        Animal animal2 = new Animal();
        animal2.setId(2);

        List<Animal> animalList = Arrays.asList(animal1, animal2);

        // Définissez le comportement du repository mock
        when(animalRepository.findByIdPerson(1)).thenReturn(animalList);

        // Exécutez la méthode du service
        List<String> result = animalService.getAnimalLinksByPersonId(1);

        // Vérifiez que la méthode du repository a été appelée
        verify(animalRepository, times(1)).findByIdPerson(1);

        // Vérifiez que le résultat est correct
        assertEquals(Arrays.asList("/animal/1", "/animal/2"), result);
    }

    @Test
    public void testGetAdoptionUrlsForAnimals() {
        // Créez une liste d'adoptions pour le test
        Animal adoptedAnimal1 = new Animal();
        adoptedAnimal1.setId(1);

        Animal adoptedAnimal2 = new Animal();
        adoptedAnimal2.setId(2);

        Adoption adoption1 = new Adoption();
        adoption1.setAdoptedAnimal(adoptedAnimal1);

        Adoption adoption2 = new Adoption();
        adoption2.setAdoptedAnimal(adoptedAnimal2);

        List<Adoption> adoptionList = Arrays.asList(adoption1, adoption2);

        // Définissez le comportement du repository mock
        when(adoptionRepository.findAll()).thenReturn(adoptionList);

        // Exécutez la méthode du service
        List<String> result = animalService.getAdoptionUrlsForAnimals();

        // Vérifiez que la méthode du repository a été appelée
        verify(adoptionRepository, times(1)).findAll();

        // Vérifiez que le résultat est correct
        assertEquals(Arrays.asList("/adoption/animal/1", "/adoption/animal/2"), result);
    }

    // Ajoutez d'autres tests pour les autres méthodes de la classe AnimalServiceImpl
}
