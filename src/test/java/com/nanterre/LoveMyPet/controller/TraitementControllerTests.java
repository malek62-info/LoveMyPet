package com.nanterre.LoveMyPet.controller;

import com.nanterre.LoveMyPet.model.Heure;
import com.nanterre.LoveMyPet.model.Traitement;
import com.nanterre.LoveMyPet.service.TraitementService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class TraitementControllerTests {

    @Mock
    private TraitementService traitementService;

    @InjectMocks
    private TraitementController traitementController;

    @Test
    public void testGetTraitementLinksByAnimalId() {
        List<String> expectedLinks = new ArrayList<>();
        expectedLinks.add("link1");
        expectedLinks.add("link2");

        when(traitementService.getTraitementLinksByAnimalId(1)).thenReturn(expectedLinks);

        List<String> actualLinks = traitementController.getTraitementLinksByAnimalId(1);

        assertEquals(expectedLinks, actualLinks);
    }

    @Test
    public void testGetTraitementDetailsById() {
        Traitement expectedTraitement = new Traitement();
        expectedTraitement.setIdTraitement(1);

        when(traitementService.getTraitementDetailsById(1)).thenReturn(expectedTraitement);

        Traitement actualTraitement = traitementController.getTraitementDetailsById(1);

        assertEquals(expectedTraitement, actualTraitement);
    }

    @Test
    public void testAddTraitement() throws IOException {
        Traitement traitement = new Traitement();

        MultipartFile ordonnanceFile = null;

        when(traitementService.saveTraitement(traitement)).thenReturn(traitement);

        ResponseEntity<?> responseEntity = traitementController.addTraitement(ordonnanceFile, traitement);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void testGetHeuresByTraitementId() {
        Traitement traitement = new Traitement();
        List<Heure> heures = new ArrayList<>();
        traitement.setHeures(heures);

        when(traitementService.getTraitementDetailsById(1)).thenReturn(traitement);

        ResponseEntity<List<Heure>> responseEntity = traitementController.getHeuresByTraitementId(1);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(heures, responseEntity.getBody());
    }

    @Test
    public void testGetTraitementDetails() {
        Traitement expectedTraitement = new Traitement();
        expectedTraitement.setIdTraitement(1);

        when(traitementService.getTraitementDetailsById(1)).thenReturn(expectedTraitement);

        ResponseEntity<Traitement> responseEntity = traitementController.getTraitementDetails(1);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedTraitement, responseEntity.getBody());
    }

    @Test
    public void testGetTraitementsByAnimalId() {
        List<String> expectedTraitements = new ArrayList<>();
        expectedTraitements.add("traitement1");
        expectedTraitements.add("traitement2");

        when(traitementService.getTraitementsByAnimalId(1)).thenReturn(expectedTraitements);

        List<String> actualTraitements = traitementController.getTraitementsByAnimalId(1);

        assertEquals(expectedTraitements, actualTraitements);
    }

    @Test
    public void testGetTraitementById() {
        Optional<Traitement> expectedTraitement = Optional.of(new Traitement());
        expectedTraitement.get().setIdTraitement(1);

        when(traitementService.getTraitementById(1)).thenReturn(expectedTraitement);

        ResponseEntity<?> responseEntity = traitementController.getTraitementById(1);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedTraitement.get(), responseEntity.getBody());
    }

    @Test
    public void testModifierTraitement() {
        Traitement traitementModifie = new Traitement();
        traitementModifie.setIdTraitement(1);

        Optional<Traitement> updatedTraitement = Optional.of(new Traitement());
        updatedTraitement.get().setIdTraitement(1);

        when(traitementService.updateTraitement(1, traitementModifie)).thenReturn(updatedTraitement);

        ResponseEntity<?> responseEntity = traitementController.modifierTraitement(1, traitementModifie);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Traitement modifié avec succès", responseEntity.getBody());
    }

    @Test
    public void testGetTraitementsDetailsByAnimalId() {
        List<Traitement> expectedTraitements = new ArrayList<>();
        Traitement traitement1 = new Traitement();
        Traitement traitement2 = new Traitement();
        expectedTraitements.add(traitement1);
        expectedTraitements.add(traitement2);

        when(traitementService.getTraitementsDetailsByAnimalId(1)).thenReturn(expectedTraitements);

        ResponseEntity<List<Traitement>> responseEntity = traitementController.getTraitementsDetailsByAnimalId(1);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedTraitements, responseEntity.getBody());
    }
    @Test
    public void testGetTraitementDetailsNotFound() {
        when(traitementService.getTraitementDetailsById(1)).thenReturn(null);

        ResponseEntity<Traitement> responseEntity = traitementController.getTraitementDetails(1);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertEquals(null, responseEntity.getBody());
    }

    @Test
    public void testGetTraitementByIdNotFound() {
        when(traitementService.getTraitementById(1)).thenReturn(Optional.empty());

        ResponseEntity<?> responseEntity = traitementController.getTraitementById(1);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertEquals("Aucun traitement trouvé pour l'identifiant 1", responseEntity.getBody());
    }

    @Test
    public void testGetTraitementsDetailsByAnimalIdEmpty() {
        when(traitementService.getTraitementsDetailsByAnimalId(1)).thenReturn(new ArrayList<>());

        ResponseEntity<List<Traitement>> responseEntity = traitementController.getTraitementsDetailsByAnimalId(1);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertEquals(null, responseEntity.getBody());
    }
    @Test
    public void testModifierTraitementNotFound() {
        Traitement traitementModifie = new Traitement();
        traitementModifie.setIdTraitement(1);

        when(traitementService.updateTraitement(1, traitementModifie)).thenReturn(Optional.empty());

        ResponseEntity<?> responseEntity = traitementController.modifierTraitement(1, traitementModifie);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertEquals("Aucun traitement trouvé pour l'identifiant 1", responseEntity.getBody());
    }
    
    


}
