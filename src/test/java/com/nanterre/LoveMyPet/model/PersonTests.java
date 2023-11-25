package com.nanterre.LoveMyPet.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTests {

    @Test
    public void testGetIdPerson() {
        Person person = new Person();
        person.setIdPerson(1);
        assertEquals(1, person.getIdPerson());
    }

    @Test
    public void testSetIdPerson() {
        Person person = new Person();
        person.setIdPerson(2);
        assertEquals(2, person.getIdPerson());
    }

    @Test
    public void testGetLastName() {
        Person person = new Person();
        person.setLastName("Doe");
        assertEquals("Doe", person.getLastName());
    }

    @Test
    public void testSetLastName() {
        Person person = new Person();
        person.setLastName("Smith");
        assertEquals("Smith", person.getLastName());
    }

    @Test
    public void testGetFirstName() {
        Person person = new Person();
        person.setFirstName("John");
        assertEquals("John", person.getFirstName());
    }

    @Test
    public void testSetFirstName() {
        Person person = new Person();
        person.setFirstName("Jane");
        assertEquals("Jane", person.getFirstName());
    }

    @Test
    public void testGetEmail() {
        Person person = new Person();
        person.setEmail("john.doe@example.com");
        assertEquals("john.doe@example.com", person.getEmail());
    }

    @Test
    public void testSetEmail() {
        Person person = new Person();
        person.setEmail("jane.smith@example.com");
        assertEquals("jane.smith@example.com", person.getEmail());
    }

    @Test
    public void testGetPhoneNumber() {
        Person person = new Person();
        person.setPhoneNumber("123456789");
        assertEquals("123456789", person.getPhoneNumber());
    }

    @Test
    public void testSetPhoneNumber() {
        Person person = new Person();
        person.setPhoneNumber("987654321");
        assertEquals("987654321", person.getPhoneNumber());
    }

    @Test
    public void testGetAddress() {
        Person person = new Person();
        person.setAddress("123 Main St, City");
        assertEquals("123 Main St, City", person.getAddress());
    }

    @Test
    public void testSetAddress() {
        Person person = new Person();
        person.setAddress("456 Oak St, Town");
        assertEquals("456 Oak St, Town", person.getAddress());
    }

    @Test
    public void testGetPassword() {
        Person person = new Person();
        person.setPassword("secret123");
        assertEquals("secret123", person.getPassword());
    }

    @Test
    public void testSetPassword() {
        Person person = new Person();
        person.setPassword("password456");
        assertEquals("password456", person.getPassword());
    }

    @Test
    public void testGetImageUrl() {
        Person person = new Person();
        person.setImageUrl("http://example.com/avatar.jpg");
        assertEquals("http://example.com/avatar.jpg", person.getImageUrl());
    }

    @Test
    public void testSetImageUrl() {
        Person person = new Person();
        person.setImageUrl("http://example.com/profile.jpg");
        assertEquals("http://example.com/profile.jpg", person.getImageUrl());
    }
}
