package com.nanterre.LoveMyPet.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nanterre.LoveMyPet.model.Adoption;
import com.nanterre.LoveMyPet.model.Animal;
import com.nanterre.LoveMyPet.model.Person;
import com.nanterre.LoveMyPet.service.AdoptionService;
import com.nanterre.LoveMyPet.service.AnimalService;
import com.nanterre.LoveMyPet.service.AnimalServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@AutoConfigureMockMvc

public class AnimalControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AnimalServiceImpl animalServiceMock;

    @InjectMocks
    private AnimalController animalController;



    @Mock
    private AdoptionService adoptionService;


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
        when(animalServiceMock.getAnimalLinksByPersonId(person.getIdPerson()))
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
        when(animalServiceMock.getAnimalDetailsById(animal.getId()))
                .thenReturn(animal);

        // Effectuez la requête HTTP et vérifiez la réponse
        mockMvc.perform(get("/animal/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(animal)));
    }


    //malek

    @Test
    public void testAddAnimal() throws Exception {
        // Initialisation des mocks
        MockitoAnnotations.initMocks(this);

        // Créez un objet Animal de test
        Animal animal = new Animal();

        // Créez un fichier bidon pour simuler le téléchargement d'une image
        MockMultipartFile imageFile = new MockMultipartFile("imageFile", "test.jpg", "image/jpeg", "Spring Framework".getBytes());

        // Appelez la méthode à tester
        ResponseEntity<String> responseEntity = animalController.addAnimal(imageFile, animal);

        // Vérifiez que la méthode du service a été appelée une fois
        verify(animalServiceMock, times(1)).saveAnimal(any(Animal.class));

        // Vérifiez la réponse de l'API
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Nouvel animal ajouté", responseEntity.getBody());

        // Vérifiez que le fichier a été écrit correctement
        String dossierImages = "src/main/resources/static/images/animals";
        String nomDuFichier = imageFile.getOriginalFilename();
        Path cheminFichier = Paths.get(dossierImages, nomDuFichier);
        assertTrue(Files.exists(cheminFichier));

        // Vérifiez que l'URL de l'image a été correctement définie dans l'objet Animal
        assertEquals(nomDuFichier, animal.getImageUrl());
    }

    @Test
    void testAddAdoption() {
        // Arrange
        Adoption adoption = new Adoption();

        // Remplacez cette partie avec la modification pour simuler une exception
        doThrow(new RuntimeException("Simulated exception")).when(adoptionService).saveAdoption(adoption);

        // Act
        ResponseEntity<Map<String, String>> response = animalController.addAdoption(adoption);

        // Assert
        verify(adoptionService, times(1)).saveAdoption(adoption);
        Map<String, String> expectedResponse = new HashMap<>();
        expectedResponse.put("message", "Erreur lors de l'ajout de l'adoption");
        assertResponse(response, HttpStatus.INTERNAL_SERVER_ERROR, expectedResponse);
    }

    // Méthode utilitaire pour vérifier la réponse
    private void assertResponse(ResponseEntity<Map<String, String>> response, HttpStatus expectedStatus, Map<String, String> expectedBody) {
        assert response.getStatusCode() == expectedStatus;
        assert response.getBody().equals(expectedBody);
    }
}