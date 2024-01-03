package com.nanterre.LoveMyPet.controller;

import com.nanterre.LoveMyPet.model.Evenement;
import com.nanterre.LoveMyPet.model.Inscription;
import com.nanterre.LoveMyPet.model.Person;
import com.nanterre.LoveMyPet.repository.EvenementRepository;
import com.nanterre.LoveMyPet.repository.InscriptionRepository;
import com.nanterre.LoveMyPet.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class InscriptionControllerTest {

    @InjectMocks
    private InscriptionController inscriptionController;

    @Mock
    private InscriptionRepository inscriptionRepository;

    @Mock
    private PersonRepository personRepository;

    @Mock
    private EvenementRepository evenementRepository;

    @Test
    public void testAddInscription() {
        // Création d'une fausse personne et d'un faux événement pour le test
        Person mockPerson = new Person();
        mockPerson.setIdPerson(1);

        Evenement mockEvenement = new Evenement();
        mockEvenement.setIdEvenement(2);

        // Configuration du comportement des repositories pour ne pas lever d'exception
        when(personRepository.findById(1)).thenReturn(java.util.Optional.of(mockPerson));
        when(evenementRepository.findById(2)).thenReturn(java.util.Optional.of(mockEvenement));
        when(inscriptionRepository.existsByPersonneAndEvenement(any(Person.class), any(Evenement.class))).thenReturn(false);

        // Appel de la méthode du contrôleur
        String result = inscriptionController.addInscription(2, 1);

        // Vérification du résultat
        assertEquals("Inscription added successfully!", result);
    }
}
