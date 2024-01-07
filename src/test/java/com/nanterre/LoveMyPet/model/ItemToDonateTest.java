package com.nanterre.LoveMyPet.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ItemToDonateTest {

    @Test
    void testGetId() {
        ItemToDonate itemToDonate = new ItemToDonate();
        itemToDonate.setId(1);
        assertEquals(1, itemToDonate.getId());
    }

    @Test
    void testSetId() {
        ItemToDonate itemToDonate = new ItemToDonate();
        itemToDonate.setId(2);
        assertEquals(2, itemToDonate.getId());
    }

    @Test
    void testGetItemName() {
        ItemToDonate itemToDonate = new ItemToDonate();
        itemToDonate.setItemName("Test Item");
        assertEquals("Test Item", itemToDonate.getItemName());
    }

    @Test
    void testSetItemName() {
        ItemToDonate itemToDonate = new ItemToDonate();
        itemToDonate.setItemName("Test Item");
        assertEquals("Test Item", itemToDonate.getItemName());
    }

    @Test
    void testGetDescription() {
        ItemToDonate itemToDonate = new ItemToDonate();
        itemToDonate.setDescription("Test Description");
        assertEquals("Test Description", itemToDonate.getDescription());
    }

    @Test
    void testSetDescription() {
        ItemToDonate itemToDonate = new ItemToDonate();
        itemToDonate.setDescription("Test Description");
        assertEquals("Test Description", itemToDonate.getDescription());
    }

    @Test
    void testGetImageUrl() {
        ItemToDonate itemToDonate = new ItemToDonate();
        itemToDonate.setImageUrl("test-image.jpg");
        assertEquals("test-image.jpg", itemToDonate.getImageUrl());
    }

    @Test
    void testSetImageUrl() {
        ItemToDonate itemToDonate = new ItemToDonate();
        itemToDonate.setImageUrl("test-image.jpg");
        assertEquals("test-image.jpg", itemToDonate.getImageUrl());
    }

    @Test
    void testGetDonatingPerson() {
        ItemToDonate itemToDonate = new ItemToDonate();
        Person donatingPerson = new Person();
        itemToDonate.setDonatingPerson(donatingPerson);
        assertEquals(donatingPerson, itemToDonate.getDonatingPerson());
    }

    @Test
    void testSetDonatingPerson() {
        ItemToDonate itemToDonate = new ItemToDonate();
        Person donatingPerson = new Person();
        itemToDonate.setDonatingPerson(donatingPerson);
        assertEquals(donatingPerson, itemToDonate.getDonatingPerson());
    }
}
