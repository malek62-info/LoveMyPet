package com.nanterre.LoveMyPet.model;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalVuTest {
    @Test
    public void testGettersAndSetters() {
        LocalDate date = LocalDate.of(2024, 5, 3);
        LocalTime time = LocalTime.of(12, 30);
        AnimalVu animalVu = new AnimalVu(1, 2, date, time, 48.8566, 2.3522, 10.0);

        assertEquals(1, animalVu.getIdAnimal());
        assertEquals(2, animalVu.getIdPersonne());
        assertEquals(date, animalVu.getDate());
        assertEquals(time, animalVu.getHeure());
        assertEquals(48.8566, animalVu.getLatitude());
        assertEquals(2.3522, animalVu.getLongitude());
        assertEquals(10.0, animalVu.getRayon());
    }
}