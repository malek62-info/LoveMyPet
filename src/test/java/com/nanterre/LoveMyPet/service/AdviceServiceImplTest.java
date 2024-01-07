package com.nanterre.LoveMyPet.service;


import com.nanterre.LoveMyPet.model.Advice;
import com.nanterre.LoveMyPet.model.Comment;
import com.nanterre.LoveMyPet.model.LikeDislike;
import com.nanterre.LoveMyPet.model.Person;
import com.nanterre.LoveMyPet.repository.AdviceRepository;
import com.nanterre.LoveMyPet.repository.CommentRepository;

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
    @Mock
    private CommentRepository commentRepository;

    @InjectMocks
    private AdviceServiceImpl adviceService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllAdviceReferences() {
        // Mocking the repository response
        List<Advice> adviceList = Arrays.asList(
                new Advice(1, new Person(), "Text1", "Image1", Arrays.asList(new LikeDislike()), null),
                new Advice(2, new Person(), "Text2", "Image2", Arrays.asList(new LikeDislike()),null)
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
    

    @Test
    void getCommentLinksByAdviceId() {
        // Créer un objet d'avis factice pour les tests
        Advice advice = new Advice();
        advice.setAdviceId(1);

        // Créer des commentaires factices
        Comment comment1 = new Comment();
        comment1.setCommentId(101);
        Comment comment2 = new Comment();
        comment2.setCommentId(102);
        advice.setComments(Arrays.asList(comment1, comment2));

        // Simuler le comportement du repository lorsqu'on recherche un avis par ID
        when(adviceRepository.findById(1)).thenReturn(Optional.of(advice));

        // Appeler la méthode à tester
        List<String> commentLinks = adviceService.getCommentLinksByAdviceId(1);

        // Vérifier que la méthode findById a été appelée sur le repository d'avis
        verify(adviceRepository, times(1)).findById(1);

        // Assertions
        assertEquals(2, commentLinks.size());
        assertEquals("/advice/1/comment/101", commentLinks.get(0));
        assertEquals("/advice/1/comment/102", commentLinks.get(1));
    }

    @Test
    void getCommentDetailsByIdWhenCommentNotFound() {
        // Simuler le comportement du repository lorsqu'on recherche un commentaire par ID
        when(commentRepository.findById(1)).thenReturn(Optional.empty());

        // Appeler la méthode à tester pour un commentaire non existant
        Comment comment = adviceService.getCommentDetailsById(1);

        // Vérifier que la méthode findById a été appelée sur le repository de commentaires
        verify(commentRepository, times(1)).findById(1);

        // Assertions
        assertNull(comment);
    }

    @Test
    void getCommentsByAdviceId() {
        // Créer un objet d'avis factice pour les tests
        Advice advice = new Advice();
        advice.setAdviceId(1);

        // Créer des commentaires factices
        Comment comment1 = new Comment();
        comment1.setCommentId(101);
        Comment comment2 = new Comment();
        comment2.setCommentId(102);
        advice.setComments(Arrays.asList(comment1, comment2));

        // Simuler le comportement du repository lorsqu'on recherche un avis par ID
        when(adviceRepository.findById(1)).thenReturn(Optional.of(advice));

        // Appeler la méthode à tester
        List<Comment> comments = adviceService.getCommentsByAdviceId(1);

        // Vérifier que la méthode findById a été appelée sur le repository d'avis
        verify(adviceRepository, times(1)).findById(1);

        // Assertions
        assertEquals(2, comments.size());
        assertEquals(101, comments.get(0).getCommentId());
        assertEquals(102, comments.get(1).getCommentId());
    }
}
