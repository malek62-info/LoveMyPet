package com.nanterre.LoveMyPet.controller;

import com.nanterre.LoveMyPet.model.ItemToDonate;
import com.nanterre.LoveMyPet.model.Person;
import com.nanterre.LoveMyPet.service.ItemToDonateServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ItemToDonateControllerTest {

    @Mock
    private ItemToDonateServiceImpl itemToDonateService;

    @InjectMocks
    private ItemToDonateController itemToDonateController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }



    @Test
    void testAddItemToDonateFailure() throws IOException {
        // Mock data
        String itemName = "Test Item";
        String description = "Test Description";
        MockMultipartFile photo = new MockMultipartFile("photo", "test-image.jpg", "image/jpeg", "some-image".getBytes());
        Integer idPerson = 1;

        // Mock service method to throw an exception
        doThrow(new RuntimeException("Test exception")).when(itemToDonateService).saveItemToDonate(any(ItemToDonate.class));

        // Perform the test
        ResponseEntity<String> response = itemToDonateController.addItemToDonate(itemName, description, photo, idPerson);

        // Verify the result
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Erreur lors de l'ajout de l'objet à donner", response.getBody());
        verify(itemToDonateService, times(1)).saveItemToDonate(any(ItemToDonate.class));
    }

    @Test
    void testGetAllItemReferences() {
        // Mock data
        List<ItemToDonate> mockItems = List.of(new ItemToDonate(), new ItemToDonate());
        when(itemToDonateService.getAllItems()).thenReturn(mockItems);

        // Perform the test
        List<String> result = itemToDonateController.getAllItemReferences();

        // Verify the result
        assertEquals(mockItems.size(), result.size());
        verify(itemToDonateService, times(1)).getAllItems();
    }

    @Test
    void testGetItemDetailsById() {
        // Mock data
        int itemId = 1;
        ItemToDonate mockItem = new ItemToDonate();
        mockItem.setId(itemId);
        when(itemToDonateService.getItemById(itemId)).thenReturn(mockItem);

        // Perform the test
        ItemToDonate result = itemToDonateController.getItemDetailsById(itemId);

        // Verify the result
        assertEquals(mockItem, result);
        verify(itemToDonateService, times(1)).getItemById(itemId);
    }

    @Test
    void testGetItemReferencesByPersonId() {
        // Mock data
        int personId = 1;
        List<ItemToDonate> mockItems = List.of(new ItemToDonate(), new ItemToDonate());
        when(itemToDonateService.getItemsByPersonId(personId)).thenReturn(mockItems);

        // Perform the test
        ResponseEntity<List<String>> result = itemToDonateController.getItemReferencesByPersonId(personId);

        // Verify the result
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(mockItems.size(), result.getBody().size());
        verify(itemToDonateService, times(1)).getItemsByPersonId(personId);
    }
}
