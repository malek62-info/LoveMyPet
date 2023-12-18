package com.nanterre.LoveMyPet.service;


import org.junit.jupiter.api.Test;

import com.nanterre.LoveMyPet.model.FeedingConfirmation;
import com.nanterre.LoveMyPet.repository.FeedingConfirmationRepository;
import com.nanterre.LoveMyPet.repository.FeedingTimeRepository;
import com.nanterre.LoveMyPet.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FeedingConfirmationServiceImplTest {

    @Mock
    private PersonRepository personRepository;

    @Mock
    private FeedingTimeRepository feedingTimeRepository;

    @Mock
    private FeedingConfirmationRepository feedingConfirmationRepository;

    @InjectMocks
    private HistoriqueAdoptionService.FeedingConfirmationServiceImpl feedingConfirmationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void confirmFeeding_SuccessfulConfirmation() {
        // Mocking the repository responses
        when(feedingConfirmationRepository.existsByPersonIdAndAnimalIdAndFeedingTimeId(anyInt(), anyInt(), anyInt(), anyString()))
                .thenReturn(false);

        // Testing the service method
        boolean result = feedingConfirmationService.confirmFeeding(1, 2, 3, "confirmationCode");

        // Verifying interactions
        verify(feedingConfirmationRepository, times(1)).existsByPersonIdAndAnimalIdAndFeedingTimeId(1, 2, 3, "confirmationCode");
        verify(feedingConfirmationRepository, times(1)).save(any(FeedingConfirmation.class));

        // Assertion
        assertTrue(result);
    }

    @Test
    void confirmFeeding_FailedConfirmation_Duplicate() {
        // Mocking the repository responses
        when(feedingConfirmationRepository.existsByPersonIdAndAnimalIdAndFeedingTimeId(anyInt(), anyInt(), anyInt(), anyString()))
                .thenReturn(true);

        // Testing the service method
        boolean result = feedingConfirmationService.confirmFeeding(1, 2, 3, "confirmationCode");

        // Verifying interactions
        verify(feedingConfirmationRepository, times(1)).existsByPersonIdAndAnimalIdAndFeedingTimeId(1, 2, 3, "confirmationCode");
        verify(feedingConfirmationRepository, never()).save(any(FeedingConfirmation.class));

        // Assertion
        assertFalse(result);
    }
}

