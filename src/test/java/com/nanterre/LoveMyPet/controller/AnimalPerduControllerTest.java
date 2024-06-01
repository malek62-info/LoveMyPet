package com.nanterre.LoveMyPet.controller;

import com.nanterre.LoveMyPet.controller.AnimalPerduController;
import com.nanterre.LoveMyPet.model.AnimalPerdu;
import com.nanterre.LoveMyPet.service.AnimalPerduService;
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

class AnimalPerduControllerTest {

    @Mock
    private AnimalPerduService animalPerduService;

    @InjectMocks
    private AnimalPerduController animalPerduController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    
/*
    @Test
    void testGetLostAnimalsByPersonIdSuccess() {
        Integer idPerson = 1;
        List<AnimalPerdu> expected = Arrays.asList(new AnimalPerdu(), new AnimalPerdu());
        when(animalPerduService.findAnimalsLostByPersonId(idPerson)).thenReturn(expected);
        ResponseEntity<List<AnimalPerdu>> actualResponse = animalPerduController.getLostAnimalsByPersonId(idPerson);
        assertEquals(ResponseEntity.ok(expected), actualResponse);
        verify(animalPerduService, times(1)).findAnimalsLostByPersonId(idPerson);
    }

    @Test
    void testGetLostAnimalsByPersonIdError() {
        Integer idPerson = 1;
        when(animalPerduService.findAnimalsLostByPersonId(idPerson)).thenThrow(new RuntimeException("Error"));
        ResponseEntity<List<AnimalPerdu>> actualResponse = animalPerduController.getLostAnimalsByPersonId(idPerson);
        assertEquals(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null), actualResponse);
        verify(animalPerduService, times(1)).findAnimalsLostByPersonId(idPerson);
    }

    @Test
    void testSupprimerAnimalPerduSuccess() {
        Integer idAnimal = 1;
        ResponseEntity<String> expectedResponse = new ResponseEntity<>("Animal perdu supprimé avec succès.", HttpStatus.OK);
        ResponseEntity<?> actualResponse = animalPerduController.supprimerAnimalPerdu(idAnimal);
        assertEquals(expectedResponse, actualResponse);
        verify(animalPerduService, times(1)).supprimerAnimalPerdu(idAnimal);
    }

    @Test
    void testSupprimerAnimalPerduError() {
        Integer idAnimal = 1;
        doThrow(new RuntimeException("Error")).when(animalPerduService).supprimerAnimalPerdu(idAnimal);
        ResponseEntity<String> expectedResponse = new ResponseEntity<>("Erreur lors de la suppression de l'animal perdu.", HttpStatus.INTERNAL_SERVER_ERROR);
        ResponseEntity<?> actualResponse = animalPerduController.supprimerAnimalPerdu(idAnimal);
        assertEquals(expectedResponse, actualResponse);
        verify(animalPerduService, times(1)).supprimerAnimalPerdu(idAnimal);
    }

    :
 */
}
