package com.nanterre.LoveMyPet.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

public class VaccinationTests {

    @Test
    public void testGetIdVaccination() {
        Vaccination vaccination = new Vaccination();
        vaccination.setIdVaccination(1);
        assertEquals(1, vaccination.getIdVaccination());
    }

    @Test
    public void testSetIdVaccination() {
        Vaccination vaccination = new Vaccination();
        vaccination.setIdVaccination(2);
        assertEquals(2, vaccination.getIdVaccination());
    }

    @Test
    public void testGetVaccin() {
        Vaccination vaccination = new Vaccination();
        Vaccin vaccin = new Vaccin();
        vaccination.setVaccin(vaccin);
        assertEquals(vaccin, vaccination.getVaccin());
    }

    @Test
    public void testSetVaccin() {
        Vaccination vaccination = new Vaccination();
        Vaccin vaccin = new Vaccin();
        vaccination.setVaccin(vaccin);
        assertEquals(vaccin, vaccination.getVaccin());
    }

    @Test
    public void testGetAnimal() {
        Vaccination vaccination = new Vaccination();
        Animal animal = new Animal();
        vaccination.setAnimal(animal);
        assertEquals(animal, vaccination.getAnimal());
    }

    @Test
    public void testSetAnimal() {
        Vaccination vaccination = new Vaccination();
        Animal animal = new Animal();
        vaccination.setAnimal(animal);
        assertEquals(animal, vaccination.getAnimal());
    }

    @Test
    public void testGetDate() {
        Vaccination vaccination = new Vaccination();
        Date date = new Date();
        vaccination.setDate(date);
        assertEquals(date, vaccination.getDate());
    }

    @Test
    public void testSetDate() {
        Vaccination vaccination = new Vaccination();
        Date date = new Date();
        vaccination.setDate(date);
        assertEquals(date, vaccination.getDate());
    }
}
