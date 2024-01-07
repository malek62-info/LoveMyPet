package com.nanterre.LoveMyPet.controller;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

public class ControllerTest {

    @InjectMocks
    private Controller controller;

    @Mock
    private Model model;

    public ControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testShowAdoptionPage() {
        String result = controller.showAdoptionPage(model);
        assertEquals("adoption", result);
    }

    @Test
    public void testShowAnimals() {
        String result = controller.showAnimals(model);
        assertEquals("mesanimaux", result);
    }

    @Test
    public void testShowCandidatureByAnimalId() {
        String result = controller.showCandidatureByAnimalId(model);
        assertEquals("candidatureadoption", result);
    }

    @Test
    public void testShowVaccinations() {
        String result = controller.showVaccinations(model);
        assertEquals("suivi", result);
    }

    @Test
    public void testShowCandidatures() {
        String result = controller.showCandidatures(model);
        assertEquals("mescandidatures", result);
    }

    @Test
    public void testShowpage() {
        String result = controller.showpage();
        assertEquals("AddPersonne", result);
    }

    @Test
    public void testShowpageaddAnimal() {
        String result = controller.showpageaddAnimal();
        assertEquals("AddAnimal", result);
    }

    @Test
    public void testShowpagelogin() {
        String result = controller.showpagelogin();
        assertEquals("login", result);
    }

    @Test
    public void testHomePage() {
        String result = controller.homePage();
        assertEquals("home", result);
    }

    @Test
    public void testProfile() {
        String result = controller.profile();
        assertEquals("profile", result);
    }

    @Test
    public void testInfoAnimal() {
        String result = controller.infoAnimal();
        assertEquals("infoanimal", result);
    }

    @Test
    public void testTimeChoiceAnimal() {
        String result = controller.TimeChoiceAnimal();
        assertEquals("TimeChoiceAnimal.html", result);
    }

    @Test
    public void testMap() {
        String result = controller.map();
        assertEquals("Veterinaires", result);
    }

    @Test
    public void testParc() {
        String result = controller.parc();
        assertEquals("parc", result);
    }

    @Test
    public void testDonate() {
        String result = controller.donate();
        assertEquals("Map", result);
    }

    @Test
    public void testLostAnimals() {
        String result = controller.LostAnimals();
        assertEquals("LostAnimals", result);
    }

    @Test
    public void testEnregistrerLostAnimal() {
        String result = controller.EnregistrerLostAnimal();
        assertEquals("EnregistrerLostAnimal", result);
    }

    @Test
    public void testListLostAnimal() {
        String result = controller.ListLostAnimal();
        assertEquals("ListLostAnimal", result);
    }

    @Test
    public void testPublication() {
        String result = controller.publication();
        assertEquals("publications", result);
    }

    @Test
    public void testAdvice() {
        String result = controller.Advice();
        assertEquals("AddAdvice", result);
    }

    @Test
    public void testAddItems() {
        String result = controller.additems();
        assertEquals("additems", result);
    }

    @Test
    public void testItemsToDonate() {
        String result = controller.itemstodonate();
        assertEquals("itemstodonate", result);
    }

    @Test
    public void testMesDonations() {
        String result = controller.mesdonations();
        assertEquals("mesdonations", result);
    }

    @Test
    public void testItemsPage() {
        String result = controller.itemspage();
        assertEquals("itemspage", result);
    }
}
