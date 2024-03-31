package com.nanterre.LoveMyPet.model;

import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TraitementTests {

    @Test
    public void testGetIdTraitement() {
        Traitement traitement = new Traitement();
        traitement.setIdTraitement(1);
        assertEquals(1, traitement.getIdTraitement());
    }

    @Test
    public void testSetIdTraitement() {
        Traitement traitement = new Traitement();
        traitement.setIdTraitement(2);
        assertEquals(2, traitement.getIdTraitement());
    }

    @Test
    public void testGetMedicament() {
        Traitement traitement = new Traitement();
        Medicament medicament = new Medicament();
        traitement.setMedicament(medicament);
        assertEquals(medicament, traitement.getMedicament());
    }

    @Test
    public void testSetMedicament() {
        Traitement traitement = new Traitement();
        Medicament medicament = new Medicament();
        traitement.setMedicament(medicament);
        assertEquals(medicament, traitement.getMedicament());
    }

    @Test
    public void testGetAnimal() {
        Traitement traitement = new Traitement();
        Animal animal = new Animal();
        traitement.setAnimal(animal);
        assertEquals(animal, traitement.getAnimal());
    }

    @Test
    public void testSetAnimal() {
        Traitement traitement = new Traitement();
        Animal animal = new Animal();
        traitement.setAnimal(animal);
        assertEquals(animal, traitement.getAnimal());
    }

    @Test
    public void testGetDateDebut() {
        Traitement traitement = new Traitement();
        Date date = new Date();
        traitement.setDateDebut(date);
        assertEquals(date, traitement.getDateDebut());
    }

    @Test
    public void testSetDateDebut() {
        Traitement traitement = new Traitement();
        Date date = new Date();
        traitement.setDateDebut(date);
        assertEquals(date, traitement.getDateDebut());
    }

    @Test
    public void testGetDateFin() {
        Traitement traitement = new Traitement();
        Date date = new Date();
        traitement.setDateFin(date);
        assertEquals(date, traitement.getDateFin());
    }

    @Test
    public void testSetDateFin() {
        Traitement traitement = new Traitement();
        Date date = new Date();
        traitement.setDateFin(date);
        assertEquals(date, traitement.getDateFin());
    }

    @Test
    public void testGetNombrePrises() {
        Traitement traitement = new Traitement();
        traitement.setNombrePrises(3);
        assertEquals(3, traitement.getNombrePrises());
    }

    @Test
    public void testSetNombrePrises() {
        Traitement traitement = new Traitement();
        traitement.setNombrePrises(4);
        assertEquals(4, traitement.getNombrePrises());
    }

    @Test
    public void testGetCommentaire() {
        Traitement traitement = new Traitement();
        traitement.setCommentaire("Sample comment");
        assertEquals("Sample comment", traitement.getCommentaire());
    }

    @Test
    public void testSetCommentaire() {
        Traitement traitement = new Traitement();
        traitement.setCommentaire("Another comment");
        assertEquals("Another comment", traitement.getCommentaire());
    }

    @Test
    public void testGetHeures() {
        Traitement traitement = new Traitement();
        List<Heure> heures = new ArrayList<>();
        traitement.setHeures(heures);
        assertEquals(heures, traitement.getHeures());
    }

    @Test
    public void testSetHeures() {
        Traitement traitement = new Traitement();
        List<Heure> heures = new ArrayList<>();
        traitement.setHeures(heures);
        assertEquals(heures, traitement.getHeures());
    }

    @Test
    public void testGetFichierUrl() {
        Traitement traitement = new Traitement();
        traitement.setFichierUrl("testFile.pdf");
        assertEquals("testFile.pdf", traitement.getFichierUrl());
    }

    @Test
    public void testSetFichierUrl() {
        Traitement traitement = new Traitement();
        traitement.setFichierUrl("anotherFile.png");
        assertEquals("anotherFile.png", traitement.getFichierUrl());
    }
}
