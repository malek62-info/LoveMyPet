package com.nanterre.LoveMyPet.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nanterre.LoveMyPet.model.Animal;
import com.nanterre.LoveMyPet.model.Vaccination;
import com.nanterre.LoveMyPet.service.VaccinationServiceImpl;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class VaccinationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VaccinationServiceImpl vaccinationServiceMock;

    @Test
    public void testGetVaccinationReferenceByAnimalId() throws Exception {
        // Créez un objet Animal avec un ID spécifique pour le test
        Animal animal = new Animal();
        animal.setId(1);

        // Créez des objets de vaccination associés à l'animal
        Vaccination vaccination1 = new Vaccination();
        vaccination1.setIdVaccination(1);
        vaccination1.setAnimal(animal);

        Vaccination vaccination2 = new Vaccination();
        vaccination2.setIdVaccination(2);
        vaccination2.setAnimal(animal);

        // Définissez le comportement du mock pour renvoyer des références de vaccination spécifiques pour un ID d'animal donné
        Mockito.when(vaccinationServiceMock.getVaccinationLinksByAnimalId(animal.getId()))
                .thenReturn(Arrays.asList("/vaccination/1", "/vaccination/2"));

        // Effectuez la requête HTTP et vérifiez la réponse
        mockMvc.perform(get("/vaccination/animal/1"))
                .andExpect(content().json("[\"/vaccination/1\", \"/vaccination/2\"]"));
    }

    @Test
    public void testGetVaccinationDetailsById() throws Exception {
        // Créez un objet Vaccination avec un ID spécifique pour le test
        Vaccination vaccination = new Vaccination();
        vaccination.setIdVaccination(1);
        vaccination.setAnimal(new Animal());
        vaccination.setDate(new Date());

        // Définissez le comportement du mock pour renvoyer une Vaccination spécifique en fonction de l'ID
        Mockito.when(vaccinationServiceMock.getVaccinationDetailsById(vaccination.getIdVaccination()))
                .thenReturn(vaccination);

        // Effectuez la requête HTTP et vérifiez la réponse
        MvcResult result = mockMvc.perform(get("/vaccination/1"))
                .andExpect(status().isOk())
                .andReturn();

        // Obtenez la date de la réponse
        String responseContent = result.getResponse().getContentAsString();
        JSONObject responseJson = new JSONObject(responseContent);
        OffsetDateTime actualDate = OffsetDateTime.parse(responseJson.getString("date"));

        // Comparez les dates
        assertEquals(vaccination.getDate().toInstant().atOffset(ZoneOffset.UTC), actualDate);
    }
}