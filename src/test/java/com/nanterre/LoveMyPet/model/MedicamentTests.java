package com.nanterre.LoveMyPet.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MedicamentTests {

    @Test
    public void testGetIdMedicament() {
        Medicament medicament = new Medicament();
        medicament.setIdMedicament(1);
        assertEquals(1, medicament.getIdMedicament());
    }

    @Test
    public void testSetIdMedicament() {
        Medicament medicament = new Medicament();
        medicament.setIdMedicament(2);
        assertEquals(2, medicament.getIdMedicament());
    }

    @Test
    public void testGetMedicamentName() {
        Medicament medicament = new Medicament();
        medicament.setMedicamentName("Medicine A");
        assertEquals("Medicine A", medicament.getMedicamentName());
    }

    @Test
    public void testSetMedicamentName() {
        Medicament medicament = new Medicament();
        medicament.setMedicamentName("Medicine B");
        assertEquals("Medicine B", medicament.getMedicamentName());
    }
}
