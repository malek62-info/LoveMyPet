package com.nanterre.LoveMyPet.controller;

import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ControllerTest {

    @Test
    void testShowAdoptionPage() {
        Controller controller = new Controller();
        Model model = null; // Utilisez un mock pour Model si nécessaire

        String result = controller.showAdoptionPage(model);

        assertEquals("adoption", result);
    }

    @Test
    void testShowAnimals() {
        Controller controller = new Controller();
        Model model = null; // Utilisez un mock pour Model si nécessaire

        String result = controller.showAnimals(model);

        assertEquals("mesanimaux", result);
    }

    @Test
    void testShowCandidatureByAnimalId() {
        Controller controller = new Controller();
        Model model = null; // Utilisez un mock pour Model si nécessaire

        String result = controller.showCandidatureByAnimalId(model);

        assertEquals("candidatureadoption", result);
    }

    @Test
    void testShowVaccinations() {
        Controller controller = new Controller();
        Model model = null; // Utilisez un mock pour Model si nécessaire

        String result = controller.showVaccinations(model);

        assertEquals("suivi", result);
    }

    @Test
    void testSuivicomplet() {
        Controller controller = new Controller();
        Model model = null; // Utilisez un mock pour Model si nécessaire

        String result = controller.suivicomplet(model);

        assertEquals("suivicomplet", result);
    }

    @Test
    void testShowCandidatures() {
        Controller controller = new Controller();
        Model model = null; // Utilisez un mock pour Model si nécessaire

        String result = controller.showCandidatures(model);

        assertEquals("mescandidatures", result);
    }

    @Test
    void testShowpage() {
        Controller controller = new Controller();

        String result = controller.showpage();

        assertEquals("AddPersonne", result);
    }

    @Test
    void testShowpageaddAnimal() {
        Controller controller = new Controller();

        String result = controller.showpageaddAnimal();

        assertEquals("AddAnimal", result);
    }

    // Ajoute d'autres tests similaires pour les autres méthodes du contrôleur

    // ... (Tests précédents)

    @Test
    void testShowpagelogin() {
        Controller controller = new Controller();

        String result = controller.showpagelogin();

        assertEquals("login", result);
    }

    @Test
    void testHomePage() {
        Controller controller = new Controller();

        String result = controller.homePage();

        assertEquals("home", result);
    }

    @Test
    void testProfile() {
        Controller controller = new Controller();

        String result = controller.profile();

        assertEquals("profile", result);
    }

    @Test
    void testInfoAnimal() {
        Controller controller = new Controller();

        String result = controller.infoAnimal();

        assertEquals("infoanimal", result);
    }

    @Test
    void testTimeChoiceAnimal() {
        Controller controller = new Controller();

        String result = controller.TimeChoiceAnimal();

        assertEquals("TimeChoiceAnimal.html", result);
    }

    @Test
    void testAlertes_new() {
        Controller controller = new Controller();

        String result = controller.alertes_new();

        assertEquals("alertes_new", result);
    }

    @Test
    void testMap() {
        Controller controller = new Controller();

        String result = controller.map();

        assertEquals("Veterinaires", result);
    }

    @Test
    void testParc() {
        Controller controller = new Controller();

        String result = controller.parc();

        assertEquals("parc", result);
    }

    @Test
    void testDonate() {
        Controller controller = new Controller();

        String result = controller.donate();

        assertEquals("Map", result);
    }

    @Test
    void testLostAnimals() {
        Controller controller = new Controller();

        String result = controller.LostAnimals();

        assertEquals("LostAnimals", result);
    }

    @Test
    void testEnregistrerLostAnimal() {
        Controller controller = new Controller();

        String result = controller.EnregistrerLostAnimal();

        assertEquals("EnregistrerLostAnimal", result);
    }

    @Test
    void testListLostAnimal() {
        Controller controller = new Controller();

        String result = controller.ListLostAnimal();

        assertEquals("ListLostAnimal", result);
    }

    @Test
    void testHistoriqueWeightGraph() {
        Controller controller = new Controller();

        String result = controller.HistoriqueWeightGraph();

        assertEquals("graphePoids", result);
    }

    @Test
    void testPublication() {
        Controller controller = new Controller();

        String result = controller.publication();

        assertEquals("publications", result);
    }

    @Test
    void testAdvice() {
        Controller controller = new Controller();

        String result = controller.Advice();

        assertEquals("AddAdvice", result);
    }
}
