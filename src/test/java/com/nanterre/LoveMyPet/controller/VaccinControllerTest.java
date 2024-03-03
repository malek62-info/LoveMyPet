package com.nanterre.LoveMyPet.controller;



import com.nanterre.LoveMyPet.controller.VaccinController;
import com.nanterre.LoveMyPet.model.Vaccin;
import com.nanterre.LoveMyPet.service.VaccinService;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class VaccinControllerTest {

    @Test
    void testGetAllVaccins() {
        // Mock service
        VaccinService vaccinService = mock(VaccinService.class);
        List<String> expectedReferences = Arrays.asList("vaccin/1", "vaccin/2");
        when(vaccinService.getAllVaccinReferences()).thenReturn(expectedReferences);

        // Create controller instance with mocked service
        VaccinController vaccinController = new VaccinController(vaccinService);

        // Call controller method
        ResponseEntity<List<String>> responseEntity = vaccinController.getAllVaccins();

        // Check response
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedReferences, responseEntity.getBody());
    }

    @Test
    void testGetVaccinById() {
        // Mock service
        VaccinService vaccinService = mock(VaccinService.class);
        Vaccin expectedVaccin = new Vaccin();
        expectedVaccin.setIdVaccin(1);
        when(vaccinService.getVaccinById(1)).thenReturn(expectedVaccin);

        // Create controller instance with mocked service
        VaccinController vaccinController = new VaccinController(vaccinService);

        // Call controller method
        ResponseEntity<Vaccin> responseEntity = vaccinController.getVaccinById(1);

        // Check response
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedVaccin, responseEntity.getBody());
    }
}
