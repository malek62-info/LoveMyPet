package com.nanterre.LoveMyPet.service;
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
public class ScheduledEmailServiceTest {

    @Mock
    private EmailSenderService emailSenderService;

    @Mock
    private FeedingTimeServiceImpl feedingTimeService;

    @InjectMocks
    private ScheduledEmailService scheduledEmailService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSendEmailToUsersWithCurrentFeedingTime() {
        // Simuler le comportement du service de temps de nourrissage pour renvoyer des détails fictifs
        // (Note: vous devrez ajuster ces valeurs pour correspondre aux attentes de votre test)
        when(feedingTimeService.getInfosCurrentFeedingTimes()).thenReturn(fakeFeedingTimeDetails());

        // Appeler la méthode à tester
        scheduledEmailService.sendEmailToUsersWithCurrentFeedingTime();

        // Vérifier que la méthode d'envoi d'e-mail a été appelée une fois pour chaque détail de temps de nourrissage
        verify(emailSenderService, times(2)).sendHtmlEmail(anyString(), anyString(), anyString());
    }

    // Méthode utilitaire pour simuler des détails de temps de nourrissage fictifs
    private List<Object[]> fakeFeedingTimeDetails() {
        // Vous pouvez créer des détails fictifs pour simuler les résultats attendus du service de temps de nourrissage
        // Par exemple:
        List<Object[]> details = new ArrayList<>();
        Object[] detail1 = {"user1@example.com", "John Doe", 1, 1, "Max", "08:00:00", 1};
        Object[] detail2 = {"user2@example.com", "Jane Smith", 2, 2, "Whiskers", "12:00:00", 2};
        details.add(detail1);
        details.add(detail2);
        return details;
    }
}
