package com.nanterre.LoveMyPet.controller;
import com.nanterre.LoveMyPet.model.Vaccination;
import com.nanterre.LoveMyPet.service.VaccinationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class VaccinationControllerTest {

    @Mock
    private VaccinationService vaccinationService;

    @InjectMocks
    private VaccinationController vaccinationController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetVaccinationsByAnimalId() {
        // Arrange
        List<String> expectedVaccinations = new ArrayList<>();
        expectedVaccinations.add("/vaccination/1");
        expectedVaccinations.add("/vaccination/2");
        when(vaccinationService.getVaccinationsByAnimalId(anyInt())).thenReturn(expectedVaccinations);

        // Act
        ResponseEntity<List<String>> response = vaccinationController.getVaccinationsByAnimalId(1);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedVaccinations, response.getBody());
        verify(vaccinationService, times(1)).getVaccinationsByAnimalId(1);
    }


    @Test
    public void testGetVaccinationDetails() {
        // Arrange
        Vaccination expectedVaccination = new Vaccination();
        expectedVaccination.setIdVaccination(1);
        when(vaccinationService.getVaccinationById(anyInt())).thenReturn(Optional.of(expectedVaccination));

        // Act
        ResponseEntity<Vaccination> response = vaccinationController.getVaccinationDetails(1);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedVaccination, response.getBody());
        verify(vaccinationService, times(1)).getVaccinationById(1);
    }

    @Test
    public void testGetVaccinationDetailsNotFound() {
        // Arrange
        when(vaccinationService.getVaccinationById(anyInt())).thenReturn(Optional.empty());

        // Act
        ResponseEntity<Vaccination> response = vaccinationController.getVaccinationDetails(1);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(vaccinationService, times(1)).getVaccinationById(1);
    }
}
