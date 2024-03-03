package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.Vaccination;
import com.nanterre.LoveMyPet.repository.VaccinationRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class VaccinationServiceImplTest {

    @Mock
    private VaccinationRepository vaccinationRepository;

    @InjectMocks
    private VaccinationServiceImpl vaccinationService;

    public VaccinationServiceImplTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testAddVaccination() {
        // Given
        Vaccination vaccination = new Vaccination(); // Create a Vaccination object

        // When
        vaccinationService.addVaccination(vaccination);

        // Then
        verify(vaccinationRepository, times(1)).save(vaccination); // Verify that the save method was called once with the correct parameter
    }


    @Test
    public void testGetVaccination_DetailsForEmails() {
        List<Object[]> mockDetails = new ArrayList<>();
        // Add mocked details here

        when(vaccinationRepository.findVaccinationDetailsForEmails()).thenReturn(mockDetails);

        List<Object[]> result = vaccinationService.getVaccinationDetailsForEmails();

        assertEquals(mockDetails, result);
    }
}