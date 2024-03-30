package com.nanterre.LoveMyPet.controller;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
// import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;
import com.google.api.services.calendar.model.Events;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpHeaders;

@Controller
@RequestMapping("/google")
public class GoogleCalendarController {

    private static final String APPLICATION_NAME = "LoveMyPet Calendar";
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens";
    private static final List<String> SCOPES = Collections.singletonList(CalendarScopes.CALENDAR);
    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";
    private static final String API_KEY = "AIzaSyDUcL-2rxDJcVwbbEd8tWaO51GcArgjcmY"; // Clé API

    private Credential credential;
    private Calendar service;

    @PostConstruct
    public void init() {
        try {
            final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            InputStream in = getClass().getResourceAsStream(CREDENTIALS_FILE_PATH);
            if (in == null) {
                throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
            }
            GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
            GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                    HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                    .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                    .setAccessType("offline")
                    .build();
            LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
            credential = new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
            service = new Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
                    .setApplicationName(APPLICATION_NAME)
                    .build();
        } catch (IOException | GeneralSecurityException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/auth")
    public ResponseEntity<?> authenticateWithGoogle() throws GeneralSecurityException {
        try {
            DateTime now = new DateTime(System.currentTimeMillis());
            Events events = service.events().list("primary")
                    .setMaxResults(10)
                    .setTimeMin(now)
                    .setOrderBy("startTime")
                    .setSingleEvents(true)
                    .execute();
            List<Event> items = events.getItems();
            if (items.isEmpty()) {
                return ResponseEntity.ok("No upcoming events found.");
            } else {
                return ResponseEntity.ok(items); // Retourner les événements au format JSON
            }
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching events: " + e.getMessage());
        }
    }



    @GetMapping("/addevent")
    public String addEvent(HttpServletResponse response) throws GeneralSecurityException {
        try {
            // Création d'un nouvel événement
            Event event = new Event();
            event.setSummary("lovemypet test");
            event.setDescription("Ceci est un événement de test pour LoveMyPet");

            DateTime startDateTime = new DateTime("2024-03-24T12:30:00");
            EventDateTime start = new EventDateTime().setDateTime(startDateTime).setTimeZone("Europe/Paris");
            event.setStart(start);

            DateTime endDateTime = new DateTime("2024-03-24T13:30:00");
            EventDateTime end = new EventDateTime().setDateTime(endDateTime).setTimeZone("Europe/Paris");
            event.setEnd(end);

            // Exécution de la requête pour créer l'événement
            com.google.api.services.calendar.Calendar.Events events = service.events();
            Event createdEvent = events.insert("primary", event)
                                    .setKey(API_KEY) // Ajout de la clé API
                                    .execute();

            // Afficher un message une fois l'événement ajouté avec succès
            response.setStatus(HttpServletResponse.SC_OK);
            return "Vos événements ont bien été ajoutés à Google Calendar!";
        } catch (IOException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return "Erreur lors de l'ajout de l'événement: " + e.getMessage();
        }
    }
}
