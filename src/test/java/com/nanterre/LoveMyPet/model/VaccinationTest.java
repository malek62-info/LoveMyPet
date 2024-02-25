package com.nanterre.LoveMyPet.model;

import com.nanterre.LoveMyPet.model.Vaccination;
import org.junit.jupiter.api.Test;
import java.time.LocalTime;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class VaccinationTest {

    @Test
    void testGettersAndSetters() {
        // Create a Vaccination object
        Vaccination vaccination = new Vaccination();

        // Set values using setters
        vaccination.setIdVaccination(1);
        vaccination.setIdVaccin(2);
        vaccination.setIdAnimal(3);
        vaccination.setDate(new Date());
        vaccination.setVaccinationTime(LocalTime.of(9, 0));
        vaccination.setVetAddress("123 Main Street");
        vaccination.setVetName("Dr. Smith");
        vaccination.setComment("Routine vaccination");

        // Check if getters return the expected values
        assertEquals(1, vaccination.getIdVaccination());
        assertEquals(2, vaccination.getIdVaccin());
        assertEquals(3, vaccination.getIdAnimal());
        assertNotNull(vaccination.getDate());
        assertEquals(LocalTime.of(9, 0), vaccination.getVaccinationTime());
        assertEquals("123 Main Street", vaccination.getVetAddress());
        assertEquals("Dr. Smith", vaccination.getVetName());
        assertEquals("Routine vaccination", vaccination.getComment());
    }
}
