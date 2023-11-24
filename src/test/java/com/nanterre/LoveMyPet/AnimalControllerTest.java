
package com.nanterre.LoveMyPet;
import com.nanterre.LoveMyPet.controller.AnimalController;
import com.nanterre.LoveMyPet.model.Animal;
import com.nanterre.LoveMyPet.service.AdoptionService;
import com.nanterre.LoveMyPet.service.AnimalService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class AnimalControllerTest {

    @Mock
    private AnimalService animalService;

    @Mock
    private AdoptionService adoptionService;

    @InjectMocks
    private AnimalController animalController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddAnimal() throws Exception {
        // Créez un objet Animal de test
        Animal animal = new Animal();

        // Créez un fichier bidon pour simuler le téléchargement d'une image
        MockMultipartFile imageFile = new MockMultipartFile("imageFile", "test.jpg", "image/jpeg", "Spring Framework".getBytes());

        // Configurez le comportement attendu lors de l'appel des méthodes du service
        when(animalService.saveAnimal(any(Animal.class))).thenReturn(animal);

        // Appelez la méthode à tester
        ResponseEntity<String> responseEntity = animalController.addAnimal(imageFile, animal);

        // Vérifiez que la méthode du service a été appelée une fois
        verify(animalService, times(1)).saveAnimal(any(Animal.class));

        // Vérifiez la réponse de l'API
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Nouvel animal ajouté", responseEntity.getBody());
    }


    @Test
    public void testAddAnimalWithException() throws Exception {
        // Créez un objet Animal de test
        Animal animal = new Animal();

        // Créez un fichier bidon pour simuler le téléchargement d'une image
        MockMultipartFile imageFile = new MockMultipartFile("imageFile", "test.jpg", "image/jpeg", "Spring Framework".getBytes());

        // Configurez le comportement attendu lors de l'appel des méthodes du service
        doThrow(new RuntimeException("Erreur lors de l'ajout de l'animal")).when(animalService).saveAnimal(any(Animal.class));

        // Appelez la méthode à tester
        ResponseEntity<String> responseEntity = animalController.addAnimal(imageFile, animal);

        // Vérifiez que la méthode du service a été appelée une fois
        verify(animalService, times(1)).saveAnimal(any(Animal.class));

        // Vérifiez la réponse de l'API
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        assertEquals("Erreur lors de la gestion de l'image", responseEntity.getBody());
    }

    // Les autres tests pour addAdoption que nous avons déjà discutés...

}
