package com.nanterre.LoveMyPet.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

public class AnimalTests {

    @Test
    public void testGetId() {
        Animal animal = new Animal();
        animal.setId(1);
        assertEquals(1, animal.getId());
    }

    @Test
    public void testSetId() {
        Animal animal = new Animal();
        animal.setId(2);
        assertEquals(2, animal.getId());
    }

    @Test
    public void testGetIdPerson() {
        Animal animal = new Animal();
        animal.setIdPerson(3);
        assertEquals(3, animal.getIdPerson());
    }

    @Test
    public void testSetIdPerson() {
        Animal animal = new Animal();
        animal.setIdPerson(4);
        assertEquals(4, animal.getIdPerson());
    }

    @Test
    public void testGetName() {
        Animal animal = new Animal();
        animal.setName("Buddy");
        assertEquals("Buddy", animal.getName());
    }

    @Test
    public void testSetName() {
        Animal animal = new Animal();
        animal.setName("Max");
        assertEquals("Max", animal.getName());
    }

    @Test
    public void testGetCategory() {
        Animal animal = new Animal();
        animal.setCategory("Dog");
        assertEquals("Dog", animal.getCategory());
    }

    @Test
    public void testSetCategory() {
        Animal animal = new Animal();
        animal.setCategory("Cat");
        assertEquals("Cat", animal.getCategory());
    }

    @Test
    public void testGetRace() {
        Animal animal = new Animal();
        animal.setRace("Labrador");
        assertEquals("Labrador", animal.getRace());
    }

    @Test
    public void testSetRace() {
        Animal animal = new Animal();
        animal.setRace("Siamese");
        assertEquals("Siamese", animal.getRace());
    }

    @Test
    public void testGetWeight() {
        Animal animal = new Animal();
        animal.setWeight(15.5);
        assertEquals(15.5, animal.getWeight());
    }

    @Test
    public void testSetWeight() {
        Animal animal = new Animal();
        animal.setWeight(20.2);
        assertEquals(20.2, animal.getWeight());
    }

    @Test
    public void testGetImageUrl() {
        Animal animal = new Animal();
        animal.setImageUrl("image.jpg");
        assertEquals("image.jpg", animal.getImageUrl());
    }

    @Test
    public void testSetImageUrl() {
        Animal animal = new Animal();
        animal.setImageUrl("photo.png");
        assertEquals("photo.png", animal.getImageUrl());
    }

    @Test
    public void testGetAdopted() {
        Animal animal = new Animal();
        animal.setAdopted(true);
        assertTrue(animal.getAdopted());
    }

    @Test
    public void testSetAdopted() {
        Animal animal = new Animal();
        animal.setAdopted(false);
        assertFalse(animal.getAdopted());
    }

    @Test
    public void testGetGender() {
        Animal animal = new Animal();
        animal.setGender(1);
        assertEquals(1, animal.getGender());
    }

    @Test
    public void testSetGender() {
        Animal animal = new Animal();
        animal.setGender(2);
        assertEquals(2, animal.getGender());
    }

    @Test
    public void testGetDateOfBirth() {
        Animal animal = new Animal();
        animal.setDateOfBirth(new Date());
        assertNotNull(animal.getDateOfBirth());
    }

    @Test
    public void testSetDateOfBirth() {
        Animal animal = new Animal();
        animal.setDateOfBirth(new Date());
        assertNotNull(animal.getDateOfBirth());
    }

    @Test
    public void testGetAdoptedByPerson() {
        Person person = new Person();
        Animal animal = new Animal();
        animal.setAdoptedByPerson(person);
        assertEquals(person, animal.getAdoptedByPerson());
    }

    @Test
    public void testSetAdoptedByPerson() {
        Person person = new Person();
        Animal animal = new Animal();
        animal.setAdoptedByPerson(person);
        assertEquals(person, animal.getAdoptedByPerson());
    }
}
