package com.nanterre.LoveMyPet.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Vaccination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idvaccination")
    private Integer idVaccination;

    @ManyToOne
    @JoinColumn(name = "idvaccin", referencedColumnName = "idvaccin")
    private Vaccin vaccin;

    @ManyToOne
    @JoinColumn(name = "idanimal", referencedColumnName = "idAnimal")
    private Animal animal;

    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date date;

    // Getters and setters

    public Integer getIdVaccination() {
        return idVaccination;
    }

    public void setIdVaccination(Integer idVaccination) {
        this.idVaccination = idVaccination;
    }

    public Vaccin getVaccin() {
        return vaccin;
    }

    public void setVaccin(Vaccin vaccin) {
        this.vaccin = vaccin;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
