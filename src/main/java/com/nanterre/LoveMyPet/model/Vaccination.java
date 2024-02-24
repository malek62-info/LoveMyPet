package com.nanterre.LoveMyPet.model;
import jakarta.persistence.*;
import java.time.LocalTime;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @Column(name = "vaccination_time")
    private LocalTime vaccinationTime;

    @Column(name = "vet_address", length = 100)
    private String vetAddress;

    @Column(name = "vet_name", length = 50)
    private String vetName;

    @Column(name = "comment", length = 255)
    private String comment;

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

    public LocalTime getVaccinationTime() {
        return vaccinationTime;
    }

    public void setVaccinationTime(LocalTime vaccinationTime) {
        this.vaccinationTime = vaccinationTime;
    }

    public String getVetAddress() {
        return vetAddress;
    }

    public void setVetAddress(String vetAddress) {
        this.vetAddress = vetAddress;
    }

    public String getVetName() {
        return vetName;
    }

    public void setVetName(String vetName) {
        this.vetName = vetName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}