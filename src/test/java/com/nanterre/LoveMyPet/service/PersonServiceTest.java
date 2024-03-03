package com.nanterre.LoveMyPet.service;
import com.nanterre.LoveMyPet.model.Person;
import com.nanterre.LoveMyPet.repository.PersonRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class PersonServiceTest {

    @Mock
    private EntityManager entityManager;


    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonServiceImpl personService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetPersonDetailsById() {
        // Créez un utilisateur pour le test
        Person user = new Person();
        user.setIdPerson(1);
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("john.doe@example.com");

        // Définissez le comportement du repository mock
        when(personRepository.findById(1)).thenReturn(Optional.of(user));

        // Exécutez la méthode du service
        Person result = personService.getPersonDetailsById(1);

        // Vérifiez que la méthode du repository a été appelée
        verify(personRepository, times(1)).findById(1);

        // Vérifiez que le résultat est correct
        assertEquals(user, result);
    }

    @Test
    public void testGetPersonDetailsByIdNotFound() {
        // Définissez le comportement du repository mock pour un utilisateur non trouvé
        when(personRepository.findById(1)).thenReturn(Optional.empty());

        // Exécutez la méthode du service
        Person result = personService.getPersonDetailsById(1);

        // Vérifiez que la méthode du repository a été appelée
        verify(personRepository, times(1)).findById(1);

        // Vérifiez que le résultat est null
        assertEquals(null, result);
    }

    @Test
    public void testSavePerson() {
        // Créez un utilisateur pour le test
        Person user = new Person();
        user.setIdPerson(1);
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("john.doe@example.com");

        // Définissez le comportement du repository mock
        when(personRepository.save(user)).thenReturn(user);

        // Exécutez la méthode du service
        Person result = personService.savePerson(user);

        // Vérifiez que la méthode du repository a été appelée
        verify(personRepository, times(1)).save(user);

        // Vérifiez que le résultat est correct
        assertEquals(user, result);
    }




}
