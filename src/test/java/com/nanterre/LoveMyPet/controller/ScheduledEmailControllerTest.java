package com.nanterre.LoveMyPet.controller;

import com.nanterre.LoveMyPet.service.ScheduledEmailService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ScheduledEmailControllerTest {

    @Mock
    private ScheduledEmailService scheduledEmailService;

    @InjectMocks
    private ScheduledEmailController scheduledEmailController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSendEmailNow() {
        // Arrange

        // Act
        String result = scheduledEmailController.sendEmailNow();

        // Assert
        assertEquals("Email sending triggered!", result);
        verify(scheduledEmailService, times(1)).sendEmailToUsersWithCurrentFeedingTime();
    }
}
