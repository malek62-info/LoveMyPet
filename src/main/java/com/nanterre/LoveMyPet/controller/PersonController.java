package com.nanterre.LoveMyPet.controller;

import com.nanterre.LoveMyPet.model.Person;
import com.nanterre.LoveMyPet.service.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServiceImpl personService;

    @GetMapping("/{id}")
    public Person getPersonDetailsById(@PathVariable Integer id) {
        return personService.getPersonDetailsById(id);
    }
}
