package com.nanterre.LoveMyPet.model;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VaccinTests {

    @Test
    public void testVaccinGettersAndSetters() {
        // Création d'un vaccin
        Vaccin vaccin = new Vaccin();
        vaccin.setIdVaccin(1);
        vaccin.setVaccinName("VaccinA");

        // Vérification des getters
        assertEquals(1, vaccin.getIdVaccin());
        assertEquals("VaccinA", vaccin.getVaccinName());

        // Modification des valeurs
        vaccin.setVaccinName("VaccinB");

        // Vérification des setters
        assertEquals("VaccinB", vaccin.getVaccinName());
    }
}
