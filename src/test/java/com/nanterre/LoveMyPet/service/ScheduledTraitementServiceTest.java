package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.repository.TraitementRepository;
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
public class ScheduledTraitementServiceTest {

    @Mock
    private EmailSenderService emailSenderService;

    @Mock
    private TraitementRepository traitementRepository;

    @InjectMocks
    private ScheduledTraitementService scheduledTraitementService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSendEmailToUsersWithScheduledTraitement() {
        // Création de données fictives pour simuler les résultats du repository
        List<Object[]> fakeResults = fakeRepositoryResults();

        // Simuler le comportement du repository pour renvoyer des résultats fictifs
        when(traitementRepository.findEmailAndTreatmentDetails()).thenReturn(fakeResults);

        // Appeler la méthode à tester
        scheduledTraitementService.sendEmailToUsersWithScheduledTraitement();

        // Vérifier que la méthode d'envoi d'e-mail a été appelée pour chaque résultat du repository
        for (Object[] traitementDetail : fakeResults) {
            String userEmail = (String) traitementDetail[0];
            String nom_medicament = (String) traitementDetail[1];
            String nom_traitement = (String) traitementDetail[2];
            String date_traitement = (String) traitementDetail[3];
            String nom_animal = (String) traitementDetail[4];
            String heure_traitement = (String) traitementDetail[5];

            verify(emailSenderService, times(1)).sendHtmlEmail(eq(userEmail), anyString(), anyString());
        }
    }

    // Méthode utilitaire pour générer des données fictives pour le repository
    private List<Object[]> fakeRepositoryResults() {
        List<Object[]> fakeResults = new ArrayList<>();
        // Ajoutez autant de données fictives que nécessaire pour vos tests
        fakeResults.add(new Object[]{"user1@example.com", "Medicament1", "Traitement1", "2024-03-01", "Animal1", "08:00:00"});
        fakeResults.add(new Object[]{"user2@example.com", "Medicament2", "Traitement2", "2024-03-01", "Animal2", "12:00:00"});
        return fakeResults;
    }
}
