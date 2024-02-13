package com.nanterre.LoveMyPet.controller;

import com.nanterre.LoveMyPet.model.Candidature;
import com.nanterre.LoveMyPet.model.Person;
import com.nanterre.LoveMyPet.service.CandidatureService;
import com.nanterre.LoveMyPet.service.PersonServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
@RunWith(MockitoJUnitRunner.class)

class PersonControllerTest {

    @Mock
    private PersonServiceImpl personService;

    @Mock
    private MultipartFile imageFile;

    @InjectMocks
    private PersonController personController;



    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetPersonDetailsById() {
        // Mock data
        int userId = 1;
        Person mockPerson = new Person();
        mockPerson.setIdPerson(userId);
        when(personService.getPersonDetailsById(userId)).thenReturn(mockPerson);

        // Perform the test
        Person result = personController.getPersonDetailsById(userId);

        // Verify the result
        assertEquals(mockPerson, result);
        verify(personService, times(1)).getPersonDetailsById(userId);
    }


    @Test
    void testLogin() {
        // Mock data
        String email = "test@example.com";
        String password = "password";
        HttpSession mockSession = new MockHttpSession();

        Person mockPerson = new Person();
        mockPerson.setEmail(email);
        mockPerson.setPassword(password);

        // Mock service method
        when(personService.findPersonByEmail(email)).thenReturn(mockPerson);

        // Perform the test
        ResponseEntity<?> result = personController.login(email, password, mockSession);

        // Verify the result
        assertEquals(ResponseEntity.ok("Authentification réussie"), result);
        assertEquals(mockPerson.getIdPerson(), mockSession.getAttribute("userId"));
        assertEquals(email, mockSession.getAttribute("email"));
        verify(personService, times(1)).findPersonByEmail(email);
    }

    @Test
    void testUserProfile() {
        // Mock data
        HttpSession mockSession = new MockHttpSession();
        mockSession.setAttribute("userId", 1);
        mockSession.setAttribute("email", "test@example.com");

        Person mockPerson = new Person();
        mockPerson.setIdPerson(1);
        mockPerson.setFirstName("John");
        mockPerson.setLastName("Doe");

        // Mock service method
        when(personService.findPersonByEmail(anyString())).thenReturn(mockPerson);

        // Perform the test
        ResponseEntity<?> result = personController.userProfile(mockSession);

        // Verify the result
        assertEquals(ResponseEntity.ok(Map.of("id", 1, "name", "John Doe")), result);
        verify(personService, times(1)).findPersonByEmail(anyString());
    }


}
