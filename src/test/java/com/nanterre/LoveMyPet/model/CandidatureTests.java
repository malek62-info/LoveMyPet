package com.nanterre.LoveMyPet.model;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

public class CandidatureTests {

    @Test
    public void testCandidatureGettersAndSetters() {
        // Création d'une candidature
        Candidature candidature = new Candidature();
        candidature.setIdCandidature(1);
        candidature.setDateCandidature(new Date());
        
        Person person = new Person();
        person.setIdPerson(1);
        candidature.setPerson(person);

        Adoption adoption = new Adoption();
        adoption.setIdAdoption(1);
        candidature.setAdoption(adoption);

        // Vérification des getters
        assertEquals(1, candidature.getIdCandidature());
        assertNotNull(candidature.getDateCandidature());
        assertEquals(person, candidature.getPerson());
        assertEquals(adoption, candidature.getAdoption());

        // Modification des valeurs
        Date newDate = new Date();
        candidature.setDateCandidature(newDate);

        Person newPerson = new Person();
        newPerson.setIdPerson(2);
        candidature.setPerson(newPerson);

        Adoption newAdoption = new Adoption();
        newAdoption.setIdAdoption(2);
        candidature.setAdoption(newAdoption);

        // Vérification des setters
        assertEquals(newDate, candidature.getDateCandidature());
        assertEquals(newPerson, candidature.getPerson());
        assertEquals(newAdoption, candidature.getAdoption());
    }
}
