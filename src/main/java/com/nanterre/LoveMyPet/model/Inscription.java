package com.nanterre.LoveMyPet.model;
import jakarta.persistence.*;

@Entity
public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idInscription;

    @ManyToOne
    @JoinColumn(name = "idPerson")
    private Person personne;

    @ManyToOne
    @JoinColumn(name = "idEvenement")
    private Evenement evenement;

    // Getters
    public Integer getIdInscription() {
        return idInscription;
    }

    public Person getPersonne() {
        return personne;
    }

    public Evenement getEvenement() {
        return evenement;
    }

    // Setters
    public void setIdInscription(Integer idInscription) {
        this.idInscription = idInscription;
    }

    public void setPersonne(Person personne) {
        this.personne = personne;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }
}
