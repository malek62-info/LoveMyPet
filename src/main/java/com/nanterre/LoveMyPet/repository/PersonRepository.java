package com.nanterre.LoveMyPet.repository;

import com.nanterre.LoveMyPet.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
