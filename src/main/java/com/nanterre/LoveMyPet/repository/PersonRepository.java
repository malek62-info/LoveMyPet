package com.nanterre.LoveMyPet.repository;

import com.nanterre.LoveMyPet.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {
}

