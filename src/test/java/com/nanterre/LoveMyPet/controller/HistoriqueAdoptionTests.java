package com.nanterre.LoveMyPet.controller;

import com.nanterre.LoveMyPet.service.HistoriqueAdoptionServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class HistoriqueAdoptionControllerTest {

    @Mock
    private HistoriqueAdoptionServiceImpl historiqueAdoptionService;

    @InjectMocks
    private HistoriqueAdoptionController historiqueAdoptionController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testAjouterAdoptionSuccess() throws ParseException {
        // Arrange
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("idAnimal", 1);
        requestBody.put("idPerson", 2);
        requestBody.put("endDate", "2023-12-10");

        // Act
        ResponseEntity<String> actualResponse = historiqueAdoptionController.ajouterAdoption(requestBody);

        // Assert
        assertEquals(ResponseEntity.ok("L'adoption a été ajoutée avec succès."), actualResponse);
        verify(historiqueAdoptionService, times(1)).ajouterAdoption(1, 2, new SimpleDateFormat("yyyy-MM-dd").parse("2023-12-10"));
    }

    @Test
    void testAjouterAdoptionInvalidDateFormat() {
        // Arrange
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("idAnimal", 1);
        requestBody.put("idPerson", 2);
        requestBody.put("endDate", "2023/12/10"); // Format de date incorrect

        // Act
        ResponseEntity<String> actualResponse = historiqueAdoptionController.ajouterAdoption(requestBody);

        // Assert
        assertEquals(ResponseEntity.badRequest().body("Le format de la date endDate est incorrect."), actualResponse);
        verify(historiqueAdoptionService, never()).ajouterAdoption(anyInt(), anyInt(), any());
    }

    @Test
    void testAjouterAdoptionMissingData() {
        // Arrange
        Map<String, Object> requestBody = new HashMap<>();
        // Manque des données nécessaires

        // Act
        ResponseEntity<String> actualResponse = historiqueAdoptionController.ajouterAdoption(requestBody);

        // Assert
        assertEquals(ResponseEntity.badRequest().body("Les identifiants de l'animal, de la personne et la date endDate sont nécessaires."), actualResponse);
        verify(historiqueAdoptionService, never()).ajouterAdoption(anyInt(), anyInt(), any());
    }
}
