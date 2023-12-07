package com.nanterre.LoveMyPet.model;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;


public class FeedingTimeTests {

    @Test
    public void testCreateFeedingTime() {
        // Créer une instance de FeedingTime
        FeedingTime feedingTime = new FeedingTime();
        assertNotNull(feedingTime);
    }

    @Test
    public void testSetAndGetFeedingTime() {
        // Créer une instance de FeedingTime
        FeedingTime feedingTime = new FeedingTime();

        // Définir l'heure d'alimentation
        LocalTime time = LocalTime.of(12, 30);
        feedingTime.setFeedingTime(time);

        // Vérifier si l'heure d'alimentation est correcte
        assertEquals(time, feedingTime.getFeedingTime());
    }

    @Test
    public void testFeedingTimeConstructorWithString() {
        // Créer une instance de FeedingTime en utilisant le constructeur avec une chaîne
        FeedingTime feedingTime = new FeedingTime("12:30");

        // Vérifier si l'heure d'alimentation est correcte
        assertEquals(LocalTime.of(12, 30), feedingTime.getFeedingTime());
    }

    @Test
    public void testSetId() {
        // Créer une instance de FeedingTime
        FeedingTime feedingTime = new FeedingTime();

        // Définir l'ID
        feedingTime.setId(1L);

        // Vérifier si l'ID est correct
        assertEquals(1L, feedingTime.getId());
    }

    @Test
    public void testSetFeedingSchedule() {
        // Créer une instance de FeedingTime
        FeedingTime feedingTime = new FeedingTime();

        // Définir un objet FeedingSchedule
        FeedingSchedule feedingSchedule = new FeedingSchedule();
        feedingTime.setFeedingSchedule(feedingSchedule);

        // Vérifier si FeedingSchedule est correctement défini
        assertEquals(feedingSchedule, feedingTime.getFeedingSchedule());
    }

    @Test
    public void testGetId() {
        // Créer une instance de FeedingTime
        FeedingTime feedingTime = new FeedingTime();

        // Définir l'ID
        feedingTime.setId(2L);

        // Vérifier si la méthode getId retourne l'ID correct
        assertEquals(2L, feedingTime.getId());
    }

    @Test
    public void testGetFeedingSchedule() {
        // Créer une instance de FeedingTime
        FeedingTime feedingTime = new FeedingTime();

        // Définir un objet FeedingSchedule
        FeedingSchedule feedingSchedule = new FeedingSchedule();
        feedingTime.setFeedingSchedule(feedingSchedule);

        // Vérifier si la méthode getFeedingSchedule retourne le FeedingSchedule correct
        assertEquals(feedingSchedule, feedingTime.getFeedingSchedule());
    }
}
