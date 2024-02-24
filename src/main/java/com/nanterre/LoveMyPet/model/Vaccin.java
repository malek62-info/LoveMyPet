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

    @Column(name = "info_vaccin", length = 255) // Example length, adjust as needed
    private String infoVaccin;

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

    public String getInfoVaccin() {
        return infoVaccin;
    }

    public void setInfoVaccin(String infoVaccin) {
        this.infoVaccin = infoVaccin;
    }
}
