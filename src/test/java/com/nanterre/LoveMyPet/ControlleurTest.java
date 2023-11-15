package com.nanterre.LoveMyPet;
import com.nanterre.LoveMyPet.controller.Controlleur;
import org.junit.Test;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

import static org.junit.Assert.assertEquals;

public class ControlleurTest {

    @Test
    public void testShowPage() {
        Controlleur controller = new Controlleur();
        Model model = new BindingAwareModelMap();

        String viewName = controller.showpage();

        // Vérifiez que la méthode renvoie la vue attendue
        assertEquals("AddPersonne", viewName);

        // Vérifiez que le modèle contient les attributs nécessaires (si applicable)
        // Exemple : assertEquals(expectedValue, model.getAttribute("attributName"));
    }

    @Test
    public void testShowPageAddAnimal() {
        Controlleur controller = new Controlleur();
        Model model = new BindingAwareModelMap();

        String viewName = controller.showpageaddAnimal();

        // Vérifiez que la méthode renvoie la vue attendue
        assertEquals("AddAnimal", viewName);

        // Vérifiez que le modèle contient les attributs nécessaires (si applicable)
        // Exemple : assertEquals(expectedValue, model.getAttribute("attributName"));
    }

    @Test
    public void testShowPageLogin() {
        Controlleur controller = new Controlleur();
        Model model = new BindingAwareModelMap();

        String viewName = controller.showpagelogin();

        // Vérifiez que la méthode renvoie la vue attendue
        assertEquals("login", viewName);

        // Vérifiez que le modèle contient les attributs nécessaires (si applicable)
        // Exemple : assertEquals(expectedValue, model.getAttribute("attributName"));
    }
}
