package com.nanterre.LoveMyPet.controller;

import com.nanterre.LoveMyPet.service.HistoriqueAdoptionService.FeedingConfirmationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class FeedingConfirmationControllerTest {

    @Mock
    private FeedingConfirmationServiceImpl feedingConfirmationService;

    @InjectMocks
    private FeedingConfirmationController feedingConfirmationController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testConfirmFeedingSuccess() {
        // Arrange
        Integer personId = 1;
        Integer animalId = 2;
        Integer feedingTimeId = 3;
        String confirmationCode = "123456";

        when(feedingConfirmationService.confirmFeeding(personId, animalId, feedingTimeId, confirmationCode)).thenReturn(true);

        // Act
        String result = feedingConfirmationController.confirmFeeding(personId, animalId, feedingTimeId, confirmationCode);

        // Assert
        assertEquals("Comfirmation réussie", result);
        verify(feedingConfirmationService, times(1)).confirmFeeding(personId, animalId, feedingTimeId, confirmationCode);
    }

    @Test
    void testConfirmFeedingFailure() {
        // Arrange
        Integer personId = 1;
        Integer animalId = 2;
        Integer feedingTimeId = 3;
        String confirmationCode = "123456";

        when(feedingConfirmationService.confirmFeeding(personId, animalId, feedingTimeId, confirmationCode)).thenReturn(false);

        // Act
        String result = feedingConfirmationController.confirmFeeding(personId, animalId, feedingTimeId, confirmationCode);

        // Assert
        assertEquals("Failed to confirm feeding.", result);
        verify(feedingConfirmationService, times(1)).confirmFeeding(personId, animalId, feedingTimeId, confirmationCode);
    }
}
