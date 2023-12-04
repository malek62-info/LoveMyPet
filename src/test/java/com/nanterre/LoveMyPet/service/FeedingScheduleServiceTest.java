package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.Animal;
import com.nanterre.LoveMyPet.model.FeedingSchedule;
import com.nanterre.LoveMyPet.model.FeedingTime;
import com.nanterre.LoveMyPet.repository.AnimalRepository;
import com.nanterre.LoveMyPet.repository.FeedingScheduleRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class FeedingScheduleServiceTest {

    @Mock
    private FeedingScheduleRepository feedingScheduleRepository;

    @Mock
    private AnimalRepository animalRepository;

    @InjectMocks
    private FeedingScheduleServiceImpl feedingScheduleService;


    @Test
    void testGetFeedingTimesForAnimalWithoutSchedule() {
        // Configurez le comportement attendu pour les appels de méthode
        when(feedingScheduleRepository.findByAnimalId(anyLong())).thenReturn(Optional.empty());

        // Exécutez la méthode à tester
        List<LocalTime> feedingTimes = feedingScheduleService.getFeedingTimesForAnimal(1L);

        // Vérifiez si les résultats sont conformes aux attentes
        assertTrue(feedingTimes.isEmpty());
    }
}
