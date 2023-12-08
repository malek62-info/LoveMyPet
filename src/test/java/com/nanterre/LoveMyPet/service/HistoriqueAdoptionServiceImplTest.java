package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.HistoriqueAdoption;
import com.nanterre.LoveMyPet.repository.HistoriqueAdoptionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;

import static org.mockito.Mockito.*;

class HistoriqueAdoptionServiceImplTest {

    @Mock
    private HistoriqueAdoptionRepository historiqueAdoptionRepository;

    @InjectMocks
    private HistoriqueAdoptionServiceImpl historiqueAdoptionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testAjouterAdoption() {
        // Arrange
        Integer idAnimal = 1;
        Integer idPerson = 2;
        Date endDate = new Date(); // Utilisation de la date actuelle par exemple

        // Act
        historiqueAdoptionService.ajouterAdoption(idAnimal, idPerson, endDate);

        // Assert
        verify(historiqueAdoptionRepository, times(1)).save(any(HistoriqueAdoption.class));
    }
}
