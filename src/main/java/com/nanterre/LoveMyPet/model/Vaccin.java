package com.nanterre.LoveMyPet.model;

import jakarta.persistence.*;

@Entity
public class Vaccin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idvaccin")
    private Integer idVaccin;

    @Column(name = "vaccinename", length = 45)
    private String vaccinName;

    // Getters and setters

    public Integer getIdVaccin() {
        return idVaccin;
    }

    public void setIdVaccin(Integer idVaccin) {
        this.idVaccin = idVaccin;
    }

    public String getVaccinName() {
        return vaccinName;
    }

    public void setVaccinName(String vaccinName) {
        this.vaccinName = vaccinName;
    }
}