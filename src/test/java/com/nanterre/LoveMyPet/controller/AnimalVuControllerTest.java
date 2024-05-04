package com.nanterre.LoveMyPet.controller;

import com.nanterre.LoveMyPet.controller.AnimalVuController;
import com.nanterre.LoveMyPet.model.AnimalVu;
import com.nanterre.LoveMyPet.service.AnimalVuService;
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

class AnimalVuControllerTest {

    @Mock
    private AnimalVuService animalVuService;

    @InjectMocks
    private AnimalVuController animalVuController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

  

   

    @Test
    void testSupprimerAnimalVuSuccess() {
        Integer idAnimal = 1;
        ResponseEntity<String> expectedResponse = new ResponseEntity<>("Animal vu supprimé avec succès.", HttpStatus.OK);
        ResponseEntity<?> actualResponse = animalVuController.supprimerAnimalVu(idAnimal);
        assertEquals(expectedResponse, actualResponse);
        verify(animalVuService, times(1)).supprimerAnimalVu(idAnimal);
    }

    @Test
    void testSupprimerAnimalVuError() {
        Integer idAnimal = 1;
        doThrow(new RuntimeException("Error")).when(animalVuService).supprimerAnimalVu(idAnimal);
        ResponseEntity<String> expectedResponse = new ResponseEntity<>("Erreur lors de la suppression de l'animal vu.", HttpStatus.INTERNAL_SERVER_ERROR);
        ResponseEntity<?> actualResponse = animalVuController.supprimerAnimalVu(idAnimal);
        assertEquals(expectedResponse, actualResponse);
        verify(animalVuService, times(1)).supprimerAnimalVu(idAnimal);
    }
}

