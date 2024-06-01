package com.nanterre.LoveMyPet.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nanterre.LoveMyPet.model.AnimalVu;
import com.nanterre.LoveMyPet.service.AnimalVuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Collections;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AnimalVuControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AnimalVuService animalVuService;

    @Autowired
    private ObjectMapper objectMapper;

/*
    @Test
    public void testAjouterAnimalVu() throws Exception {
        // Créer un objet AnimalVu pour le test
        AnimalVu animalVu = new AnimalVu(1, 1, null, null, 0.0, 0.0, 0.0);

        // Effectuer la requête POST et vérifier le statut de la réponse
        mockMvc.perform(post("/api/animalvu/ajouter")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(animalVu)))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAnimalCoordsById() throws Exception {
        // Créer une liste simulée d'objets AnimalVu
        List<AnimalVu> animalCoords = Collections.singletonList(new AnimalVu(1, 1, null, null, 0.0, 0.0, 0.0));

        // Configurer le comportement simulé du service
        when(animalVuService.getAnimalCoordsById(1)).thenReturn(animalCoords);

        // Effectuer la requête GET et vérifier la réponse
        mockMvc.perform(get("/coords/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(animalCoords.size()));
    }

    */
 
}