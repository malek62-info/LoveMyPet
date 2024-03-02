package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.Vaccination;
import com.nanterre.LoveMyPet.repository.VaccinationRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class VaccinationServiceImplTest {

    @Mock
    private VaccinationRepository vaccinationRepository;

    @InjectMocks
    private VaccinationServiceImpl vaccinationService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }



    @Test
    public void testGetVaccinationById() {
        int vaccinationId = 1;
        int idVaccin = 1;
        int idAnimal = 1;
        Date date = new Date();
        LocalTime vaccinationTime = LocalTime.of(9, 30);
        String vetAddress = "123 Main Street";
        String vetName = "Dr. Smith";
        String comment = "Annual checkup and vaccination";

        // Création de l'instance de Vaccination avec les valeurs nécessaires
        Vaccination mockVaccination = new Vaccination();
        mockVaccination.setIdVaccination(vaccinationId);
        mockVaccination.setIdVaccin(idVaccin);
        mockVaccination.setIdAnimal(idAnimal);
        mockVaccination.setDate(date);
        mockVaccination.setVaccinationTime(vaccinationTime);
        mockVaccination.setVetAddress(vetAddress);
        mockVaccination.setVetName(vetName);
        mockVaccination.setComment(comment);

        when(vaccinationRepository.findById(vaccinationId)).thenReturn(Optional.of(mockVaccination));

        Optional<Vaccination> result = vaccinationService.getVaccinationById(vaccinationId);

        assertEquals(mockVaccination, result.orElse(null));
    }




    @Test
    public void testGetVaccinationDetailsForEmails() {
        List<Object[]> mockDetails = new ArrayList<>();
        // Add mocked details here

        when(vaccinationRepository.findVaccinationDetailsForEmails()).thenReturn(mockDetails);

        List<Object[]> result = vaccinationService.getVaccinationDetailsForEmails();

        assertEquals(mockDetails, result);
    }
}
