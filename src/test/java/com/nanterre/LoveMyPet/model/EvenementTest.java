package com.nanterre.LoveMyPet.model;

import com.nanterre.LoveMyPet.model.Evenement;
import com.nanterre.LoveMyPet.model.Person;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class EvenementTest {

    @Test
    public void testGettersAndSetters() {
        // Création d'un objet Evenement pour le test
        Evenement evenement = new Evenement();

        // Définition des valeurs
        Integer idEvenement = 1;
        String titre = "Test Event";
        LocalDate date = LocalDate.now();
        String imageUrl = "test.jpg";
        String place = "Test Location";
        Person createur = new Person();

        // Utilisation des setters
        evenement.setIdEvenement(idEvenement);
        evenement.setTitre(titre);
        evenement.setDate(date);
        evenement.setImageUrl(imageUrl);
        evenement.setPlace(place);
        evenement.setCreateur(createur);

        // Vérification des getters
        assertEquals(idEvenement, evenement.getIdEvenement());
        assertEquals(titre, evenement.getTitre());
        assertEquals(date, evenement.getDate());
        assertEquals(imageUrl, evenement.getImageUrl());
        assertEquals(place, evenement.getPlace());
        assertEquals(createur, evenement.getCreateur());

        // Vérification des setters
        Evenement newEvenement = new Evenement();
        newEvenement.setIdEvenement(2);
        newEvenement.setTitre("New Test Event");
        newEvenement.setDate(LocalDate.of(2022, 1, 1));
        newEvenement.setImageUrl("new_test.jpg");
        newEvenement.setPlace("New Test Location");
        newEvenement.setCreateur(new Person());

        assertEquals(2, newEvenement.getIdEvenement());
        assertEquals("New Test Event", newEvenement.getTitre());
        assertEquals(LocalDate.of(2022, 1, 1), newEvenement.getDate());
        assertEquals("new_test.jpg", newEvenement.getImageUrl());
        assertEquals("New Test Location", newEvenement.getPlace());
        assertNotNull(newEvenement.getCreateur());
    }
}
