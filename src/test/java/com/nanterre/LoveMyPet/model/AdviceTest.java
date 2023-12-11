package com.nanterre.LoveMyPet.model;

import com.nanterre.LoveMyPet.model.Advice;
import com.nanterre.LoveMyPet.model.Person;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AdviceTest {

    @Test
    void gettersAndSettersShouldWorkCorrectly() {
        // Création d'une instance de Person pour le test
        Person author = new Person();
        author.setIdPerson(1);

        // Création d'une instance de Advice
        Advice advice = new Advice();

        // Utilisation des setters pour définir les valeurs
        advice.setAdviceId(1);
        advice.setAuthor(author);
        advice.setTextAdvice("Test advice text");
        advice.setImageUrl("/path/to/image");

        // Utilisation des getters pour obtenir les valeurs
        Integer adviceId = advice.getAdviceId();
        Person adviceAuthor = advice.getAuthor();
        String textAdvice = advice.getTextAdvice();
        String imageUrl = advice.getImageUrl();

        // Assertions
        assertEquals(1, adviceId);
        assertEquals(author, adviceAuthor);
        assertEquals("Test advice text", textAdvice);
        assertEquals("/path/to/image", imageUrl);
    }
}

