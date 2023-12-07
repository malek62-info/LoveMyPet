package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.Animal;
import com.nanterre.LoveMyPet.repository.InfoAnimalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class InfoAnimalServiceTest {

    @Mock
    private InfoAnimalRepository animalInfoRepository;

    @InjectMocks
    private InfoAnimalServiceImpl infoAnimalService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetInfoAnimalDetailsById() {
        // Create a sample animal
        Animal animal = new Animal();
        animal.setId(1);

        // Mock the behavior of the repository
        when(animalInfoRepository.findById(1)).thenReturn(Optional.of(animal));

        // Call the service method
        Animal result = infoAnimalService.getInfoAnimalDetailsById(1);

        // Verify the result
        assertEquals(animal, result);
    }

    @Test
    public void testUpdateAnimalName() {
        // Create a sample animal
        Animal animal = new Animal();
        animal.setId(1);

        // Mock the behavior of the repository
        when(animalInfoRepository.findById(1)).thenReturn(Optional.of(animal));

        // Call the service method
        infoAnimalService.updateAnimalName(1, "NewName");

        // Verify that the name is updated and the save method is called
        assertEquals("NewName", animal.getName());
        verify(animalInfoRepository, times(1)).save(animal);
    }

    @Test
    public void testUpdateAnimalWeight() {
        // Create a sample animal
        Animal animal = new Animal();
        animal.setId(1);

        // Mock the behavior of the repository
        when(animalInfoRepository.findById(1)).thenReturn(Optional.of(animal));

        // Call the service method
        infoAnimalService.updateAnimalWeight(1, 15.0);

        // Verify that the weight is updated and the save method is called
        assertEquals(15.0, animal.getWeight());
        verify(animalInfoRepository, times(1)).save(animal);
    }

    @Test
    public void testUpdateAnimalImage() {
        // Create a sample animal
        Animal animal = new Animal();
        animal.setId(1);

        // Mock the behavior of the repository
        when(animalInfoRepository.findById(1)).thenReturn(Optional.of(animal));

        // Call the service method
        infoAnimalService.updateAnimalImage(1, "newImageUrl");

        // Verify that the image URL is updated and the save method is called
        assertEquals("newImageUrl", animal.getImageUrl());
        verify(animalInfoRepository, times(1)).save(animal);
    }
}
