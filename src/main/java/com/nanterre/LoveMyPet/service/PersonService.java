package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.Candidature;
import com.nanterre.LoveMyPet.model.Person;

public interface PersonService {
    Person getPersonDetailsById(Integer id);
    public Person savePerson(Person person);
    public Person findPersonByEmail(String email);

}
