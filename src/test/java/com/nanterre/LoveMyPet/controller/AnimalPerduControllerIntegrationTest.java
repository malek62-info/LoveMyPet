package com.nanterre.LoveMyPet.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nanterre.LoveMyPet.model.AnimalPerdu;
import com.nanterre.LoveMyPet.service.AnimalPerduService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Collections;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AnimalPerduControllerIntegrationTest {
/*
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AnimalPerduService animalPerduService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testAjouterAnimalPerdu() throws Exception {
        AnimalPerdu animalPerdu = new AnimalPerdu(1, 48.8566, 2.3522);
        when(animalPerduService.ajouterAnimalPerdu(1, 48.8566, 2.3522)).thenReturn(animalPerdu);

        mockMvc.perform(post("/api/animalperdu/ajouter")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(animalPerdu)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.idAnimal").value(1))
                .andExpect(jsonPath("$.latitude").value(48.8566))
                .andExpect(jsonPath("$.longitude").value(2.3522));
    }

    @Test
    public void testGetAnimalsWithinRadius() throws Exception {
        when(animalPerduService.getAnimalsWithinRadius(48.8566, 2.3522)).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/api/animalperdu/animals-within-radius")
                        .param("latitude", "48.8566")
                        .param("longitude", "2.3522"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    public void testVerifierAnimalPerdu() throws Exception {
        when(animalPerduService.animalExisteDeja(1)).thenReturn(true);

        mockMvc.perform(get("/api/animalperdu/verifier/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.declarePerdu").value(true));
    }




 */
}