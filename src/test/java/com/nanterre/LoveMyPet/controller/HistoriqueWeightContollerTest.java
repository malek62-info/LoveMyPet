package com.nanterre.LoveMyPet.controller;

import com.nanterre.LoveMyPet.model.HistoriqueWeight;
import com.nanterre.LoveMyPet.service.HistoriqueWeightServiceImpl;
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
class HistoriqueWeightControllerTest {

    @Mock
    private HistoriqueWeightServiceImpl historiqueWeightService;

    @InjectMocks
    private HistoriqueWeightController historiqueWeightController;

    @Test
    void testGetVaccinationReferenceByAnimalId() {
        // Mock du service pour simuler la liste des références de poids historique
        when(historiqueWeightService.getHistoriqueWeightLinksByAnimalId(1)).thenReturn(Arrays.asList("Link1", "Link2"));

        // Appel de la méthode du contrôleur
        List<String> result = historiqueWeightController.getVaccinationReferenceByAnimalId(1);

        // Assertions
        assertEquals(Arrays.asList("Link1", "Link2"), result);
        verify(historiqueWeightService, times(1)).getHistoriqueWeightLinksByAnimalId(1);
        verifyNoMoreInteractions(historiqueWeightService);
    }

    @Test
    void testGetHistoriqueWeightDetailsById() {
        // Création d'un objet HistoriqueWeight simulé
        HistoriqueWeight historiqueWeight = new HistoriqueWeight();
        historiqueWeight.setId(1);

        // Mock du service pour simuler les détails du poids historique
        when(historiqueWeightService.getHistoriqueWeightDetailsById(1)).thenReturn(historiqueWeight);

        // Appel de la méthode du contrôleur
        HistoriqueWeight result = historiqueWeightController.getHistoriqueWeightDetailsById(1);

        // Assertions
        assertEquals(historiqueWeight, result);
        verify(historiqueWeightService, times(1)).getHistoriqueWeightDetailsById(1);
        verifyNoMoreInteractions(historiqueWeightService);
    }

    @Test
    void testGetHistoriqueWeightDataByAnimalId() {
        // Création d'une liste simulée d'objets HistoriqueWeight
        List<HistoriqueWeight> historiqueWeights = Arrays.asList(new HistoriqueWeight(), new HistoriqueWeight());

        // Mock du service pour simuler les données du poids historique par animal
        when(historiqueWeightService.getHistoriqueWeightByAnimalId(1)).thenReturn(historiqueWeights);

        // Appel de la méthode du contrôleur
        ResponseEntity<List<HistoriqueWeight>> result = historiqueWeightController.getHistoriqueWeightDataByAnimalId(1);

        // Assertions
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(historiqueWeights, result.getBody());
        verify(historiqueWeightService, times(1)).getHistoriqueWeightByAnimalId(1);
        verifyNoMoreInteractions(historiqueWeightService);
    }
}
