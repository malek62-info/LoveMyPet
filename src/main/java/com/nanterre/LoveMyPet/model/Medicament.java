package com.nanterre.LoveMyPet.model;

import jakarta.persistence.*;

@Entity
public class Medicament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmedicament")
    private Integer idMedicament;

    @Column(name = "medicamentname", length = 45)
    private String medicamentName;

    // Getters and setters

    public Integer getIdMedicament() {
        return idMedicament;
    }

    public void setIdMedicament(Integer idMedicament) {
        this.idMedicament = idMedicament;
    }

    public String getMedicamentName() {
        return medicamentName;
    }

    public void setMedicamentName(String medicamentName) {
        this.medicamentName = medicamentName;
    }
}