package com.nanterre.LoveMyPet.controller;

import com.nanterre.LoveMyPet.model.Person;
import com.nanterre.LoveMyPet.model.Candidature;
import com.nanterre.LoveMyPet.service.PersonService;
import com.nanterre.LoveMyPet.service.CandidatureService;
import com.nanterre.LoveMyPet.service.PersonServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class PersonControllerTest {

    @Mock
    private PersonServiceImpl personService;

    @Mock
    private CandidatureService candidatureService;

    @InjectMocks
    private PersonController personController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    private HttpSession session;


    @Test
    public void testAddPerson() {
        // Créez une personne pour le test
        Person person = new Person();
        person.setEmail("test@example.com");

        // Définissez le comportement du service mock
        when(personService.findPersonByEmail("test@example.com")).thenReturn(null);
        when(personService.savePerson(any(Person.class))).thenReturn(null);

        // Exécutez la méthode du contrôleur
        ResponseEntity<String> responseEntity = personController.add(null, person);

        // Vérifiez que les méthodes du service ont été appelées
        verify(personService, times(1)).findPersonByEmail("test@example.com");
        verify(personService, times(1)).savePerson(any(Person.class));

        // Vérifiez que la réponse est correcte
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Nouvelle personne ajoutée", responseEntity.getBody());
    }

    @Test
    public void testUserProfileUnauthorized() {
        // Définissez le comportement du service mock pour un utilisateur non connecté
        when(session.getAttribute("userId")).thenReturn(null);
        when(session.getAttribute("email")).thenReturn(null);

        // Exécutez la méthode du contrôleur
        ResponseEntity<?> responseEntity = personController.userProfile(session);

        // Vérifiez que la méthode du service n'a pas été appelée
        verify(personService, never()).findPersonByEmail(anyString());

        // Vérifiez que la réponse est correcte
        assertEquals(HttpStatus.UNAUTHORIZED, responseEntity.getStatusCode());
        assertEquals("Utilisateur non connecté", responseEntity.getBody());
    }

    @Test
    public void testUserProfileNotFound() {
        // Définissez le comportement du service mock pour un utilisateur introuvable
        when(session.getAttribute("userId")).thenReturn(1);
        when(session.getAttribute("email")).thenReturn("john.doe@example.com");
        when(personService.findPersonByEmail("john.doe@example.com")).thenReturn(null);

        // Exécutez la méthode du contrôleur
        ResponseEntity<?> responseEntity = personController.userProfile(session);

        // Vérifiez que la méthode du service a été appelée
        verify(personService, times(1)).findPersonByEmail("john.doe@example.com");

        // Vérifiez que la réponse est correcte
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertEquals("Utilisateur non trouvé", responseEntity.getBody());
    }

    @Test
    public void testUserProfileSuccess() {
        // Créez un utilisateur pour le test
        Person user = new Person();
        user.setIdPerson(1);
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("john.doe@example.com");

        // Définissez le comportement du service mock
        when(session.getAttribute("userId")).thenReturn(1);
        when(session.getAttribute("email")).thenReturn("john.doe@example.com");
        when(personService.findPersonByEmail("john.doe@example.com")).thenReturn(user);

        // Exécutez la méthode du contrôleur
        ResponseEntity<?> responseEntity = personController.userProfile(session);

        // Vérifiez que la méthode du service a été appelée
        verify(personService, times(1)).findPersonByEmail("john.doe@example.com");

        // Vérifiez que la réponse est correcte
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        // Vérifiez les données renvoyées
        Map<String, Object> expectedUserData = new HashMap<>();
        expectedUserData.put("id", 1);
        expectedUserData.put("name", "John Doe");
        assertEquals(expectedUserData, responseEntity.getBody());
    }

    @Test
    public void testLoginFailure() {
        // Définissez le comportement du service mock pour un échec d'authentification
        when(personService.findPersonByEmail(any())).thenReturn(null);

        // Exécutez la méthode du contrôleur avec des informations d'authentification incorrectes
        ResponseEntity<?> responseEntity = personController.login("test@example.com", "password123", session);

        // Vérifiez que la méthode du service a été appelée
        verify(personService, times(1)).findPersonByEmail("test@example.com");

        // Vérifiez que la session n'a pas été mise à jour en cas d'échec d'authentification
        verify(session, never()).setAttribute(any(), any());

        // Vérifiez que la réponse est correcte
        assertEquals(HttpStatus.UNAUTHORIZED, responseEntity.getStatusCode());
        assertEquals("Authentification échouée", responseEntity.getBody());
    }

    @Test
    public void testLoginSuccess() {
        // Créez un utilisateur pour le test
        Person user = new Person();
        user.setIdPerson(1);
        user.setEmail("test@example.com");
        user.setPassword("password123");

        // Définissez le comportement du service mock
        when(personService.findPersonByEmail("test@example.com")).thenReturn(user);

        // Exécutez la méthode du contrôleur
        ResponseEntity<?> responseEntity = personController.login("test@example.com", "password123", session);

        // Vérifiez que la méthode du service a été appelée
        verify(personService, times(1)).findPersonByEmail("test@example.com");

        // Vérifiez que la session a été correctement mise à jour
        verify(session, times(1)).setAttribute("userId", 1);
        verify(session, times(1)).setAttribute("email", "test@example.com");

        // Vérifiez que la réponse est correcte
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Authentification réussie", responseEntity.getBody());
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
