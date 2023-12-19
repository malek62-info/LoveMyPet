package com.nanterre.LoveMyPet.controller;

import com.nanterre.LoveMyPet.model.FeedingTime;
import com.nanterre.LoveMyPet.service.AnimalServiceImpl;
import com.nanterre.LoveMyPet.service.FeedingTimeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class FeedingTimeControllerTest {

    @Mock
    private FeedingTimeServiceImpl feedingTimeService;

    @InjectMocks
    private FeedingTimeController feedingTimeController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAjouterHoraireAlimentation() {
        // Arrange
        FeedingTime feedingTime = new FeedingTime(); // Provide a sample FeedingTime object
        doNothing().when(feedingTimeService).addFeedingTime(feedingTime);

        // Act
        ResponseEntity<String> response = feedingTimeController.ajouterHoraireAlimentation(feedingTime);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Horaire d'alimentation ajouté avec succès.", response.getBody());
        verify(feedingTimeService, times(1)).addFeedingTime(feedingTime);
    }

    @Test
    void testGetCurrentFeedingTimes() {
        // Arrange
        List<Object[]> expectedFeedingTimes = Arrays.asList(new Object[]{"time1"}, new Object[]{"time2"});
        when(feedingTimeService.getInfosCurrentFeedingTimes()).thenReturn(expectedFeedingTimes);

        // Act
        ResponseEntity<List<Object[]>> response = feedingTimeController.getCurrentFeedingTimes();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedFeedingTimes, response.getBody());
        verify(feedingTimeService, times(1)).getInfosCurrentFeedingTimes();
    }
}
