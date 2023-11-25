package com.nanterre.LoveMyPet.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nanterre.LoveMyPet.model.Person;
import com.nanterre.LoveMyPet.service.PersonServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.skyscreamer.jsonassert.JSONAssert;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PersonController.class)
public class PersonControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonServiceImpl personServiceMock;

    @InjectMocks
    private PersonController personController;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetPersonDetailsById() throws Exception {
        // Créez un objet Person avec des attributs spécifiques pour le test
        Person person = new Person();
        person.setId(1);
        person.setFirstName("John");
        person.setLastName("Doe");
        // Initialisez d'autres propriétés selon votre modèle Person

        // Définissez le comportement du mock pour renvoyer une Person spécifique en fonction de l'ID
        when(personServiceMock.getPersonDetailsById(1)).thenReturn(person);

        // Effectuez la requête HTTP et vérifiez la réponse
        MvcResult result = mockMvc.perform(get("/person/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        // Récupérez la réponse sous forme de chaîne JSON
        String responseJson = result.getResponse().getContentAsString();

        // Imprimez dans les logs le résultat attendu et obtenu
        String expectedJson = objectMapper.writeValueAsString(person);
        System.out.println("Résultat attendu : " + expectedJson);
        System.out.println("Résultat obtenu   : " + responseJson);

        // Utilisez les assertions pour comparer les résultats avec JSONAssert
        JSONAssert.assertEquals(expectedJson, responseJson, false);
    }
}
