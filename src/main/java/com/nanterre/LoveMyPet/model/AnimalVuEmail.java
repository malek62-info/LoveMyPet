package com.nanterre.LoveMyPet.model;

import jakarta.persistence.*;

@Entity
@Table(name = "animal_vu_email")
public class AnimalVuEmail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_animal_vue", nullable = false)
    private Long idAnimalVue;

    // Constructeur par défaut
    public AnimalVuEmail() {
    }

    // Constructeur avec les paramètres nécessaires
    public AnimalVuEmail(Long idAnimalVue) {
        this.idAnimalVue = idAnimalVue;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdAnimalVue() {
        return idAnimalVue;
    }

    public void setIdAnimalVue(Long idAnimalVue) {
        this.idAnimalVue = idAnimalVue;
    }
}
