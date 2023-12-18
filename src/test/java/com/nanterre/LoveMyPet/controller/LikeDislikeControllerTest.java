package com.nanterre.LoveMyPet.controller;

import com.nanterre.LoveMyPet.model.Person;
import com.nanterre.LoveMyPet.repository.PersonRepository;
import com.nanterre.LoveMyPet.service.CandidatureService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class LikeDislikeControllerTest {

    @Mock
    private CandidatureService.LikeDislikeServiceImpl likeDislikeService;

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private LikeDislikeController likeDislikeController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addLike() {
        // Mocking input data
        Map<String, Object> requestData = new HashMap<>();
        requestData.put("advice_id", 1);
        requestData.put("person_id", 2);

        // Mocking Person
        Person mockPerson = new Person();
        mockPerson.setIdPerson(2);

        // Mocking PersonRepository
        when(personRepository.findById(2)).thenReturn(Optional.of(mockPerson));

        // Testing addLike method
        ResponseEntity<String> response = likeDislikeController.addLike(requestData);

        // Verifying interactions
        verify(personRepository, times(1)).findById(2);
        verify(likeDislikeService, times(1)).addLike(1, 2, true);

        // Assertions
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Like added successfully", response.getBody());
    }

    @Test
    void addDislike() {
        // Mocking input data
        Map<String, Object> requestData = new HashMap<>();
        requestData.put("advice_id", 1);
        requestData.put("person_id", 2);

        // Mocking Person
        Person mockPerson = new Person();
        mockPerson.setIdPerson(2);

        // Mocking PersonRepository
        when(personRepository.findById(2)).thenReturn(Optional.of(mockPerson));

        // Testing addDislike method
        ResponseEntity<String> response = likeDislikeController.addDislike(requestData);

        // Verifying interactions
        verify(personRepository, times(1)).findById(2);
        verify(likeDislikeService, times(1)).addDislike(1, 2, false);

        // Assertions
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Dislike added successfully", response.getBody());
    }
}
