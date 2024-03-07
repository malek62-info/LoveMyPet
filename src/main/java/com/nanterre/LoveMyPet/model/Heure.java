package com.nanterre.LoveMyPet.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
public class Heure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idheure")
    private Integer idHeure; // Identifiant pour heure

    @ManyToOne
    @JoinColumn(name = "idtraitement", referencedColumnName = "idtraitement")
    @JsonBackReference
    private Traitement traitement; // Identifiant traitement pour associer un traitement à une heure
    
    @Temporal(TemporalType.TIME)
    @Column(name = "heure")
    @DateTimeFormat(pattern = "HH:mm")
    private Date heure;

    

    // Getters and setters

    public Integer getIdHeure() {
        return idHeure;
    }

    public void setIdHeure(Integer idHeure) {
        this.idHeure = idHeure;
    }

    public Traitement getTraitement() {
        return traitement;
    }

    public void setTraitement(Traitement traitement) {
        this.traitement = traitement;
    }
    public Date getHeure() {
        return heure;
    }

    public void setHeure(Date heure) {
        this.heure = heure;
    }
}