package com.nanterre.LoveMyPet.controller;

import com.nanterre.LoveMyPet.controller.InfoAnimalController;
import com.nanterre.LoveMyPet.model.Animal;
import com.nanterre.LoveMyPet.service.InfoAnimalServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class InfoAnimalControllerTest {

    @Mock
    private InfoAnimalServiceImpl infoAnimalService;

    @InjectMocks
    private InfoAnimalController infoAnimalController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testUpdateAnimalNameSuccess() {
        // Arrange
        Integer idAnimal = 1;
        String newName = "NewName";
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("newName", newName);

        // Act
        ResponseEntity<String> actualResponse = infoAnimalController.updateAnimalName(idAnimal, requestBody);

        // Assert
        assertEquals(ResponseEntity.ok("Le nom de l'animal a été mis à jour avec succès."), actualResponse);
        verify(infoAnimalService, times(1)).updateAnimalName(idAnimal, newName);
    }

    @Test
    void testUpdateAnimalNameEmptyName() {
        // Arrange
        Integer idAnimal = 1;
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("newName", "");

        // Act
        ResponseEntity<String> actualResponse = infoAnimalController.updateAnimalName(idAnimal, requestBody);

        // Assert
        assertEquals(ResponseEntity.badRequest().body("Le nouveau nom ne peut pas être vide."), actualResponse);
        verify(infoAnimalService, never()).updateAnimalName(anyInt(), anyString());
    }

    @Test
    void testUpdateAnimalWeightSuccess() {
        // Arrange
        Integer idAnimal = 1;
        Double newWeight = 10.5;
        Map<String, Double> requestBody = new HashMap<>();
        requestBody.put("newWeight", newWeight);

        // Act
        ResponseEntity<String> actualResponse = infoAnimalController.updateAnimalWeight(idAnimal, requestBody);

        // Assert
        assertEquals(ResponseEntity.ok("Le poids de l'animal a été mis à jour avec succès."), actualResponse);
        verify(infoAnimalService, times(1)).updateAnimalWeight(idAnimal, newWeight);
    }

    @Test
    void testUpdateAnimalWeightEmptyWeight() {
        // Arrange
        Integer idAnimal = 1;
        Map<String, Double> requestBody = new HashMap<>();
        requestBody.put("newWeight", null); // Or any other invalid value

        // Act
        ResponseEntity<String> actualResponse = infoAnimalController.updateAnimalWeight(idAnimal, requestBody);

        // Assert
        assertEquals(ResponseEntity.badRequest().body("Le nouveau poids ne peut pas être vide."), actualResponse);
        verify(infoAnimalService, never()).updateAnimalWeight(anyInt(), anyDouble());
    }

    

    @Test
    void testUpdateAnimalImageSuccess() {
        // Arrange
        Integer idAnimal = 1;
        MockMultipartFile imageFile = new MockMultipartFile("imageFile", "test.jpg", "image/jpeg", "some image".getBytes());

        // Act
        ResponseEntity<String> actualResponse = infoAnimalController.updateAnimalImage(idAnimal, imageFile);

        // Assert
        assertEquals(ResponseEntity.ok("L'image de l'animal a été mise à jour avec succès."), actualResponse);
        verify(infoAnimalService, times(1)).updateAnimalImage(idAnimal, "test.jpg");
    }

    @Test
    void testUpdateAnimalImageEmptyFile() {
        // Arrange
        Integer idAnimal = 1;
        MockMultipartFile imageFile = null; // Or any other invalid value

        // Act
        ResponseEntity<String> actualResponse = infoAnimalController.updateAnimalImage(idAnimal, imageFile);

        // Assert
        assertEquals(ResponseEntity.badRequest().body("Le fichier image ne peut pas être vide."), actualResponse);
        verify(infoAnimalService, never()).updateAnimalImage(anyInt(), any());
    }
    @Test
    void testUpdateAnimalImageError() throws IOException {
        // Arrange
        Integer idAnimal = 1;
        MockMultipartFile imageFile = new MockMultipartFile("imageFile", "test.jpg", "image/jpeg", "some image".getBytes());

        doAnswer(invocation -> {
            throw new IOException("Simulated IOException");
        }).when(infoAnimalService).updateAnimalImage(idAnimal, "test.jpg");

        // Act
        ResponseEntity<String> actualResponse = infoAnimalController.updateAnimalImage(idAnimal, imageFile);

        // Assert
        assertEquals(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la gestion de l'image"), actualResponse);
        verify(infoAnimalService, times(1)).updateAnimalImage(idAnimal, "test.jpg");
    }
    @Test
    void testGetAnimalDetailsById() {
        // Arrange
        Integer idAnimal = 1;
        Animal expectedAnimal = new Animal(); // Créez un objet Animal simulé pour le test
        when(infoAnimalService.getInfoAnimalDetailsById(idAnimal)).thenReturn(expectedAnimal);

        // Act
        Animal actualAnimal = infoAnimalController.getCandidatureDetailsById(idAnimal);

        // Assert
        assertEquals(expectedAnimal, actualAnimal);
        verify(infoAnimalService, times(1)).getInfoAnimalDetailsById(idAnimal);
    }
}
