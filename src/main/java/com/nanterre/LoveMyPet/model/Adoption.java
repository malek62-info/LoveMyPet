package com.nanterre.LoveMyPet.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "adoption")
public class Adoption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idadoption")
    private Integer idAdoption;

    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    @Column(name = "idanimal")
    private Integer idAnimal;

    @ManyToOne
    @JoinColumn(name = "idanimal", referencedColumnName = "idanimal", insertable = false, updatable = false)
    private Animal adoptedAnimal;

    // Getters and setters

    public Integer getIdAdoption() {
        return idAdoption;
    }

    public void setIdAdoption(Integer idAdoption) {
        this.idAdoption = idAdoption;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Integer idAnimal) {
        this.idAnimal = idAnimal;
    }

    public Animal getAdoptedAnimal() {
        return adoptedAnimal;
    }

    public void setAdoptedAnimal(Animal adoptedAnimal) {
        this.adoptedAnimal = adoptedAnimal;
    }
}