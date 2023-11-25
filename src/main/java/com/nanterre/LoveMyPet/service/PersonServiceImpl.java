package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.Candidature;
import com.nanterre.LoveMyPet.model.Person;
import com.nanterre.LoveMyPet.repository.PersonRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person getPersonDetailsById(Integer id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        return optionalPerson.orElse(null);
    }


    
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
