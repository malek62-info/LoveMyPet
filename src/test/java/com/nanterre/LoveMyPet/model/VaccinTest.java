package com.nanterre.LoveMyPet.model;


import com.nanterre.LoveMyPet.model.Vaccin;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VaccinTest {

    @Test
    void testGettersAndSetters() {
        // Create a Vaccin object
        Vaccin vaccin = new Vaccin();

        // Set values using setters
        vaccin.setIdVaccin(1);
        vaccin.setVaccinName("Vaccin A");
        vaccin.setInfoVaccin("Information about Vaccin A");

        // Check if getters return the expected values
        assertEquals(1, vaccin.getIdVaccin());
        assertEquals("Vaccin A", vaccin.getVaccinName());
        assertEquals("Information about Vaccin A", vaccin.getInfoVaccin());
    }
}

