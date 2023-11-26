package com.nanterre.LoveMyPet.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nanterre.LoveMyPet.model.Candidature;
import com.nanterre.LoveMyPet.repository.CandidatureRepository;
import com.nanterre.LoveMyPet.service.CandidatureServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MvcResult;

@WebMvcTest(CandidatureController.class)
@AutoConfigureMockMvc
public class CandidatureControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CandidatureRepository candidatureRepositoryMock;

    @MockBean
    private CandidatureServiceImpl candidatureServiceMock;

    @InjectMocks
    private CandidatureController candidatureController;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetCandidatureDetailsByAnimalIdAndCandidatureId() throws Exception {
        // Créez un objet Candidature avec des attributs spécifiques pour le test
        Candidature candidature = new Candidature();
        candidature.setIdCandidature(4);

        // Définissez le comportement du mock pour renvoyer une Candidature spécifique en fonction des IDs
        Mockito.when(candidatureServiceMock.getCandidatureDetailsByAnimalIdAndCandidatureId(5, 4))
                .thenReturn(candidature);

        // Effectuez la requête HTTP et vérifiez la réponse
        MvcResult result = mockMvc.perform(get("/animal/5/candidature/4"))
                .andExpect(status().isOk())
                .andReturn();

        // Récupérez la réponse sous forme de chaîne JSON
        String responseJson = result.getResponse().getContentAsString();

        // Imprimez dans les logs le résultat attendu et obtenu
        String expectedJson = objectMapper.writeValueAsString(candidature);
        System.out.println("Résultat attendu : " + expectedJson);
        System.out.println("Résultat obtenu   : " + responseJson);

        // Utilisez les assertions pour comparer les résultats
        JSONAssert.assertEquals(expectedJson, responseJson, false);
    }
}


