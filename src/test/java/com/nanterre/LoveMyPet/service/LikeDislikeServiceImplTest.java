package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.Advice;
import com.nanterre.LoveMyPet.model.LikeDislike;
import com.nanterre.LoveMyPet.model.Person;
import com.nanterre.LoveMyPet.repository.AdviceRepository;
import com.nanterre.LoveMyPet.repository.LikeDislikeRepository;
import com.nanterre.LoveMyPet.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class LikeDislikeServiceImplTest {

    @Mock
    private LikeDislikeRepository likeDislikeRepository;

    @Mock
    private AdviceRepository adviceRepository;

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private CandidatureService.LikeDislikeServiceImpl likeDislikeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddLike() {
        // Mocking the repository responses
        Advice advice = new Advice();
        when(adviceRepository.findById(anyInt())).thenReturn(Optional.of(advice));

        Person person = new Person();
        when(personRepository.findById(anyInt())).thenReturn(Optional.of(person));

        when(likeDislikeRepository.findByAdviceAndPerson(any(), any())).thenReturn(null);

        // Testing the service method
        assertDoesNotThrow(() -> likeDislikeService.addLike(1, 1, true));

        // Verifying interactions
        verify(adviceRepository, times(1)).findById(1);
        verify(personRepository, times(1)).findById(1);
        verify(likeDislikeRepository, times(1)).findByAdviceAndPerson(advice, person);
        verify(likeDislikeRepository, times(1)).save(any(LikeDislike.class));
    }

    @Test
    void testAddDislike() {
        // Mocking the repository responses
        Advice advice = new Advice();
        when(adviceRepository.findById(anyInt())).thenReturn(Optional.of(advice));

        Person person = new Person();
        when(personRepository.findById(anyInt())).thenReturn(Optional.of(person));

        when(likeDislikeRepository.findByAdviceAndPerson(any(), any())).thenReturn(null);

        // Testing the service method
        assertDoesNotThrow(() -> likeDislikeService.addDislike(1, 1, false));

        // Verifying interactions
        verify(adviceRepository, times(1)).findById(1);
        verify(personRepository, times(1)).findById(1);
        verify(likeDislikeRepository, times(1)).findByAdviceAndPerson(advice, person);
        verify(likeDislikeRepository, times(1)).save(any(LikeDislike.class));
    }


    @Test
    void testAddDislikeWhenInteractionExists() {
        // Mocking the repository responses
        Advice advice = new Advice();
        when(adviceRepository.findById(anyInt())).thenReturn(Optional.of(advice));

        Person person = new Person();
        when(personRepository.findById(anyInt())).thenReturn(Optional.of(person));

        LikeDislike existingInteraction = new LikeDislike();
        when(likeDislikeRepository.findByAdviceAndPerson(any(), any())).thenReturn(existingInteraction);

        // Testing the service method
        assertDoesNotThrow(() -> likeDislikeService.addDislike(1, 1, false));

        // Verifying interactions
        verify(adviceRepository, times(1)).findById(1);
        verify(personRepository, times(1)).findById(1);
        verify(likeDislikeRepository, times(1)).findByAdviceAndPerson(advice, person);
        verify(likeDislikeRepository, times(0)).save(any(LikeDislike.class));
    }

    @Test
    void testAddLikeWithInvalidAdviceId() {
        // Mocking the repository response
        when(adviceRepository.findById(anyInt())).thenReturn(Optional.empty());

        // Testing the service method
        assertThrows(ResourceNotFoundException.class, () -> likeDislikeService.addLike(1, 1, true));

        // Verifying interactions
        verify(adviceRepository, times(1)).findById(1);
        verify(personRepository, times(0)).findById(anyInt());
        verify(likeDislikeRepository, times(0)).findByAdviceAndPerson(any(), any());
        verify(likeDislikeRepository, times(0)).save(any(LikeDislike.class));
    }

    @Test
    void testAddLikeWithInvalidPersonId() {
        // Mocking the repository responses
        when(adviceRepository.findById(anyInt())).thenReturn(Optional.of(new Advice()));
        when(personRepository.findById(anyInt())).thenReturn(Optional.empty());

        // Testing the service method
        assertThrows(ResourceNotFoundException.class, () -> likeDislikeService.addLike(1, 1, true));

        // Verifying interactions
        verify(adviceRepository, times(1)).findById(1);
        verify(personRepository, times(1)).findById(1);
        verify(likeDislikeRepository, times(0)).findByAdviceAndPerson(any(), any());
        verify(likeDislikeRepository, times(0)).save(any(LikeDislike.class));
    }

    // Add more test cases as needed

}
