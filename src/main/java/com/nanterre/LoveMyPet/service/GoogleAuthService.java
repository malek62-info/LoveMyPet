package com.nanterre.LoveMyPet.service;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;
import com.google.api.services.calendar.model.Events;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class GoogleAuthService {

    @Value("${google.clientId}")
    private String clientId;

    @Value("${google.clientSecret}")
    private String clientSecret;

    @Value("${google.redirectUri}")
    private String redirectUri;

    private final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

    private final List<String> SCOPES = Collections.singletonList(CalendarScopes.CALENDAR_EVENTS);

    private HttpTransport httpTransport;

    private Calendar initializeCalendarService(String accessToken) throws GeneralSecurityException, IOException {
        httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        return new Calendar.Builder(httpTransport, JSON_FACTORY, null)
                .setHttpRequestInitializer(request -> {
                    request.getHeaders().setAuthorization("Bearer " + accessToken);
                    request.getHeaders().setContentType("application/json");
                })
                .setApplicationName("Your Application Name")
                .build();
    }

    public String getAuthorizationUrl() {
        return "https://accounts.google.com/o/oauth2/auth" +
                "?response_type=code" +
                "&client_id=" + clientId +
                "&redirect_uri=" + redirectUri +
                "&scope=" + String.join(" ", SCOPES);
    }

  // Méthode pour obtenir un access token à partir d'un code d'autorisation
  public String getAccessToken(String code) {
    try {

        String clientId = "";
        String clientSecret = "";
        String redirectUri = "http://localhost:8086/calendar-google";

        // Création de l'objet GoogleAuthorizationCodeFlow
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                GoogleNetHttpTransport.newTrustedTransport(),
                JacksonFactory.getDefaultInstance(),
                clientId,
                clientSecret,
                Collections.singleton("")) // Pas besoin de scopes spécifiques pour échanger le code
                .build();

        // Echange du code d'autorisation contre un access token
        GoogleTokenResponse response = flow.newTokenRequest(code)
                .setRedirectUri(redirectUri)
                .execute();

        // Récupération de l'access token à partir de la réponse
    
        String accessToken = response.getAccessToken();
        System.out.println("Voici le acces token" + accessToken);

        return accessToken;
    } catch (IOException | GeneralSecurityException e) {
        e.printStackTrace();
        return null; // En cas d'erreur, retournez null
    }
}

    public String insertEvent(String accessToken, String summary, LocalDate date) {
    try {
        System.out.println("Voici le acces token" + accessToken);
        Calendar service = initializeCalendarService(accessToken);
        
        // Convertir LocalDate en DateTime au format RFC3339
        ZonedDateTime startDateTime = date.atStartOfDay(ZoneId.systemDefault());
        DateTime start = new DateTime(startDateTime.toInstant().toString());
        DateTime end = new DateTime(startDateTime.plusHours(1).toInstant().toString()); // Ajoutez une heure à la date de début
        
        Event event = new Event()
                .setSummary(summary)
                .setStart(new EventDateTime().setDateTime(start))
                .setEnd(new EventDateTime().setDateTime(end));

        event = service.events().insert("primary", event).execute();
        
        // Afficher les détails de l'événement dans la console
        System.out.println("ID de l'événement : " + event.getId());
        System.out.println("Résumé de l'événement : " + event.getSummary());
        System.out.println("Date de début de l'événement : " + event.getStart().getDateTime());
        System.out.println("Date de fin de l'événement : " + event.getEnd().getDateTime());
        
        return event.getId();
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}


    public List<Event> listEvents(String accessToken) {
        try {
            Calendar service = initializeCalendarService(accessToken);
            LocalDate today = LocalDate.now();
            Date minDate = Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant());
            Events events = service.events().list("primary")
                    .setTimeMin(new com.google.api.client.util.DateTime(minDate))
                    .setOrderBy("startTime")
                    .setSingleEvents(true)
                    .execute();
            return events.getItems();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
