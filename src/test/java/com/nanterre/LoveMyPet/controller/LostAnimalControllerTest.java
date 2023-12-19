package com.nanterre.LoveMyPet.controller;
import com.nanterre.LoveMyPet.controller.LostAnimalController;
import com.nanterre.LoveMyPet.model.LostAnimal;
import com.nanterre.LoveMyPet.service.LostAnimalService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class LostAnimalControllerTest {

    @Mock
    private LostAnimalService lostAnimalService;

    @InjectMocks
    private LostAnimalController lostAnimalController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testAddLostAnimal() throws Exception {
        // Arrange
        MockMultipartFile imageFile = new MockMultipartFile("imageFile", "test.jpg", "image/jpeg", "image data".getBytes());
        LostAnimal lostAnimal = new LostAnimal(); // Provide a sample LostAnimal object

        // Act
        ResponseEntity<String> response = lostAnimalController.addLostAnimal(imageFile, lostAnimal);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(lostAnimalService, times(1)).saveLostAnimal(lostAnimal);
    }

 
    @Test
    void testGetAllLostAnimals() {
        // Arrange
        LostAnimal dog = new LostAnimal();
        dog.setName("Dog");
        dog.setRace("Brown");

        LostAnimal cat = new LostAnimal();
        cat.setName("Cat");
        cat.setRace("Gray");

        List<LostAnimal> expectedLostAnimals = Arrays.asList(dog, cat);
        when(lostAnimalService.getAllLostAnimals()).thenReturn(expectedLostAnimals);

        // Act
        List<LostAnimal> actualLostAnimals = lostAnimalController.getAllLostAnimals();

        // Assert
        assertEquals(expectedLostAnimals, actualLostAnimals);
        verify(lostAnimalService, times(1)).getAllLostAnimals();
    }

}
