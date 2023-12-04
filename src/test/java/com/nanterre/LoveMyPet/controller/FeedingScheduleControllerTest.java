package com.nanterre.LoveMyPet.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nanterre.LoveMyPet.model.FeedingSchedule;
import com.nanterre.LoveMyPet.service.FeedingScheduleServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

public class FeedingScheduleControllerTest {

    @InjectMocks
    private FeedingScheduleController feedingScheduleController;

    @Mock
    private FeedingScheduleServiceImpl feedingScheduleService;

    private MockMvc mockMvc;

    public FeedingScheduleControllerTest() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(feedingScheduleController).build();
    }

    @Test
    public void testCreateFeedingSchedule() throws Exception {
        FeedingSchedule feedingSchedule = new FeedingSchedule();
        feedingSchedule.setFeedingFrequency(2);

        when(feedingScheduleService.createFeedingSchedule(any(FeedingSchedule.class))).thenReturn(feedingSchedule);

        mockMvc.perform(post("/api/feeding-schedules")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(feedingSchedule)))
                .andExpect(status().isCreated())
                .andExpect(content().string("Feeding schedule created for 2 times a day at the specified hours."));

        verify(feedingScheduleService, times(1)).createFeedingSchedule(any(FeedingSchedule.class));
    }

    @Test
    public void testDisplayUsersWithCurrentFeedingTime() throws Exception {
        List<String> emails = Arrays.asList("user1@example.com", "user2@example.com");

        when(feedingScheduleService.getUsersWithCurrentFeedingTime()).thenReturn(emails);

        mockMvc.perform(get("/api/feeding-schedules/emails-with-current-time"))
                .andExpect(status().isOk())
                .andExpect(content().string("E-mails affichés dans la console."));

        verify(feedingScheduleService, times(1)).getUsersWithCurrentFeedingTime();
    }

    @Test
    void testGetFeedingTimesForAnimal() {
        // Arrange
        Long animalId = 1L;
        List<LocalTime> expectedFeedingTimes = Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 0));

        // Mocking the service method
        when(feedingScheduleService.getFeedingTimesForAnimal(animalId)).thenReturn(expectedFeedingTimes);

        // Act
        ResponseEntity<List<LocalTime>> response = feedingScheduleController.getFeedingTimesForAnimal(animalId);

        // Assert
        assertEquals(200, response.getStatusCodeValue()); // Assuming OK status code
        assertEquals(expectedFeedingTimes, response.getBody());
    }


}
