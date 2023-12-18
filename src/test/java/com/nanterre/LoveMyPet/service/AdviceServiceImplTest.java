package com.nanterre.LoveMyPet.service;


import com.nanterre.LoveMyPet.model.Advice;
import com.nanterre.LoveMyPet.model.LikeDislike;
import com.nanterre.LoveMyPet.model.Person;
import com.nanterre.LoveMyPet.repository.AdviceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AdviceServiceImplTest {

    @Mock
    private AdviceRepository adviceRepository;

    @InjectMocks
    private AnimalServiceImpl.AdviceServiceImpl adviceService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllAdviceReferences() {
        // Mocking the repository response
        List<Advice> adviceList = Arrays.asList(
                new Advice(1, new Person(), "Text1", "Image1", Arrays.asList(new LikeDislike())),
                new Advice(2, new Person(), "Text2", "Image2", Arrays.asList(new LikeDislike()))
        );
        when(adviceRepository.findAll()).thenReturn(adviceList);

        // Testing the service method
        List<String> references = adviceService.getAllAdviceReferences();

        // Verifying interactions
        verify(adviceRepository, times(1)).findAll();

        // Assertions
        assertEquals(2, references.size());
        assertEquals("advice/1", references.get(0));
        assertEquals("advice/2", references.get(1));
    }

    @Test
    void getAdviceDetailsWhenAdviceNotFound() {
        // Mocking the repository response
        when(adviceRepository.findById(1)).thenReturn(Optional.empty());

        // Testing the service method for a non-existing advice
        Map<String, Object> adviceDetails = adviceService.getAdviceDetails(1);

        // Verifying interactions
        verify(adviceRepository, times(1)).findById(1);

        // Assertions
        assertNull(adviceDetails);
    }
}
