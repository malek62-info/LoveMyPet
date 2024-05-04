package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.AnimalVu;
import com.nanterre.LoveMyPet.repository.animalVuRepository;
import com.nanterre.LoveMyPet.service.AnimalVuServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class AnimalVuServiceImplTest {

    @Mock
    private animalVuRepository animalVuRepository;

    @InjectMocks
    private AnimalVuServiceImpl animalVuService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testAjouterAnimalVu() {
        AnimalVu animalVu = new AnimalVu();
        animalVuService.ajouterAnimalVu(animalVu);
        verify(animalVuRepository, times(1)).save(animalVu);
    }

    @Test
    void testGetAnimalCoordsById() {
        Integer idAnimal = 1;
        List<AnimalVu> expected = Arrays.asList(new AnimalVu(), new AnimalVu());
        when(animalVuRepository.findAllByidAnimal(idAnimal)).thenReturn(expected);
        List<AnimalVu> actual = animalVuService.getAnimalCoordsById(idAnimal);
        assertEquals(expected, actual);
        verify(animalVuRepository, times(1)).findAllByidAnimal(idAnimal);
    }

    @Test
    void testSupprimerAnimalVu() {
        Integer idAnimal = 1;
        animalVuService.supprimerAnimalVu(idAnimal);
        verify(animalVuRepository, times(1)).deleteByIdAnimal(idAnimal);
    }
}
