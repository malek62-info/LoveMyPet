package com.nanterre.LoveMyPet.model;

import com.nanterre.LoveMyPet.model.AnimalPerdu;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class AnimalPerduTest {

    @Test
    void testAnimalPerduDefaultConstructor() {
        AnimalPerdu animalPerdu = new AnimalPerdu();
        assertNull(animalPerdu.getIdAnimalPerdu());
        assertNull(animalPerdu.getIdAnimal());
        assertEquals(0.0, animalPerdu.getLatitude());
        assertEquals(0.0, animalPerdu.getLongitude());
    }

    @Test
    void testAnimalPerduParameterizedConstructor() {
        AnimalPerdu animalPerdu = new AnimalPerdu(1, 12.34, 56.78);
        assertNull(animalPerdu.getIdAnimalPerdu());
        assertEquals(1, animalPerdu.getIdAnimal());
        assertEquals(12.34, animalPerdu.getLatitude());
        assertEquals(56.78, animalPerdu.getLongitude());
    }

    @Test
    void testSettersAndGetters() {
        AnimalPerdu animalPerdu = new AnimalPerdu();
        animalPerdu.setIdAnimalPerdu(1L);
        animalPerdu.setIdAnimal(2);
        animalPerdu.setLatitude(12.34);
        animalPerdu.setLongitude(56.78);

        assertEquals(1L, animalPerdu.getIdAnimalPerdu());
        assertEquals(2, animalPerdu.getIdAnimal());
        assertEquals(12.34, animalPerdu.getLatitude());
        assertEquals(56.78, animalPerdu.getLongitude());
    }
}
