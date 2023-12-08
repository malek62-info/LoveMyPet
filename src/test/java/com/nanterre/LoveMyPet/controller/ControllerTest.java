package com.nanterre.LoveMyPet.controller;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

public class ControllerTest {

    @InjectMocks
    private Controller controller;

    @Mock
    private ConcurrentModel model;

    public ControllerTest() {
        MockitoAnnotations.openMocks(this);
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
    public void testAlertes() {
        String result = controller.alertes();
        assertEquals("alertes", result);
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
}
