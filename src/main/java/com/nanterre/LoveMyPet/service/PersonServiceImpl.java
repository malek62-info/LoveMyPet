package com.nanterre.LoveMyPet.service;

import org.springframework.beans.factory.annotation.Autowired;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import java.util.List;
import com.nanterre.LoveMyPet.model.Person;
import com.nanterre.LoveMyPet.repository.PersonRepository;


@Service
public class PersonServiceImpl implements PersonService {

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

  
    
    @Override
    public Person findPersonByEmail(String email) {
        // Utilisez une requête JPQL pour rechercher un utilisateur par e-mail
        TypedQuery<Person> query = entityManager.createQuery("SELECT p FROM Person p WHERE p.Email = :email", Person.class);
        query.setParameter("email", email);

        List<Person> resultList = query.getResultList();
        if (resultList.isEmpty()) {
            return null;
        } else {
            return resultList.get(0);
        }
    }

	
}
