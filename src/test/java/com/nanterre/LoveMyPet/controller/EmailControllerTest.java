package com.nanterre.LoveMyPet.controller;

import com.nanterre.LoveMyPet.service.EmailSenderService;
import com.nanterre.LoveMyPet.service.FeedingScheduleService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class EmailControllerTest {

    @Mock
    private EmailSenderService emailSenderService;

    @Mock
    private FeedingScheduleService feedingScheduleService;

    @InjectMocks
    private EmailController emailController;

    @Test
    void testSendEmail() {
        // Simulez le comportement du service d'envoi d'e-mail
        doNothing().when(emailSenderService).sendSimpleEmail(anyString(), anyString(), anyString());

        // Appelez la méthode du contrôleur
        String result = emailController.sendEmail();

        // Vérifiez le résultat
        assertEquals("Email sent successfully!", result);

        // Vérifiez si la méthode du service d'envoi d'e-mail a été appelée
        verify(emailSenderService, times(1)).sendSimpleEmail(anyString(), anyString(), anyString());
    }

}
