package com.nanterre.LoveMyPet.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "animaux_perdus")
public class AnimalPerdu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAnimalPerdu;

    @Column(nullable = false)
    private Integer idAnimal;

    @Column(nullable = false)
    private double latitude;

    @Column(nullable = false)
    private double longitude;

    // Constructeurs
    public AnimalPerdu() {}

    public AnimalPerdu(Integer idAnimal, double latitude, double longitude) {
        this.idAnimal = idAnimal;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Getters et Setters
    public Long getIdAnimalPerdu() {
        return idAnimalPerdu;
    }

    public void setIdAnimalPerdu(Long idAnimalPerdu) {
        this.idAnimalPerdu = idAnimalPerdu;
    }

    public Integer getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Integer idAnimal) {
        this.idAnimal = idAnimal;
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
}