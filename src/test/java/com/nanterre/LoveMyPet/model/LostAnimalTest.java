package com.nanterre.LoveMyPet.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

public class LostAnimalTest {

    @Test
    public void testGetId() {
        LostAnimal lostAnimal = new LostAnimal();
        lostAnimal.setId(1);
        assertEquals(1, lostAnimal.getId());
    }

    @Test
    public void testSetId() {
        LostAnimal lostAnimal = new LostAnimal();
        lostAnimal.setId(2);
        assertEquals(2, lostAnimal.getId());
    }

    @Test
    public void testGetCategory() {
        LostAnimal lostAnimal = new LostAnimal();
        lostAnimal.setCategory("Dog");
        assertEquals("Dog", lostAnimal.getCategory());
    }

    @Test
    public void testSetCategory() {
        LostAnimal lostAnimal = new LostAnimal();
        lostAnimal.setCategory("Cat");
        assertEquals("Cat", lostAnimal.getCategory());
    }

    @Test
    public void testGetPerson() {
        Person person = new Person();
        LostAnimal lostAnimal = new LostAnimal();
        lostAnimal.setPerson(person);
        assertEquals(person, lostAnimal.getPerson());
    }

    @Test
    public void testSetPerson() {
        Person person = new Person();
        LostAnimal lostAnimal = new LostAnimal();
        lostAnimal.setPerson(person);
        assertEquals(person, lostAnimal.getPerson());
    }

    @Test
    public void testGetName() {
        LostAnimal lostAnimal = new LostAnimal();
        lostAnimal.setName("Buddy");
        assertEquals("Buddy", lostAnimal.getName());
    }

    @Test
    public void testSetName() {
        LostAnimal lostAnimal = new LostAnimal();
        lostAnimal.setName("Max");
        assertEquals("Max", lostAnimal.getName());
    }

    @Test
    public void testGetAge() {
        LostAnimal lostAnimal = new LostAnimal();
        lostAnimal.setAge(3);
        assertEquals(3, lostAnimal.getAge());
    }

    @Test
    public void testSetAge() {
        LostAnimal lostAnimal = new LostAnimal();
        lostAnimal.setAge(4);
        assertEquals(4, lostAnimal.getAge());
    }

    // Ajoute d'autres tests en fonction des propriétés de LostAnimal

}
