package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.Adoption;
import com.nanterre.LoveMyPet.model.Animal;
import com.nanterre.LoveMyPet.repository.AdoptionRepository;
import com.nanterre.LoveMyPet.repository.AnimalRepository;
import com.nanterre.LoveMyPet.service.AdoptionServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AdoptionServiceTest {

    @Mock
    private AnimalRepository animalRepository;

    @Mock
    private AdoptionRepository adoptionRepository;

    @InjectMocks
    private AdoptionServiceImpl adoptionService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllAdoptionUrls() {
        // Simuler la réponse du repository
        when(adoptionRepository.findAll()).thenReturn(Arrays.asList(new Adoption(), new Adoption()));

        // Appeler la méthode du service
        List<String> adoptionUrls = adoptionService.getAllAdoptionUrls();

        // Vérifier le résultat
        assertEquals(2, adoptionUrls.size());
        // Vous pouvez ajouter d'autres vérifications en fonction du comportement
        // attendu
    }

    @Test
    public void testGetAdoptionDetails() {
        // Créer un objet Adoption simulé
        Adoption adoption = new Adoption();
        adoption.setIdAdoption(1);
        adoption.setAdoptedAnimal(new Animal());
        adoption.setStartDate(new Date());
        adoption.setEndDate(new Date());

        // Simuler la réponse du repository
        when(adoptionRepository.findById(1)).thenReturn(java.util.Optional.of(adoption));

        // Appeler la méthode du service
        Map<String, Object> adoptionDetails = adoptionService.getAdoptionDetails(1);

        // Vérifier le résultat
        assertEquals(1, adoptionDetails.get("adoptionId"));
        assertEquals(adoption.getAdoptedAnimal(), adoptionDetails.get("animal"));
        // Vous pouvez ajouter d'autres vérifications en fonction du comportement
        // attendu
    }

    // Ajouter d'autres tests pour les autres méthodes du service
}
