package com.nanterre.LoveMyPet.service;


import com.nanterre.LoveMyPet.model.Candidature;
import com.nanterre.LoveMyPet.repository.CandidatureRepository;
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
public class CandidatureServiceImplTests {

    @Mock
    private CandidatureRepository candidatureRepository;

    @InjectMocks
    private CandidatureServiceImpl candidatureService;

    @Test
    public void testGetCandidatureLinksByPersonId() {
        // Créez un objet Candidature pour le test
        Candidature candidature1 = new Candidature();
        candidature1.setIdCandidature(1);

        Candidature candidature2 = new Candidature();
        candidature2.setIdCandidature(2);

        // Définissez le comportement du mock pour renvoyer une liste de candidatures
        when(candidatureRepository.findByPersonIdPerson(anyInt()))
                .thenReturn(Arrays.asList(candidature1, candidature2));

        // Appel de la méthode à tester
        List<String> candidatureLinks = candidatureService.getCandidatureLinksByPersonId(1);

        // Vérifiez que la liste renvoyée correspond à ce qui est attendu
        List<String> expectedLinks = Arrays.asList("/candidature/1", "/candidature/2");
        assertEquals(expectedLinks, candidatureLinks);
    }

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
