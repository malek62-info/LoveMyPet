package com.nanterre.LoveMyPet.controller;

import com.nanterre.LoveMyPet.model.Medicament;
import com.nanterre.LoveMyPet.service.MedicamentService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class MedicamentControllerTests {

    @Mock
    private MedicamentService medicamentService;

    @InjectMocks
    private MedicamentController medicamentController;

    @Test
    public void testGetAllMedicaments() {
        List<Medicament> expectedMedicaments = new ArrayList<>();
        Medicament medicament1 = new Medicament();
        medicament1.setIdMedicament(1);
        expectedMedicaments.add(medicament1);

        when(medicamentService.getAllMedicaments()).thenReturn(expectedMedicaments);

        Iterable<Medicament> actualMedicaments = medicamentController.getAllMedicaments();

        assertEquals(expectedMedicaments, actualMedicaments);
    }
}
