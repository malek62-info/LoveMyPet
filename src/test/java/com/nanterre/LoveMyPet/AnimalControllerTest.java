
package com.nanterre.LoveMyPet;

import com.nanterre.LoveMyPet.controller.AnimalController;
import com.nanterre.LoveMyPet.model.Animal;
import com.nanterre.LoveMyPet.service.AnimalService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;

import static org.mockito.Mockito.*;

public class AnimalControllerTest {

    @Mock
    private AnimalService animalService;

    @InjectMocks
    private AnimalController animalController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddAnimal() {
        // Créez un animal de test avec les données nécessaires
        Animal animal = new Animal();

        // Créez un fichier image de test
        MockMultipartFile imageFile = new MockMultipartFile("imageFile", "test-image.jpg", "image/jpeg", "test image content".getBytes());

        // Configurez le comportement attendu lors de l'appel des méthodes du service
        doNothing().when(animalService).saveAnimal(any(Animal.class));

        // Appelez la méthode à tester
        ResponseEntity<String> responseEntity = animalController.addAnimal(imageFile, animal);

        // Vérifiez que la méthode du service a été appelée une fois
        verify(animalService, times(1)).saveAnimal(any(Animal.class));

        // Vérifiez la réponse de l'API
        assert(responseEntity.getStatusCode() == HttpStatus.OK);
        assert(responseEntity.getBody().equals("Nouvel animal ajouté"));
    }
}
