package com.nanterre.LoveMyPet.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "animaux_vus")
public class AnimalVu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAnimalVu;

    @Column(nullable = false)
    private Integer idAnimal;

    @Column(nullable = false)
    private Integer idPersonne;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private LocalTime heure;

    @Column(nullable = false)
    private double latitude;

    @Column(nullable = false)
    private double longitude;

    @Column(nullable = false)
    private double rayon;

    // Constructeurs
    public AnimalVu() {}

    public AnimalVu(Integer idAnimal, Integer idPersonne, LocalDate date, LocalTime heure, double latitude, double longitude, double rayon) {
        this.idAnimal = idAnimal;
        this.idPersonne = idPersonne;
        this.date = date;
        this.heure = heure;
        this.latitude = latitude;
        this.longitude = longitude;
        this.rayon = rayon;
    }

    // Getters et Setters
    public Long getIdAnimalVu() {
        return idAnimalVu;
    }

    public void setIdAnimalVu(Long idAnimalVu) {
        this.idAnimalVu = idAnimalVu;
    }

    public Integer getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Integer idAnimal) {
        this.idAnimal = idAnimal;
    }

    public Integer getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(Integer idPersonne) {
        this.idPersonne = idPersonne;
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

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getRayon() {
        return rayon;
    }

    public void setRayon(double rayon) {
        this.rayon = rayon;
    }

}


