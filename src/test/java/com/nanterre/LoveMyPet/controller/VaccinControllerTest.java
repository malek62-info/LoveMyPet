package com.nanterre.LoveMyPet.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nanterre.LoveMyPet.model.Vaccin;
import com.nanterre.LoveMyPet.service.VaccinService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.mockito.Mockito.when;

@WebMvcTest(VaccinController.class)
@AutoConfigureMockMvc
public class VaccinControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VaccinService vaccinServiceMock;

    @InjectMocks
    private VaccinController vaccinController;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetAllVaccins() throws Exception {
        // Créez des objets Vaccin pour le test
        Vaccin vaccin1 = new Vaccin();
        Vaccin vaccin2 =new Vaccin();
        vaccin1.setVaccinName("Vaccin1");
        vaccin1.setIdVaccin(1);
        vaccin2.setVaccinName("Vaccin2");
        vaccin2.setIdVaccin(2);
        // Définissez le comportement du mock pour renvoyer une liste de vaccins spécifiques
        Mockito.when(vaccinServiceMock.getAllVaccins())
                .thenReturn(List.of(vaccin1, vaccin2));

        // Effectuez la requête HTTP et vérifiez la réponse
        MvcResult result = mockMvc.perform(get("/vaccin/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        // Récupérez la réponse sous forme de chaîne JSON
        String responseJson = result.getResponse().getContentAsString();

        // Imprimez dans les logs le résultat attendu et obtenu
        String expectedJson = objectMapper.writeValueAsString(List.of(vaccin1, vaccin2));
        System.out.println("Résultat attendu : " + expectedJson);
        System.out.println("Résultat obtenu   : " + responseJson);

        // Utilisez les assertions pour comparer les résultats
        JSONAssert.assertEquals(expectedJson, responseJson, false);
    }
}
