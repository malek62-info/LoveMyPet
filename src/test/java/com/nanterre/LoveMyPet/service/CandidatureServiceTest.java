package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.Candidature;
import com.nanterre.LoveMyPet.repository.CandidatureRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

public class CandidatureServiceTest {

    @Mock
    private CandidatureRepository candidatureRepository;

    @InjectMocks
    private CandidatureServiceImpl candidatureService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetCandidatureLinksByAnimalId() {
        // Create a sample candidature
        Candidature candidature1 = new Candidature();
        candidature1.setIdCandidature(1);

        Candidature candidature2 = new Candidature();
        candidature2.setIdCandidature(2);

        // Mock the behavior of the repository
        when(candidatureRepository.getCandidaturesByAnimalId(1)).thenReturn(Arrays.asList(candidature1, candidature2));

        // Call the service method
        List<String> result = candidatureService.getCandidatureLinksByAnimalId(1);

        // Verify the result
        assertEquals(Arrays.asList("/animal/1/candidature/1", "/animal/1/candidature/2"), result);
    }


    @Test
    public void testGetCandidatureDetailsByAnimalIdAndCandidatureId_NotFound() {
        // Mock the behavior of the repository for a non-existing candidature
        when(candidatureRepository.findById(1)).thenReturn(Optional.empty());

        // Call the service method
        Candidature result = candidatureService.getCandidatureDetailsByAnimalIdAndCandidatureId(1, 1);

        // Verify the result
        assertNull(result);
    }


    @Test
    public void testSaveCandidature() {
        // Create a sample candidature
        Candidature candidature = new Candidature();

        // Call the service method
        candidatureService.saveCandidature(candidature);

        // Verify that the save method is called
        verify(candidatureRepository, times(1)).save(candidature);
    }

    @Test
    public void testDeleteCandidature() {
        // Create a sample candidature
        Candidature candidature = new Candidature();

        // Call the service method
        candidatureService.deleteCandidature(candidature);

        // Verify that the delete method is called
        verify(candidatureRepository, times(1)).delete(candidature);
    }
}
