package com.nanterre.LoveMyPet.controller;

import com.nanterre.LoveMyPet.model.Advice;
import com.nanterre.LoveMyPet.model.Comment;
import com.nanterre.LoveMyPet.service.AdviceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class AdviceControllerTest {

    @Mock
    private AdviceService adviceService;

    @InjectMocks
    private AdviceController adviceController;

    @Test
    void addAdvice() {
        // Création d'un objet Advice pour le test
        Advice advice = new Advice();
        advice.setTextAdvice("Test advice text");

        // Création d'un MultipartFile fictif pour le test
        MultipartFile imageFile = new MockMultipartFile("image", "test-image.jpg", "image/jpeg", "fake-image".getBytes());

        // Simulation du comportement du service
        doNothing().when(adviceService).addAdvice(any(Advice.class));

        // Appel de la méthode du contrôleur
        ResponseEntity<String> response = adviceController.addAdvice(imageFile, "Test advice text", 1);

        // Assertions
        verify(adviceService, times(1)).addAdvice(any(Advice.class));
        verifyNoMoreInteractions(adviceService);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Advice added successfully", response.getBody());
    }
    @Test
    void addCommentToAdvice() {
        // Simulation du comportement du service
        doNothing().when(adviceService).addCommentToAdvice(1, "Test Comment", 2);

        // Appel de la méthode du contrôleur
        ResponseEntity<String> response = adviceController.addCommentToAdvice(1, "Test Comment", 2);

        // Assertions
        verify(adviceService, times(1)).addCommentToAdvice(1, "Test Comment", 2);
        verifyNoMoreInteractions(adviceService);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Comment added successfully", response.getBody());
    }
    @Test
    void getCommentLinksByAdviceId() {
        // Simulation du comportement du service
        when(adviceService.getCommentLinksByAdviceId(1)).thenReturn(List.of("Comment1", "Comment2"));

        // Appel de la méthode du contrôleur
        List<String> commentLinks = adviceController.getCommentLinksByAdviceId(1);

        // Assertions
        verify(adviceService, times(1)).getCommentLinksByAdviceId(1);
        verifyNoMoreInteractions(adviceService);

        assertEquals(2, commentLinks.size());
        assertEquals("Comment1", commentLinks.get(0));
        assertEquals("Comment2", commentLinks.get(1));
    }
    @Test
    void testGetCommentDetailsById() {
        // Création d'un objet Comment pour le test
        Comment comment = new Comment();
        comment.setCommentId(1);
        comment.setText("Test comment text");

        // Mock du service pour simuler le comportement
        when(adviceService.getCommentDetailsById(1)).thenReturn(comment);

        // Appel de la méthode du contrôleur
        ResponseEntity<Comment> response = adviceController.getCommentDetailsById(1);

        // Assertions
        verify(adviceService, times(1)).getCommentDetailsById(1);
        verifyNoMoreInteractions(adviceService);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(comment, response.getBody());
    }

    @Test
    void testGetCommentDetailsById_NotFound() {
        // Mock du service pour simuler le comportement
        when(adviceService.getCommentDetailsById(1)).thenReturn(null);

        // Appel de la méthode du contrôleur
        ResponseEntity<Comment> response = adviceController.getCommentDetailsById(1);

        // Assertions
        verify(adviceService, times(1)).getCommentDetailsById(1);
        verifyNoMoreInteractions(adviceService);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(null, response.getBody());
    }
    @Test
    void testGetCommentsByAdviceId() {
        // Création d'une liste de commentaires pour le test
        List<Comment> comments = new ArrayList<>();
        Comment comment1 = new Comment();
        Comment comment2 = new Comment();
        comments.add(comment1);
        comments.add(comment2);

        // Mock du service pour simuler le comportement
        when(adviceService.getCommentsByAdviceId(1)).thenReturn(comments);

        // Appel de la méthode du contrôleur
        ResponseEntity<List<Comment>> response = adviceController.getCommentsByAdviceId(1);

        // Assertions
        verify(adviceService, times(1)).getCommentsByAdviceId(1);
        verifyNoMoreInteractions(adviceService);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(comments, response.getBody());
    }

    
}

