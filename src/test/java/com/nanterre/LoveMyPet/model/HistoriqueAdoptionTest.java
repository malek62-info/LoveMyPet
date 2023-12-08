package com.nanterre.LoveMyPet.model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import java.util.Date;

public class HistoriqueAdoptionTest {

    @Test
    public void testGetId() {
        HistoriqueAdoption historiqueAdoption = new HistoriqueAdoption();
        historiqueAdoption.setId(1);
        assertEquals(1, historiqueAdoption.getId());
    }

    @Test
    public void testSetId() {
        HistoriqueAdoption historiqueAdoption = new HistoriqueAdoption();
        historiqueAdoption.setId(2);
        assertEquals(2, historiqueAdoption.getId());
    }

    @Test
    public void testGetIdAnimal() {
        HistoriqueAdoption historiqueAdoption = new HistoriqueAdoption();
        historiqueAdoption.setIdAnimal(3);
        assertEquals(3, historiqueAdoption.getIdAnimal());
    }

    @Test
    public void testSetIdAnimal() {
        HistoriqueAdoption historiqueAdoption = new HistoriqueAdoption();
        historiqueAdoption.setIdAnimal(4);
        assertEquals(4, historiqueAdoption.getIdAnimal());
    }

    @Test
    public void testGetIdPerson() {
        HistoriqueAdoption historiqueAdoption = new HistoriqueAdoption();
        historiqueAdoption.setIdPerson(5);
        assertEquals(5, historiqueAdoption.getIdPerson());
    }

    @Test
    public void testSetIdPerson() {
        HistoriqueAdoption historiqueAdoption = new HistoriqueAdoption();
        historiqueAdoption.setIdPerson(6);
        assertEquals(6, historiqueAdoption.getIdPerson());
    }

    @Test
    public void testGetEndDate() {
        HistoriqueAdoption historiqueAdoption = new HistoriqueAdoption();
        Date endDate = new Date();
        historiqueAdoption.setEndDate(endDate);
        assertEquals(endDate, historiqueAdoption.getEndDate());
    }

    @Test
    public void testSetEndDate() {
        HistoriqueAdoption historiqueAdoption = new HistoriqueAdoption();
        Date endDate = new Date();
        historiqueAdoption.setEndDate(endDate);
        assertEquals(endDate, historiqueAdoption.getEndDate());
    }

    @Test
    public void testGetAdoptedAnimal() {
        HistoriqueAdoption historiqueAdoption = new HistoriqueAdoption();
        Animal adoptedAnimal = mock(Animal.class);
        historiqueAdoption.setAdoptedAnimal(adoptedAnimal);
        assertEquals(adoptedAnimal, historiqueAdoption.getAdoptedAnimal());
    }

    @Test
    public void testSetAdoptedAnimal() {
        HistoriqueAdoption historiqueAdoption = new HistoriqueAdoption();
        Animal adoptedAnimal = mock(Animal.class);
        historiqueAdoption.setAdoptedAnimal(adoptedAnimal);
        assertEquals(adoptedAnimal, historiqueAdoption.getAdoptedAnimal());
    }

    @Test
    public void testGetAdoptedByPerson() {
        HistoriqueAdoption historiqueAdoption = new HistoriqueAdoption();
        Person adoptedByPerson = mock(Person.class);
        historiqueAdoption.setAdoptedByPerson(adoptedByPerson);
        assertEquals(adoptedByPerson, historiqueAdoption.getAdoptedByPerson());
    }

    @Test
    public void testSetAdoptedByPerson() {
        HistoriqueAdoption historiqueAdoption = new HistoriqueAdoption();
        Person adoptedByPerson = mock(Person.class);
        historiqueAdoption.setAdoptedByPerson(adoptedByPerson);
        assertEquals(adoptedByPerson, historiqueAdoption.getAdoptedByPerson());
    }
    
    // Ajoutez d'autres tests pertinents en fonction de votre logique métier
}
