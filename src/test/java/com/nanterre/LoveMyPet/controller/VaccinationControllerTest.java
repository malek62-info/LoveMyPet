package com.nanterre.LoveMyPet.controller;

import com.nanterre.LoveMyPet.model.Vaccination;
import com.nanterre.LoveMyPet.service.VaccinationServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VaccinationControllerTest {

    @Mock
    private VaccinationServiceImpl vaccinationService;

    @InjectMocks
    private VaccinationController vaccinationController;

    @Test
    void testGetVaccinationReferenceByAnimalId() {
        // Mock du service pour simuler la liste des références de vaccinations
        when(vaccinationService.getVaccinationLinksByAnimalId(1)).thenReturn(Arrays.asList("Link1", "Link2"));

        // Appel de la méthode du contrôleur
        List<String> result = vaccinationController.getVaccinationReferenceByAnimalId(1);

        // Assertions
        assertEquals(Arrays.asList("Link1", "Link2"), result);
        verify(vaccinationService, times(1)).getVaccinationLinksByAnimalId(1);
        verifyNoMoreInteractions(vaccinationService);
    }

    @Test
    void testGetVaccinationDetailsById() {
        // Création d'un objet Vaccination simulé
        Vaccination vaccination = new Vaccination();
        vaccination.setIdVaccination(1);

        // Mock du service pour simuler les détails de la vaccination
        when(vaccinationService.getVaccinationDetailsById(1)).thenReturn(vaccination);

        // Appel de la méthode du contrôleur
        Vaccination result = vaccinationController.getVaccinationDetailsById(1);

        // Assertions
        assertEquals(vaccination, result);
        verify(vaccinationService, times(1)).getVaccinationDetailsById(1);
        verifyNoMoreInteractions(vaccinationService);
    }

    @Test
    void testAddVaccination() {
        // Création d'un objet Vaccination simulé
        Vaccination vaccination = new Vaccination();

        // Appel de la méthode du contrôleur
        String response = vaccinationController.add(vaccination, 1);

        // Assertions
        assertEquals("Nouvelle vaccination ajoutée", response);
        verify(vaccinationService, times(1)).saveVaccination(vaccination);
        verifyNoMoreInteractions(vaccinationService);
    }
}
