package com.nanterre.LoveMyPet.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

public class FeedingConfirmationTest {

    @Test
    public void testGetId() {
        FeedingConfirmation feedingConfirmation = new FeedingConfirmation();
        feedingConfirmation.setId(1);
        assertEquals(1, feedingConfirmation.getId());
    }

    @Test
    public void testSetId() {
        FeedingConfirmation feedingConfirmation = new FeedingConfirmation();
        feedingConfirmation.setId(2);
        assertEquals(2, feedingConfirmation.getId());
    }

    @Test
    public void testGetPersonId() {
        FeedingConfirmation feedingConfirmation = new FeedingConfirmation();
        feedingConfirmation.setPersonId(101);
        assertEquals(101, feedingConfirmation.getPersonId());
    }

    @Test
    public void testSetPersonId() {
        FeedingConfirmation feedingConfirmation = new FeedingConfirmation();
        feedingConfirmation.setPersonId(102);
        assertEquals(102, feedingConfirmation.getPersonId());
    }

    @Test
    public void testGetAnimalId() {
        FeedingConfirmation feedingConfirmation = new FeedingConfirmation();
        feedingConfirmation.setAnimalId(201);
        assertEquals(201, feedingConfirmation.getAnimalId());
    }

    @Test
    public void testSetAnimalId() {
        FeedingConfirmation feedingConfirmation = new FeedingConfirmation();
        feedingConfirmation.setAnimalId(202);
        assertEquals(202, feedingConfirmation.getAnimalId());
    }

    @Test
    public void testGetFeedingTimeId() {
        FeedingConfirmation feedingConfirmation = new FeedingConfirmation();
        feedingConfirmation.setFeedingTimeId(301);
        assertEquals(301, feedingConfirmation.getFeedingTimeId());
    }

    @Test
    public void testSetFeedingTimeId() {
        FeedingConfirmation feedingConfirmation = new FeedingConfirmation();
        feedingConfirmation.setFeedingTimeId(302);
        assertEquals(302, feedingConfirmation.getFeedingTimeId());
    }

    @Test
    public void testGetConfirmationDate() {
        FeedingConfirmation feedingConfirmation = new FeedingConfirmation();
        Date date = new Date();
        feedingConfirmation.setConfirmationDate(date);
        assertEquals(date, feedingConfirmation.getConfirmationDate());
    }

    @Test
    public void testSetConfirmationDate() {
        FeedingConfirmation feedingConfirmation = new FeedingConfirmation();
        Date date = new Date();
        feedingConfirmation.setConfirmationDate(date);
        assertEquals(date, feedingConfirmation.getConfirmationDate());
    }

    @Test
    public void testGetConfirmationCode() {
        FeedingConfirmation feedingConfirmation = new FeedingConfirmation();
        feedingConfirmation.setConfirmationCode("ABC123");
        assertEquals("ABC123", feedingConfirmation.getConfirmationCode());
    }

    @Test
    public void testSetConfirmationCode() {
        FeedingConfirmation feedingConfirmation = new FeedingConfirmation();
        feedingConfirmation.setConfirmationCode("XYZ789");
        assertEquals("XYZ789", feedingConfirmation.getConfirmationCode());
    }
}
