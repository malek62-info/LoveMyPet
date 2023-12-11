package com.nanterre.LoveMyPet.controller;

import com.nanterre.LoveMyPet.model.Advice;
import com.nanterre.LoveMyPet.service.AdviceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AdviceControllerTest {

    @Mock
    private AdviceService adviceService;

    @InjectMocks
    private AdviceController adviceController;

    @Test
    void addAdvice() {
        // Création d'un objet Advice pour le test
        Advice advice = new Advice();
        advice.setTextAdvice("Test advice text");

        // Création d'un MultipartFile fictif pour le test
        MultipartFile imageFile = new MockMultipartFile("image", "test-image.jpg", "image/jpeg", "fake-image".getBytes());

        // Simulation du comportement du service
        doNothing().when(adviceService).addAdvice(any(Advice.class));

        // Appel de la méthode du contrôleur
        ResponseEntity<String> response = adviceController.addAdvice(imageFile, "Test advice text", 1);

        // Assertions
        verify(adviceService, times(1)).addAdvice(any(Advice.class));
        verifyNoMoreInteractions(adviceService);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Advice added successfully", response.getBody());
    }
}

