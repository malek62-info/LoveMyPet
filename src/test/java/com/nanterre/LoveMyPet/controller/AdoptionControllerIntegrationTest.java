package com.nanterre.LoveMyPet.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nanterre.LoveMyPet.model.Animal;
import com.nanterre.LoveMyPet.service.AnimalService;
import com.nanterre.LoveMyPet.service.AnimalServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.hasSize;

import java.sql.Date;
import java.util.Arrays;

@SpringBootTest
@AutoConfigureMockMvc
public class AdoptionControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AnimalServiceImpl animalServiceMock;

    @Test
    public void testGetAdoptionUrlsForAnimalsIntegration() throws Exception {
        // Créez des objets Animal avec des IDs spécifiques pour le test
        Animal animal1 = new Animal();
        animal1.setId(1);

        Animal animal2 = new Animal();
        animal2.setId(2);

        // Définissez le comportement du mock pour renvoyer des URLs spécifiques
        Mockito.when(animalServiceMock.getAdoptionUrlsForAnimals())
                .thenReturn(Arrays.asList("adoption/animal/" + animal1.getId(), "adoption/animal/" + animal2.getId()));

        // Effectuez la requête HTTP et vérifiez la réponse
        mockMvc.perform(get("/adoption/animaux"))
                .andExpect(content().json("[\"adoption/animal/1\", \"adoption/animal/2\"]"));
    }

    @Test
    public void testGetAnimalDetailsByIdIntegration() throws Exception {
        // Créez un objet Animal avec des attributs spécifiques pour le test
        Animal animal = new Animal();
        animal.setId(1);
        animal.setIdPerson(101); // Remplacez par un ID de personne réel si nécessaire
        animal.setName("Buddy");
        animal.setCategory("Dog");
        animal.setRace("Golden Retriever");
        animal.setWeight(25.5);
        animal.setGender(1); // 1 pour mâle, 2 pour femelle
       // animal.setDateOfBirth(new Date());
        animal.setImageUrl("https://example.com/buddy.jpg");

        // Définissez le comportement du mock pour renvoyer un Animal spécifique en fonction de l'ID
        Mockito.when(animalServiceMock.getAnimalDetailsById(1))
                .thenReturn(animal);

        // Effectuez la requête HTTP et vérifiez la réponse
        mockMvc.perform(get("/adoption/animal/1"))
                .andExpect(content().json(new ObjectMapper().writeValueAsString(animal)));
    }
}
