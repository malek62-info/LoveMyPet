package com.nanterre.LoveMyPet.service;


import com.nanterre.LoveMyPet.model.Candidature;
import com.nanterre.LoveMyPet.repository.MesCandidatureRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest
public class MesCandidatureServiceImplTests {

    @Mock
    private MesCandidatureRepository candidatureRepository;

    @InjectMocks
    private MesCandidatureServiceImpl candidatureService;


    @Test
    public void testGetCandidatureDetailsById() {
        // Créez un objet Candidature pour le test
        Candidature candidature = new Candidature();
        candidature.setIdCandidature(1);

        // Définissez le comportement du mock pour renvoyer une candidature
        when(candidatureRepository.findById(anyInt()))
                .thenReturn(Optional.of(candidature));

        // Appel de la méthode à tester
        Candidature retrievedCandidature = candidatureService.getCandidatureDetailsById(1);

        // Vérifiez que la candidature renvoyée correspond à celle attendue
        assertEquals(candidature, retrievedCandidature);
    }
}
