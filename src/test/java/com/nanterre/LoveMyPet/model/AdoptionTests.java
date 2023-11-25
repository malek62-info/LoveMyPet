package com.nanterre.LoveMyPet.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

public class AdoptionTests {

    @Test
    public void testGetIdAdoption() {
        Adoption adoption = new Adoption();
        adoption.setIdAdoption(1);
        assertEquals(1, adoption.getIdAdoption());
    }

    @Test
    public void testSetIdAdoption() {
        Adoption adoption = new Adoption();
        adoption.setIdAdoption(2);
        assertEquals(2, adoption.getIdAdoption());
    }

    @Test
    public void testGetStartDate() {
        Adoption adoption = new Adoption();
        adoption.setStartDate(new Date());
        assertNotNull(adoption.getStartDate());
    }

    @Test
    public void testSetStartDate() {
        Adoption adoption = new Adoption();
        adoption.setStartDate(new Date());
        assertNotNull(adoption.getStartDate());
    }

    @Test
    public void testGetEndDate() {
        Adoption adoption = new Adoption();
        adoption.setEndDate(new Date());
        assertNotNull(adoption.getEndDate());
    }

    @Test
    public void testSetEndDate() {
        Adoption adoption = new Adoption();
        adoption.setEndDate(new Date());
        assertNotNull(adoption.getEndDate());
    }

    @Test
    public void testGetIdAnimal() {
        Adoption adoption = new Adoption();
        adoption.setIdAnimal(3);
        assertEquals(3, adoption.getIdAnimal());
    }

    @Test
    public void testSetIdAnimal() {
        Adoption adoption = new Adoption();
        adoption.setIdAnimal(4);
        assertEquals(4, adoption.getIdAnimal());
    }

    @Test
    public void testGetAdoptedAnimal() {
        Animal animal = new Animal();
        Adoption adoption = new Adoption();
        adoption.setAdoptedAnimal(animal);
        assertEquals(animal, adoption.getAdoptedAnimal());
    }

    @Test
    public void testSetAdoptedAnimal() {
        Animal animal = new Animal();
        Adoption adoption = new Adoption();
        adoption.setAdoptedAnimal(animal);
        assertEquals(animal, adoption.getAdoptedAnimal());
    }
}
