package com.nanterre.LoveMyPet;

import com.nanterre.LoveMyPet.controller.PersonController;
import com.nanterre.LoveMyPet.model.Person;
import com.nanterre.LoveMyPet.model.Candidature;
import com.nanterre.LoveMyPet.service.PersonService;
import com.nanterre.LoveMyPet.service.CandidatureService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpSession;

import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class PersonControllerTest {

    @Mock
    private PersonService personService;

    @Mock
    private CandidatureService candidatureService;

    @InjectMocks
    private PersonController personController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddPerson() {
        Person person = new Person();
        person.setEmail("test@example.com");

        when(personService.findPersonByEmail("test@example.com")).thenReturn(null);
        doNothing().when(personService).savePerson(any(Person.class));

        ResponseEntity<String> responseEntity = personController.add(null, person);

        verify(personService, times(1)).savePerson(any(Person.class));

        assert(responseEntity.getStatusCode() == HttpStatus.OK);
        assert(responseEntity.getBody().equals("Nouvelle personne ajoutée"));
    }

    @Test
    public void testLoginSuccess() {
        Person user = new Person();
        user.setEmail("test@example.com");
        user.setPassword("password123");

        when(personService.findPersonByEmail("test@example.com")).thenReturn(user);

        ResponseEntity<?> responseEntity = personController.login("test@example.com", "password123", null);

        verify(personService, never()).findPersonByEmail("test@example.com");

        assert(responseEntity.getStatusCode() == HttpStatus.OK);
        assert(responseEntity.getBody().equals("Authentification réussie"));
    }

    @Test
    public void testUserProfile() {
        MockHttpSession session = new MockHttpSession();

        Person person = new Person();
        person.setEmail("test@example.com");
        person.setFirstName("John");
        person.setLastName("Doe");

        when(personService.findPersonByEmail("test@example.com")).thenReturn(person);

        ResponseEntity<?> responseEntity = personController.userProfile(session);

        assert(responseEntity.getStatusCode() == HttpStatus.OK);

        assert(responseEntity.getBody() instanceof Map);

        Map<String, Object> userData = (Map<String, Object>) responseEntity.getBody();
        assert(userData.get("id").equals(person.getIdPerson()));
        assert(userData.get("name").equals("John Doe"));
    }

    @Test
    public void testAddCandidature() {
        doNothing().when(candidatureService).saveCandidature(any(Candidature.class));

        ResponseEntity<String> responseEntity = personController.addCandidature(1, 2, "2023-11-24");

        verify(candidatureService, times(1)).saveCandidature(any(Candidature.class));

        assert(responseEntity.getStatusCode() == HttpStatus.OK);
        assert(responseEntity.getBody().equals("Candidature ajoutée avec succès"));
    }

    @Test
    public void testAddCandidatureFailure() {
        doThrow(new RuntimeException("Erreur lors de l'ajout de la candidature")).when(candidatureService).saveCandidature(any(Candidature.class));

        ResponseEntity<String> responseEntity = personController.addCandidature(1, 2, "2023-11-24");

        verify(candidatureService, times(1)).saveCandidature(any(Candidature.class));

        assert(responseEntity.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR);
        assert(responseEntity.getBody().equals("Erreur lors de l'ajout de la candidature"));
    }
}

