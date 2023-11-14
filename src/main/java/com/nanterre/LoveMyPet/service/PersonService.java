package com.nanterre.LoveMyPet.service;


import com.nanterre.LoveMyPet.model.Person;

public interface PersonService {
    public Person savePerson(Person person);
    public Person findPersonByEmail(String email);

}