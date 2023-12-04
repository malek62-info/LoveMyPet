package com.nanterre.LoveMyPet.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class FeedingScheduleTests {

    @Test
    public void testGetId() {
        FeedingSchedule feedingSchedule = new FeedingSchedule();
        feedingSchedule.setId(1L);
        assertEquals(1L, feedingSchedule.getId());
    }

    @Test
    public void testSetId() {
        FeedingSchedule feedingSchedule = new FeedingSchedule();
        feedingSchedule.setId(2L);
        assertEquals(2L, feedingSchedule.getId());
    }

    @Test
    public void testGetAnimal() {
        Animal animal = new Animal();
        FeedingSchedule feedingSchedule = new FeedingSchedule();
        feedingSchedule.setAnimal(animal);
        assertEquals(animal, feedingSchedule.getAnimal());
    }

    @Test
    public void testSetAnimal() {
        Animal animal = new Animal();
        FeedingSchedule feedingSchedule = new FeedingSchedule();
        feedingSchedule.setAnimal(animal);
        assertEquals(animal, feedingSchedule.getAnimal());
    }

    @Test
    public void testGetFeedingFrequency() {
        FeedingSchedule feedingSchedule = new FeedingSchedule();
        feedingSchedule.setFeedingFrequency(3);
        assertEquals(3, feedingSchedule.getFeedingFrequency());
    }

    @Test
    public void testSetFeedingFrequency() {
        FeedingSchedule feedingSchedule = new FeedingSchedule();
        feedingSchedule.setFeedingFrequency(2);
        assertEquals(2, feedingSchedule.getFeedingFrequency());
    }

    @Test
    public void testGetFeedingTimes() {
        FeedingTime feedingTime1 = new FeedingTime();
        FeedingTime feedingTime2 = new FeedingTime();
        List<FeedingTime> feedingTimes = Arrays.asList(feedingTime1, feedingTime2);

        FeedingSchedule feedingSchedule = new FeedingSchedule();
        feedingSchedule.setFeedingTimes(feedingTimes);

        assertEquals(feedingTimes, feedingSchedule.getFeedingTimes());
    }

    @Test
    public void testSetFeedingTimes() {
        FeedingTime feedingTime1 = new FeedingTime();
        FeedingTime feedingTime2 = new FeedingTime();
        List<FeedingTime> feedingTimes = Arrays.asList(feedingTime1, feedingTime2);

        FeedingSchedule feedingSchedule = new FeedingSchedule();
        feedingSchedule.setFeedingTimes(feedingTimes);

        assertEquals(feedingTimes, feedingSchedule.getFeedingTimes());
    }

   /* @Test
    public void testHashCode() {
        FeedingSchedule feedingSchedule1 = new FeedingSchedule();
        feedingSchedule1.setId(1L);
        feedingSchedule1.setFeedingFrequency(3);

        FeedingSchedule feedingSchedule2 = new FeedingSchedule();
        feedingSchedule2.setId(1L);
        feedingSchedule2.setFeedingFrequency(3);

        assertEquals(feedingSchedule1.hashCode(), feedingSchedule2.hashCode());
    }*/
}
