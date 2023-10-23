package com.nanterre.LoveMyPet;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.ui.Model;

import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

public class ControleurTest {
  @Test
  public void testCalculate() {
    Controleur ctrl = new Controleur ();
    Model model = mock(Model.class);
    
    //Entrées de test
    int a = 1;
    int b = 2;
    
    //Appel de la méthode a tester
    String result = ctrl.calculate(a, b, model);
    
    //On verifie le resultat retourné
    assertEquals("Calculer", result);
  }

}