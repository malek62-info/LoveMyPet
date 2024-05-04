package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.AnimalPerdu;
import com.nanterre.LoveMyPet.repository.AnimalPerduRepository;
import com.nanterre.LoveMyPet.service.AnimalPerduServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class AnimalPerduServiceImplTest {

    @Mock
    private AnimalPerduRepository animalPerduRepository;

    @InjectMocks
    private AnimalPerduServiceImpl animalPerduService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    

    @Test
    void testFindAnimalsLostByPersonId() {
        Integer idPerson = 1;
        List<AnimalPerdu> expected = Arrays.asList(new AnimalPerdu(), new AnimalPerdu());
        when(animalPerduRepository.findAllByPersonId(idPerson)).thenReturn(expected);
        List<AnimalPerdu> actual = animalPerduService.findAnimalsLostByPersonId(idPerson);
        assertEquals(expected, actual);
        verify(animalPerduRepository, times(1)).findAllByPersonId(idPerson);
    }

    @Test
    void testSupprimerAnimalPerdu() {
        Integer idAnimal = 1;
        animalPerduService.supprimerAnimalPerdu(idAnimal);
        verify(animalPerduRepository, times(1)).deleteByIdAnimal(idAnimal);
    }
}
