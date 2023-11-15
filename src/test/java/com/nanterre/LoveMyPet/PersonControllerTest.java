package com.nanterre.LoveMyPet;

import com.nanterre.LoveMyPet.controller.PersonController;
import com.nanterre.LoveMyPet.model.Person;
import com.nanterre.LoveMyPet.service.PersonService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockMultipartFile;

import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class PersonControllerTest {

    @Mock
    private PersonService personService;

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

        MockMultipartFile imageFile = new MockMultipartFile("imageFile", "test-image.jpg", "image/jpeg", "test image content".getBytes());

        when(personService.findPersonByEmail("test@example.com")).thenReturn(null);
        doNothing().when(personService).savePerson(any(Person.class));

        ResponseEntity<String> responseEntity = personController.add(imageFile, person);

        verify(personService, times(1)).savePerson(any(Person.class));

        assert(responseEntity.getStatusCode() == HttpStatus.OK);
        assert(responseEntity.getBody().equals("Nouvelle personne ajoutée"));
    }

    @Test
    public void testLogin() {
        MockHttpSession session = new MockHttpSession();

        Person person = new Person();
        person.setEmail("test@example.com");
        person.setPassword("password123");

        when(personService.findPersonByEmail("test@example.com")).thenReturn(person);

        ResponseEntity<?> responseEntity = personController.login("test@example.com", "password123", session);

        verify(session, times(1)).setAttribute("userId", person.getIdPerson());
        verify(session, times(1)).setAttribute("email", "test@example.com");

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
}
