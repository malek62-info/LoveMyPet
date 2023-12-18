package com.nanterre.LoveMyPet.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LikeDislikeTest {

    @Test
    public void testGetId() {
        LikeDislike likeDislike = new LikeDislike();
        likeDislike.setId(1);
        assertEquals(1, likeDislike.getId());
    }

    @Test
    public void testSetId() {
        LikeDislike likeDislike = new LikeDislike();
        likeDislike.setId(2);
        assertEquals(2, likeDislike.getId());
    }

    @Test
    public void testGetAdvice() {
        LikeDislike likeDislike = new LikeDislike();
        Advice advice = new Advice();
        likeDislike.setAdvice(advice);
        assertEquals(advice, likeDislike.getAdvice());
    }

    @Test
    public void testSetAdvice() {
        LikeDislike likeDislike = new LikeDislike();
        Advice advice = new Advice();
        likeDislike.setAdvice(advice);
        assertEquals(advice, likeDislike.getAdvice());
    }

    @Test
    public void testGetPerson() {
        LikeDislike likeDislike = new LikeDislike();
        Person person = new Person();
        likeDislike.setPerson(person);
        assertEquals(person, likeDislike.getPerson());
    }

    @Test
    public void testSetPerson() {
        LikeDislike likeDislike = new LikeDislike();
        Person person = new Person();
        likeDislike.setPerson(person);
        assertEquals(person, likeDislike.getPerson());
    }

    @Test
    public void testIsLike() {
        LikeDislike likeDislike = new LikeDislike();
        likeDislike.setLike(true);
        assertTrue(likeDislike.isLike());
    }

    @Test
    public void testSetLike() {
        LikeDislike likeDislike = new LikeDislike();
        likeDislike.setLike(true);
        assertTrue(likeDislike.isLike());
    }
}
