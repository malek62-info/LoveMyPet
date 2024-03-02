package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.repository.EvenementRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class ScheduledEventServiceTest {

    @Mock
    private EvenementRepository evenementRepository;

    @Mock
    private EmailSenderService emailSenderService;

    @InjectMocks
    private ScheduledEventService scheduledEventService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testEnvoyerEmailsRappelEvenements() {
        // Création de données fictives pour simuler les résultats de la requête du repository
        List<Object[]> fakeResults = fakeRepositoryResults();

        // Simuler le comportement du repository pour renvoyer des résultats fictifs
        when(evenementRepository.findEmailsAndEventDetailsForReminders()).thenReturn(fakeResults);

        // Appeler la méthode à tester
        scheduledEventService.envoyerEmailsRappelEvenements();

        // Vérifier que la méthode d'envoi d'e-mail a été appelée pour chaque résultat du repository
        for (Object[] result : fakeResults) {
            String email = (String) result[0];
            String firstName = (String) result[1];
            String lastName = (String) result[2];
            String eventName = (String) result[3];
            String eventPlace = (String) result[4];
            verify(emailSenderService, times(1)).sendHtmlEmail(email, "Rappel pour l'événement: " + eventName, generateEmailBody(firstName, lastName, eventName, eventPlace));
        }
    }

    // Méthode utilitaire pour générer des données fictives pour le repository
    private List<Object[]> fakeRepositoryResults() {
        List<Object[]> fakeResults = new ArrayList<>();
        // Ajoutez autant de données fictives que nécessaire pour vos tests
        fakeResults.add(new Object[]{"user1@example.com", "John", "Doe", "Birthday Party", "123 Main St"});
        fakeResults.add(new Object[]{"user2@example.com", "Jane", "Smith", "Training Session", "456 Elm St"});
        return fakeResults;
    }

    // Méthode utilitaire pour générer le corps de l'e-mail
    private String generateEmailBody(String firstName, String lastName, String eventName, String eventPlace) {
        return "<html>"
                + "<body style=\"font-family: Arial, sans-serif;\">"
                + "<h2 style=\"color: #008080;\">Rappel pour l'événement: " + eventName + "</h2>"
                + "<p>Bonjour " + firstName + " " + lastName + ",</p>"
                + "<p>Ceci est un rappel pour l'événement \"" + eventName + "\" prévu à l'endroit \"" + eventPlace + "\".</p>"
                + "<p>N'oubliez pas d'y participer!</p>"
                + "<br>"
                + "<img src=\"https://i.ibb.co/C89P4JY/logo.png\" alt=\"LoveMyPet Logo\" width=\"200px\" style=\"border-radius: 10px;\">"
                + "<br><br>"
                + "<p style=\"color: #008080;\">Cordialement,<br>Votre Application LoveMyPet</p>"
                + "</body>"
                + "</html>";
    }
}
