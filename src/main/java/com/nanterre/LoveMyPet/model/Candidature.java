package com.nanterre.LoveMyPet.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "candidature")
public class Candidature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcandidature")
    private Integer idCandidature;

    @Column(name = "date_candidature", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dateCandidature = new Date();

    @ManyToOne
    @JoinColumn(name = "idperson", referencedColumnName = "idperson")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "idadoption", referencedColumnName = "idadoption")
    private Adoption adoption;

    // Getters and setters

    public Integer getIdCandidature() {
        return idCandidature;
    }

    public void setIdCandidature(Integer idCandidature) {
        this.idCandidature = idCandidature;
    }

    public Date getDateCandidature() {
        return dateCandidature;
    }

    public void setDateCandidature(Date dateCandidature) {
        this.dateCandidature = dateCandidature;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Adoption getAdoption() {
        return adoption;
    }

    public void setAdoption(Adoption adoption) {
        this.adoption = adoption;
    }
}