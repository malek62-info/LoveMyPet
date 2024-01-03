package com.nanterre.LoveMyPet.model;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Evenement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEvenement;

    private String titre;
    private LocalDate date;
    private String imageUrl;
    private String place;

    @ManyToOne
    @JoinColumn(name = "idPerson")
    private Person createur;
    @OneToMany(mappedBy = "evenement", cascade = CascadeType.ALL)
    private List<Inscription> inscriptions;
    // Getters
    public Integer getIdEvenement() {
        return idEvenement;
    }

    public String getTitre() {
        return titre;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getPlace() {
        return place;
    }

    public Person getCreateur() {
        return createur;
    }

    // Setters
    public void setIdEvenement(Integer idEvenement) {
        this.idEvenement = idEvenement;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setCreateur(Person createur) {
        this.createur = createur;
    }


}
