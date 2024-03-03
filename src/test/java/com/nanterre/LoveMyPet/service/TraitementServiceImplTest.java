package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.Traitement;
import com.nanterre.LoveMyPet.repository.TraitementRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class TraitementServiceImplTest {

    @Mock
    private TraitementRepository traitementRepository;

    @InjectMocks
    private TraitementServiceImpl traitementService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }



    @Test
    public void testGetTraitementById() {
        int traitementId = 1;
        Traitement mockTraitement = new Traitement(traitementId, 1, "Traitement1");

        when(traitementRepository.findById(traitementId)).thenReturn(Optional.of(mockTraitement));

        Optional<Traitement> result = traitementService.getTraitementById(traitementId);

        assertEquals(mockTraitement, result.orElse(null)); // Vérifiez que le traitement retourné est correct
    }
}
