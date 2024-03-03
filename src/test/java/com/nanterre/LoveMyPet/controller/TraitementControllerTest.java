package com.nanterre.LoveMyPet.controller;

import com.nanterre.LoveMyPet.model.Traitement;
import com.nanterre.LoveMyPet.service.TraitementService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class TraitementControllerTest {

    @Mock
    private TraitementService traitementService;

    @InjectMocks
    private TraitementController traitementController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetTraitementsByAnimalId() {
        // Arrange
        List<String> expectedTraitements = Arrays.asList("traitement/1", "traitement/2");
        when(traitementService.getTraitementsByAnimalId(anyInt())).thenReturn(expectedTraitements);

        // Act
        List<String> result = traitementController.getTraitementsByAnimalId(1);

        // Assert
        assertEquals(expectedTraitements, result);
        verify(traitementService, times(1)).getTraitementsByAnimalId(1);
    }

    @Test
    public void testGetTraitementById() {
        // Arrange
        Traitement expectedTraitement = new Traitement();
        expectedTraitement.setIdTraitement(1);
        when(traitementService.getTraitementById(anyInt())).thenReturn(Optional.of(expectedTraitement));

        // Act
        ResponseEntity<?> response = traitementController.getTraitementById(1);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedTraitement, response.getBody());
        verify(traitementService, times(1)).getTraitementById(1);
    }

    @Test
    public void testGetTraitementByIdNotFound() {
        // Arrange
        when(traitementService.getTraitementById(anyInt())).thenReturn(Optional.empty());

        // Act
        ResponseEntity<?> response = traitementController.getTraitementById(1);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Aucun traitement trouvé pour l'identifiant 1", response.getBody());
        verify(traitementService, times(1)).getTraitementById(1);
    }
}
