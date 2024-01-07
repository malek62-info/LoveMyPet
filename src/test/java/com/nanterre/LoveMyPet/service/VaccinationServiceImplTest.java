package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.Vaccination;
import com.nanterre.LoveMyPet.repository.VaccinationRepository;
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

class VaccinationServiceImplTest {

    @Mock
    private VaccinationRepository vaccinationRepository;

    @InjectMocks
    private VaccinationServiceImpl vaccinationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSaveVaccination() {
        Vaccination vaccination = new Vaccination();
        vaccination.setIdVaccination(1);

        when(vaccinationRepository.save(vaccination)).thenReturn(vaccination);

        Vaccination result = vaccinationService.saveVaccination(vaccination);

        assertEquals(vaccination, result);

        verify(vaccinationRepository, times(1)).save(vaccination);
    }

    @Test
    void testGetVaccinationLinksByAnimalId() {
        Integer idAnimal = 1;

        Vaccination vaccination1 = new Vaccination();
        vaccination1.setIdVaccination(1);

        Vaccination vaccination2 = new Vaccination();
        vaccination2.setIdVaccination(2);

        List<Vaccination> vaccinations = new ArrayList<>();
        vaccinations.add(vaccination1);
        vaccinations.add(vaccination2);

        when(vaccinationRepository.findByAnimalId(idAnimal)).thenReturn(vaccinations);

        List<String> result = vaccinationService.getVaccinationLinksByAnimalId(idAnimal);

        assertEquals(2, result.size());
        assertEquals("/vaccination/1", result.get(0));
        assertEquals("/vaccination/2", result.get(1));

        verify(vaccinationRepository, times(1)).findByAnimalId(idAnimal);
    }

    @Test
    void testGetVaccinationDetailsById() {
        Integer idVaccination = 1;

        Vaccination vaccination = new Vaccination();
        vaccination.setIdVaccination(idVaccination);

        when(vaccinationRepository.findById(idVaccination)).thenReturn(Optional.of(vaccination));

        Vaccination result = vaccinationService.getVaccinationDetailsById(idVaccination);

        assertEquals(vaccination, result);

        verify(vaccinationRepository, times(1)).findById(idVaccination);
    }
}
