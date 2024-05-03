package com.nanterre.LoveMyPet.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalPerduTest {
    @Test
    public void testGettersAndSetters() {
        AnimalPerdu animalPerdu = new AnimalPerdu(1, 48.8566, 2.3522);

        assertEquals(1, animalPerdu.getIdAnimal());
        assertEquals(48.8566, animalPerdu.getLatitude());
        assertEquals(2.3522, animalPerdu.getLongitude());
    }
}