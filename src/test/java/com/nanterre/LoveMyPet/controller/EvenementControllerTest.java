package com.nanterre.LoveMyPet.controller;

import com.nanterre.LoveMyPet.model.Evenement;
import com.nanterre.LoveMyPet.service.EvenementService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class EvenementControllerTest {

    @InjectMocks
    private EvenementController evenementController;

    @Mock
    private EvenementService evenementService;

    @Test
    public void testAddEvenement() {
        // Création d'une fausse image pour le test
        MultipartFile mockImageFile = null;  // Remplacez null par une implémentation appropriée de MultipartFile

        // Création d'un événement pour le test
        Evenement mockEvenement = new Evenement();
        mockEvenement.setTitre("Test Event");

        // Configuration du comportement du service de manière à ne pas lever d'exception
        when(evenementService.createEvenement(any(Evenement.class))).thenReturn(mockEvenement);

        // Appel de la méthode du contrôleur
        ResponseEntity<String> responseEntity = evenementController.addEvenement(mockImageFile, mockEvenement);

        // Vérification du statut de la réponse
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        // Vérification du message de la réponse
        assertEquals("Nouvel événement ajouté", responseEntity.getBody());
    }
}
