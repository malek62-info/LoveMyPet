package com.nanterre.LoveMyPet.model;

import com.nanterre.LoveMyPet.model.Vaccin;
import com.nanterre.LoveMyPet.repository.VaccinRepository;
import com.nanterre.LoveMyPet.service.VaccinServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class VaccinServiceImplTest {

    @Mock
    private VaccinRepository vaccinRepository;

    @InjectMocks
    private VaccinServiceImpl vaccinService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllVaccinReferences() {
        // Given
        Vaccin vaccin1 = new Vaccin();
        vaccin1.setIdVaccin(1);
        Vaccin vaccin2 = new Vaccin();
        vaccin2.setIdVaccin(2);
        when(vaccinRepository.findAll()).thenReturn(Arrays.asList(vaccin1, vaccin2));

        // When
        List<String> references = vaccinService.getAllVaccinReferences();

        // Then
        assertEquals(2, references.size());
        assertEquals("vaccin/1", references.get(0));
        assertEquals("vaccin/2", references.get(1));
    }

    @Test
    void testGetVaccinById() {
        // Given
        Vaccin vaccin = new Vaccin();
        vaccin.setIdVaccin(1);
        when(vaccinRepository.findById(1)).thenReturn(Optional.of(vaccin));

        // When
        Vaccin retrievedVaccin = vaccinService.getVaccinById(1);

        // Then
        assertEquals(1, retrievedVaccin.getIdVaccin());
    }
}
