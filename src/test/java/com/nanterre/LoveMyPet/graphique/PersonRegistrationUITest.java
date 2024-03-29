/*
package com.nanterre.LoveMyPet.graphique;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonRegistrationUITest {

    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        // Spécifiez le chemin vers le pilote Chrome
        System.setProperty("webdriver.chrome.driver", "chemin/vers/chromedriver");

        // Initialiser le pilote Chrome
        driver = new ChromeDriver();
    }

    @Test
    public void testPersonRegistration() {
        // Accéder à la page d'enregistrement de la personne
        driver.get("http://localhost:8080/register");

        // Remplir les champs du formulaire
        WebElement firstNameInput = driver.findElement(By.name("firstName"));
        firstNameInput.sendKeys("John");

        WebElement lastNameInput = driver.findElement(By.name("lastName"));
        lastNameInput.sendKeys("Doe");

        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("john.doe@example.com");

        WebElement phoneNumberInput = driver.findElement(By.name("phoneNumber"));
        phoneNumberInput.sendKeys("1234567890");

        WebElement addressInput = driver.findElement(By.name("address"));
        addressInput.sendKeys("123 Main Street");

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("password123");

        // Soumettre le formulaire
        WebElement registerButton = driver.findElement(By.cssSelector(".button input[type='submit']"));
        registerButton.click();

        // Attendre la redirection vers la page de connexion
        assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @AfterAll
    public static void tearDown() {
        // Fermer le navigateur une fois les tests terminés
        driver.quit();
    }
}
*/