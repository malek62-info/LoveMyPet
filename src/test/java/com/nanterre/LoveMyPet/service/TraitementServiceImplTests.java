package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.Heure;
import com.nanterre.LoveMyPet.model.Traitement;
import com.nanterre.LoveMyPet.repository.TraitementRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class TraitementServiceImplTests {

    @Mock
    private TraitementRepository traitementRepository;

    @InjectMocks
    private TraitementServiceImpl traitementService;

    @Test
    public void testGetTraitementsByAnimalId() {
        // Préparation des données de test
        List<Traitement> expectedTraitements = new ArrayList<>();
        Traitement traitement1 = new Traitement();
        Traitement traitement2 = new Traitement();
        expectedTraitements.add(traitement1);
        expectedTraitements.add(traitement2);

        // Simuler le comportement du repository
        when(traitementRepository.findByAnimalId(1)).thenReturn(expectedTraitements);

        // Exécuter la méthode à tester
        List<String> actualTraitements = traitementService.getTraitementsByAnimalId(1);

        // Vérifier les résultats
        assertEquals(2, actualTraitements.size());
    }

    @Test
    public void testGetTraitementById() {
        // Préparation des données de test
        Traitement expectedTraitement = new Traitement();
        expectedTraitement.setIdTraitement(1);

        // Simuler le comportement du repository
        when(traitementRepository.findById(1)).thenReturn(Optional.of(expectedTraitement));

        // Exécuter la méthode à tester
        Optional<Traitement> actualTraitement = traitementService.getTraitementById(1);

        // Vérifier les résultats
        assertTrue(actualTraitement.isPresent());
        assertEquals(expectedTraitement, actualTraitement.get());
    }

    @Test
    public void testSaveTraitement() {
        // Préparation des données de test
        Traitement traitement = new Traitement();

        // Simuler le comportement du repository
        when(traitementRepository.save(traitement)).thenReturn(traitement);

        // Exécuter la méthode à tester
        Traitement savedTraitement = traitementService.saveTraitement(traitement);

        // Vérifier les résultats
        assertEquals(traitement, savedTraitement);
    }

    @Test
    public void testGetTraitementDetailsById() {
        // Préparation des données de test
        Traitement expectedTraitement = new Traitement();
        expectedTraitement.setIdTraitement(1);

        // Simuler le comportement du repository
        when(traitementRepository.findById(1)).thenReturn(Optional.of(expectedTraitement));

        // Exécuter la méthode à tester
        Traitement actualTraitement = traitementService.getTraitementDetailsById(1);

        // Vérifier les résultats
        assertEquals(expectedTraitement, actualTraitement);
    }

   
    @Test
    public void testGetHeuresByTraitementId() {
        // Préparation des données de test
        Traitement traitement = new Traitement();
        Heure heure1 = new Heure();
        Heure heure2 = new Heure();
        traitement.setHeures(List.of(heure1, heure2));

        // Simuler le comportement du repository
        when(traitementRepository.findById(1)).thenReturn(Optional.of(traitement));

        // Exécuter la méthode à tester
        List<Heure> actualHeures = traitementService.getHeuresByTraitementId(1);

        // Vérifier les résultats
        assertEquals(2, actualHeures.size());
    }

  

    
    @Test
    public void testGetTraitementsDetailsByAnimalId() {
        // Préparation des données de test
        List<Traitement> expectedTraitements = new ArrayList<>();
        Traitement traitement1 = new Traitement();
        Traitement traitement2 = new Traitement();
        expectedTraitements.add(traitement1);
        expectedTraitements.add(traitement2);

        // Simuler le comportement du repository
        when(traitementRepository.findByAnimalId(1)).thenReturn(expectedTraitements);

        // Exécuter la méthode à tester
        List<Traitement> actualTraitements = traitementService.getTraitementsDetailsByAnimalId(1);

        // Vérifier les résultats
        assertEquals(2, actualTraitements.size());
    }
    @Test
    public void testGetTraitementLinksByAnimalId() {
        // Préparation des données de test
        List<Traitement> traitements = new ArrayList<>();
        Traitement traitement1 = new Traitement();
        Traitement traitement2 = new Traitement();
        traitement1.setIdTraitement(1);
        traitement2.setIdTraitement(2);
        traitements.add(traitement1);
        traitements.add(traitement2);

        // Simuler le comportement du repository
        when(traitementRepository.findByAnimalId(1)).thenReturn(traitements);

        // Exécuter la méthode à tester
        List<String> actualLinks = traitementService.getTraitementLinksByAnimalId(1);

        // Vérifier les résultats
        assertEquals(2, actualLinks.size());
        assertEquals("/traitement/1", actualLinks.get(0));
        assertEquals("/traitement/2", actualLinks.get(1));
    }
}
