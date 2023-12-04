package com.nanterre.LoveMyPet.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import jakarta.mail.MessagingException;


import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmailSenderServiceTest {

    @Mock
    private JavaMailSender mailSender;

    @InjectMocks
    private EmailSenderService emailSenderService;

    @Test
    void testSendSimpleEmail() {
        // Données de test
        String toEmail = "recipient@example.com";
        String subject = "Test Subject";
        String body = "Test Body";

        // Configuration du simulateur
        doNothing().when(mailSender).send(any(SimpleMailMessage.class));

        // Exécution de la méthode à tester
        emailSenderService.sendSimpleEmail(toEmail, subject, body);

        // Vérification des interactions
        verify(mailSender, times(1)).send(any(SimpleMailMessage.class));
    }

}
