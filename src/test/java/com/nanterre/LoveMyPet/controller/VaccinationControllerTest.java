package com.nanterre.LoveMyPet.controller;

import com.nanterre.LoveMyPet.controller.VaccinationController;
import com.nanterre.LoveMyPet.model.Vaccination;
import com.nanterre.LoveMyPet.service.VaccinationService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class VaccinationControllerTest {

    @Mock
    private VaccinationService vaccinationService;

    @InjectMocks
    private VaccinationController vaccinationController;

    public VaccinationControllerTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testAddVaccination() {
        // Given
        Vaccination vaccination = new Vaccination(); // Create a Vaccination object

        // When
        ResponseEntity<String> responseEntity = vaccinationController.addVaccination(vaccination);

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode()); // Check if response status is OK
        assertEquals("Vaccination added successfully", responseEntity.getBody()); // Check if response body is correct

        // Verify that the service method was called
        verify(vaccinationService, times(1)).addVaccination(vaccination);
    }
}
