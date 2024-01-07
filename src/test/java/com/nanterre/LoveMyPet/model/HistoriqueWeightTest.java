package com.nanterre.LoveMyPet.model;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HistoriqueWeightTest {

    @Test
    void testGettersAndSetters() {
        // Créer un objet HistoriqueWeight factice pour les tests
        HistoriqueWeight historiqueWeight = new HistoriqueWeight();
        historiqueWeight.setId(1);
        historiqueWeight.setAnimal(new Animal());
        historiqueWeight.setWeight(10.5);
        historiqueWeight.setDate(new Date());

        // Utiliser les méthodes getters pour obtenir les valeurs
        Integer id = historiqueWeight.getId();
        Animal animal = historiqueWeight.getAnimal();
        Double weight = historiqueWeight.getWeight();
        Date date = historiqueWeight.getDate();

        // Vérifier que les valeurs sont celles attendues
        assertEquals(1, id);
        assertEquals(Animal.class, animal.getClass());
        assertEquals(10.5, weight);
        assertEquals(Date.class, date.getClass());
    }
}
