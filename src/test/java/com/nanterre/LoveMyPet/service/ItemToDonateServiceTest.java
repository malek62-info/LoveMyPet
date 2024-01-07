package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.ItemToDonate;
import com.nanterre.LoveMyPet.repository.ItemToDonateRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ItemToDonateServiceTest {

    @Mock
    private ItemToDonateRepository itemToDonateRepository;

    @InjectMocks
    private ItemToDonateServiceImpl itemToDonateService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveItemToDonate() {
        // Arrange
        ItemToDonate itemToDonate = new ItemToDonate();

        // Act
        itemToDonateService.saveItemToDonate(itemToDonate);

        // Assert
        verify(itemToDonateRepository, times(1)).save(itemToDonate);
    }

    @Test
    void testGetAllItems() {
        // Arrange
        List<ItemToDonate> expectedItems = Arrays.asList(new ItemToDonate(), new ItemToDonate());
        when(itemToDonateRepository.findAll()).thenReturn(expectedItems);

        // Act
        List<ItemToDonate> result = itemToDonateService.getAllItems();

        // Assert
        assertEquals(expectedItems.size(), result.size());
        verify(itemToDonateRepository, times(1)).findAll();
    }

    @Test
    void testGetItemById() {
        // Arrange
        Integer itemId = 1;
        ItemToDonate expectedItem = new ItemToDonate();
        when(itemToDonateRepository.findById(itemId)).thenReturn(Optional.of(expectedItem));

        // Act
        ItemToDonate result = itemToDonateService.getItemById(itemId);

        // Assert
        assertEquals(expectedItem, result);
        verify(itemToDonateRepository, times(1)).findById(itemId);
    }

    @Test
    void testGetItemsByPersonId() {
        // Arrange
        Integer personId = 1;
        List<ItemToDonate> expectedItems = Arrays.asList(new ItemToDonate(), new ItemToDonate());
        when(itemToDonateRepository.findByDonatingPerson_IdPerson(personId)).thenReturn(expectedItems);

        // Act
        List<ItemToDonate> result = itemToDonateService.getItemsByPersonId(personId);

        // Assert
        assertEquals(expectedItems.size(), result.size());
        verify(itemToDonateRepository, times(1)).findByDonatingPerson_IdPerson(personId);
    }
}
