package com.nanterre.LoveMyPet.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nanterre.LoveMyPet.model.Animal;
import com.nanterre.LoveMyPet.model.Person;
import com.nanterre.LoveMyPet.service.AnimalService;
import com.nanterre.LoveMyPet.service.AnimalServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Date;
import java.util.Arrays;

@SpringBootTest
@AutoConfigureMockMvc

public class AnimalControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AnimalServiceImpl animalServiceMock;



    @Test
    public void testGetAnimalsReferenceByPersonId() throws Exception {
        // Créez un objet Person avec un ID spécifique pour le test
        Person person = new Person();
        person.setIdPerson(1);

        // Créez des objets Animal associés à la personne
        Animal animal1 = new Animal();
        animal1.setId(1);
        animal1.setIdPerson(person.getIdPerson());

        Animal animal2 = new Animal();
        animal2.setId(2);
        animal2.setIdPerson(person.getIdPerson());

        // Définissez le comportement du mock pour renvoyer des références d'animaux spécifiques pour un ID de personne donné
        Mockito.when(animalServiceMock.getAnimalLinksByPersonId(person.getIdPerson()))
                .thenReturn(Arrays.asList("animal/" + animal1.getId(), "animal/" + animal2.getId()));

        // Effectuez la requête HTTP et vérifiez la réponse
        mockMvc.perform(get("/animal/person/1", person.getIdPerson()))
                .andExpect(content().json("[\"animal/1\", \"animal/2\"]"));
    }

    ;  // Assurez-vous d'avoir correctement importé ObjectMapper

    @Test
    public void testGetAnimalDetailsById() throws Exception {
        // Créez un objet Animal avec un ID spécifique pour le test
        Animal animal = new Animal();
        animal.setId(1);
        animal.setName("Fido");
        // Ajoutez d'autres propriétés selon votre modèle Animal

        // Définissez le comportement du mock pour renvoyer un Animal spécifique en fonction de l'ID
        Mockito.when(animalServiceMock.getAnimalDetailsById(animal.getId()))
                .thenReturn(animal);

        // Effectuez la requête HTTP et vérifiez la réponse
        mockMvc.perform(get("/animal/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(animal)));
    }

}
