package com.nanterre.LoveMyPet.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommentTest {

    @Test
    void testGettersAndSetters() {
        // Créer un objet Comment factice pour les tests
        Comment comment = new Comment();
        comment.setCommentId(1);
        comment.setAdvice(new Advice());
        comment.setCommenter(new Person());
        comment.setText("Ceci est un commentaire");

        // Utiliser les méthodes getters pour obtenir les valeurs
        Integer commentId = comment.getCommentId();
        Advice advice = comment.getAdvice();
        Person commenter = comment.getCommenter();
        String text = comment.getText();

        // Vérifier que les valeurs sont celles attendues
        assertEquals(1, commentId);
        assertEquals(Advice.class, advice.getClass());
        assertEquals(Person.class, commenter.getClass());
        assertEquals("Ceci est un commentaire", text);
    }
}
