package com.nanterre.LoveMyPet.model;

import com.nanterre.LoveMyPet.model.Evenement;
import com.nanterre.LoveMyPet.model.Inscription;
import com.nanterre.LoveMyPet.model.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class InscriptionTest {

    @Test
    public void testGettersAndSetters() {
        // Création d'un objet Inscription pour le test
        Inscription inscription = new Inscription();

        // Création d'objets Person et Evenement pour simuler les relations ManyToOne
        Person person = new Person();
        person.setIdPerson(1);

        Evenement evenement = new Evenement();
        evenement.setIdEvenement(2);

        // Utilisation des setters
        inscription.setIdInscription(3);
        inscription.setPersonne(person);
        inscription.setEvenement(evenement);

        // Vérification des getters
        assertEquals(3, inscription.getIdInscription());
        assertEquals(person, inscription.getPersonne());
        assertEquals(evenement, inscription.getEvenement());

        // Vérification des setters
        Inscription newInscription = new Inscription();
        newInscription.setIdInscription(4);
        newInscription.setPersonne(new Person());
        newInscription.setEvenement(new Evenement());

        assertEquals(4, newInscription.getIdInscription());
        assertNotNull(newInscription.getPersonne());
        assertNotNull(newInscription.getEvenement());
    }
}
