package com.nanterre.LoveMyPet.controller;

import com.nanterre.LoveMyPet.controller.MesCandidatureController;
import com.nanterre.LoveMyPet.model.Candidature;
import com.nanterre.LoveMyPet.service.MesCandidatureServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class MesCandidatureControllerTest {

    @Mock
    private MesCandidatureServiceImpl candidatureService;

    @InjectMocks
    private MesCandidatureController mesCandidatureController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetCandidatureReferenceByPersonId() {
        // Arrange
        Integer idPerson = 1;
        List<String> expectedCandidatureLinks = Arrays.asList("link1", "link2");
        when(candidatureService.getCandidatureLinksByPersonId(idPerson)).thenReturn(expectedCandidatureLinks);

        // Act
        List<String> actualCandidatureLinks = mesCandidatureController.getCandidatureReferenceByPersonId(idPerson);

        // Assert
        assertEquals(expectedCandidatureLinks, actualCandidatureLinks);
        verify(candidatureService, times(1)).getCandidatureLinksByPersonId(idPerson);
    }

    @Test
    void testGetCandidatureDetailsById() {
        // Arrange
        Integer idCandidature = 1;
        Candidature expectedCandidature = new Candidature(); // Provide a sample Candidature object
        when(candidatureService.getCandidatureDetailsById(idCandidature)).thenReturn(expectedCandidature);

        // Act
        Candidature actualCandidature = mesCandidatureController.getCandidatureDetailsById(idCandidature);

        // Assert
        assertEquals(expectedCandidature, actualCandidature);
        verify(candidatureService, times(1)).getCandidatureDetailsById(idCandidature);
    }
}
