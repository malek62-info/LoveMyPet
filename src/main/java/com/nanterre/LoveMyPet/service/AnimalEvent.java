package com.nanterre.LoveMyPet.service;

import java.time.LocalDate;
import java.time.LocalTime;

public class AnimalEvent {
    private LocalDate date;
    private LocalTime heure;
    private String titre;

    public AnimalEvent(LocalDate date, LocalTime heure, String titre) {
        this.date = date;
        this.heure = heure;
        this.titre = titre;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getHeure() {
        return heure;
    }

    public void setHeure(LocalTime heure) {
        this.heure = heure;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
}

