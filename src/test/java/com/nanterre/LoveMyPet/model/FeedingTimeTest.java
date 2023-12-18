package com.nanterre.LoveMyPet.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.time.LocalTime;

public class FeedingTimeTest {

    @Test
    public void testGetId() {
        FeedingTime feedingTime = new FeedingTime();
        feedingTime.setId(1);
        assertEquals(1, feedingTime.getId());
    }

    @Test
    public void testSetId() {
        FeedingTime feedingTime = new FeedingTime();
        feedingTime.setId(2);
        assertEquals(2, feedingTime.getId());
    }

    @Test
    public void testGetAnimal() {
        FeedingTime feedingTime = new FeedingTime();
        Animal animal = new Animal();
        feedingTime.setAnimal(animal);
        assertEquals(animal, feedingTime.getAnimal());
    }

    @Test
    public void testSetAnimal() {
        FeedingTime feedingTime = new FeedingTime();
        Animal animal = new Animal();
        feedingTime.setAnimal(animal);
        assertEquals(animal, feedingTime.getAnimal());
    }

    @Test
    public void testGetFeedingTime() {
        LocalTime feedingTimeValue = LocalTime.of(12, 30);
        FeedingTime feedingTime = new FeedingTime(feedingTimeValue);
        assertEquals(feedingTimeValue, feedingTime.getFeedingTime());
    }

    @Test
    public void testSetFeedingTime() {
        LocalTime feedingTimeValue = LocalTime.of(18, 0);
        FeedingTime feedingTime = new FeedingTime();
        feedingTime.setFeedingTime(feedingTimeValue);
        assertEquals(feedingTimeValue, feedingTime.getFeedingTime());
    }
}
