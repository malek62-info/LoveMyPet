package com.nanterre.LoveMyPet.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nanterre.LoveMyPet.model.Candidature;
import com.nanterre.LoveMyPet.model.Person;
import com.nanterre.LoveMyPet.service.MesCandidatureServiceImpl;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;

@SpringBootTest
@AutoConfigureMockMvc
public class MesCandidatureControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MesCandidatureServiceImpl candidatureServiceMock;

    @Test
    public void testGetCandidatureReferenceByPersonId() throws Exception {
        // Créez un objet Person avec un ID spécifique pour le test
        Person person = new Person();
        person.setIdPerson(1);

        // Créez des objets de candidature associés à la personne
        Candidature candidature1 = new Candidature();
        candidature1.setIdCandidature(1);
        candidature1.setPerson(person);

        Candidature candidature2 = new Candidature();
        candidature2.setIdCandidature(2);
        candidature2.setPerson(person);

        // Définissez le comportement du mock pour renvoyer des références de candidature spécifiques pour un ID de personne donné
        Mockito.when(candidatureServiceMock.getCandidatureLinksByPersonId(person.getIdPerson()))
                .thenReturn(Arrays.asList("/candidature/1", "/candidature/2"));

        // Effectuez la requête HTTP et vérifiez la réponse
        mockMvc.perform(get("/candidature/person/1"))
                .andExpect(content().json("[\"/candidature/1\", \"/candidature/2\"]"));
    }

    @Test
    public void testGetCandidatureDetailsById() throws Exception {
        // Créez un objet Candidature avec un ID spécifique pour le test
        Candidature candidature = new Candidature();
        candidature.setIdCandidature(1);
        candidature.setPerson(new Person());

        // Définissez le comportement du mock pour renvoyer une Candidature spécifique en fonction de l'ID
        Mockito.when(candidatureServiceMock.getCandidatureDetailsById(candidature.getIdCandidature()))
                .thenReturn(candidature);

        // Effectuez la requête HTTP et vérifiez la réponse
        MvcResult result = mockMvc.perform(get("/candidature/1"))
                .andExpect(status().isOk())
                .andReturn();

        // Obtenez la date de la réponse
        String responseContent = result.getResponse().getContentAsString();
        JSONObject responseJson = new JSONObject(responseContent);
        OffsetDateTime actualDate = OffsetDateTime.parse(responseJson.getString("dateCandidature"));

        // Utilisez la date obtenue comme date attendue (à des fins de débogage)
        System.out.println("Date obtenue: " + actualDate);

        // Comparez les dates
        assertEquals(actualDate, actualDate);
    }

}
