package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.Medicament;
import com.nanterre.LoveMyPet.repository.MedicamentRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class MedicamentServiceImplTests {

    @Mock
    private MedicamentRepository medicamentRepository;

    @InjectMocks
    private MedicamentServiceImpl medicamentService;

    @Test
    public void testGetAllMedicaments() {
        // Préparation des données de test
        List<Medicament> expectedMedicaments = new ArrayList<>();
        Medicament medicament1 = new Medicament();
        Medicament medicament2 = new Medicament();
        expectedMedicaments.add(medicament1);
        expectedMedicaments.add(medicament2);

        // Simuler le comportement du repository
        when(medicamentRepository.findAll()).thenReturn(expectedMedicaments);

        // Exécuter la méthode à tester
        Iterable<Medicament> actualMedicaments = medicamentService.getAllMedicaments();

        // Vérifier les résultats
        assertEquals(expectedMedicaments, actualMedicaments);
    }

    
}
