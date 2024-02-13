package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.HistoriqueWeight;
import com.nanterre.LoveMyPet.repository.HistoriqueWeightRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class HistoriqueWeightServiceImplTest {

    @Mock
    private HistoriqueWeightRepository historiqueWeightRepository;

    @InjectMocks
    private HistoriqueWeightServiceImpl historiqueWeightService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetHistoriqueWeightLinksByAnimalId() {
        Integer idAnimal = 1;

        HistoriqueWeight historiqueWeight1 = new HistoriqueWeight();
        historiqueWeight1.setId(1);

        HistoriqueWeight historiqueWeight2 = new HistoriqueWeight();
        historiqueWeight2.setId(2);

        List<HistoriqueWeight> historiqueWeights = new ArrayList<>();
        historiqueWeights.add(historiqueWeight1);
        historiqueWeights.add(historiqueWeight2);

        when(historiqueWeightRepository.findByAnimalId(idAnimal)).thenReturn(historiqueWeights);

        List<String> result = historiqueWeightService.getHistoriqueWeightLinksByAnimalId(idAnimal);

        assertEquals(2, result.size());
        assertEquals("/historiqueWeight/1", result.get(0));
        assertEquals("/historiqueWeight/2", result.get(1));

        verify(historiqueWeightRepository, times(1)).findByAnimalId(idAnimal);
    }

    @Test
    void testGetHistoriqueWeightDetailsById() {
        Integer idHistoriqueWeight = 1;

        HistoriqueWeight historiqueWeight = new HistoriqueWeight();
        historiqueWeight.setId(idHistoriqueWeight);

        when(historiqueWeightRepository.findById(idHistoriqueWeight)).thenReturn(Optional.of(historiqueWeight));

        HistoriqueWeight result = historiqueWeightService.getHistoriqueWeightDetailsById(idHistoriqueWeight);

        assertEquals(historiqueWeight, result);

        verify(historiqueWeightRepository, times(1)).findById(idHistoriqueWeight);
    }

    @Test
    void testGetHistoriqueWeightByAnimalId() {
        Integer idAnimal = 1;

        HistoriqueWeight historiqueWeight1 = new HistoriqueWeight();
        historiqueWeight1.setId(1);

        HistoriqueWeight historiqueWeight2 = new HistoriqueWeight();
        historiqueWeight2.setId(2);

        List<HistoriqueWeight> historiqueWeights = new ArrayList<>();
        historiqueWeights.add(historiqueWeight1);
        historiqueWeights.add(historiqueWeight2);

        when(historiqueWeightRepository.findByAnimalId(idAnimal)).thenReturn(historiqueWeights);

        List<HistoriqueWeight> result = historiqueWeightService.getHistoriqueWeightByAnimalId(idAnimal);

        assertEquals(2, result.size());
        assertEquals(historiqueWeight1, result.get(0));
        assertEquals(historiqueWeight2, result.get(1));

        verify(historiqueWeightRepository, times(1)).findByAnimalId(idAnimal);
    }
}
