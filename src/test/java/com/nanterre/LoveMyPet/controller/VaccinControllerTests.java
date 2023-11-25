package com.nanterre.LoveMyPet.controller;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.nanterre.LoveMyPet.model.Vaccin;
import com.nanterre.LoveMyPet.service.VaccinService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class VaccinControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VaccinService vaccinServiceMock;

    @Test
    public void testGetAllVaccins() throws Exception {
        // Créez des objets de vaccin pour le test
        Vaccin vaccin1 = new Vaccin();
        vaccin1.setIdVaccin(1);
        vaccin1.setVaccinName("Vaccin1");

        Vaccin vaccin2 = new Vaccin();
        vaccin2.setIdVaccin(2);
        vaccin2.setVaccinName("Vaccin2");

        // Définissez le comportement du mock pour renvoyer tous les vaccins
        Mockito.when(vaccinServiceMock.getAllVaccins())
                .thenReturn(Arrays.asList(vaccin1, vaccin2));

        // Effectuez la requête HTTP et vérifiez la réponse
        mockMvc.perform(get("/vaccin/all"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"idVaccin\":1,\"vaccinName\":\"Vaccin1\"},{\"idVaccin\":2,\"vaccinName\":\"Vaccin2\"}]"));
    }
}
