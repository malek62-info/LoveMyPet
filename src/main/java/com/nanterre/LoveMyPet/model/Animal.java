package com.nanterre.LoveMyPet.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "animal")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idanimal")
    private Integer id;

    @Column(name = "idperson")
    private Integer idPerson;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private String category;

    @Column(name = "race")
    private String race;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "gender")
    private Integer gender;

    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    @Column(name = "imageurl")
    private String imageUrl;

    @Column(name = "is_scheduled")
    private boolean isScheduled = false; // Nouveau champ ajouté avec une valeur par défaut de false

    @ManyToOne
    @JoinColumn(name = "idperson", referencedColumnName = "idperson", insertable = false, updatable = false)
    private Person adoptedByPerson;

    // Constructeur sans argument pour JPA
    public Animal() {
        this.isScheduled = false; // Initialiser le champ isScheduled à false par défaut
    }

    // Getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isScheduled() {
        return isScheduled;
    }

    public void setScheduled(boolean scheduled) {
        isScheduled = scheduled;
    }

    public Person getAdoptedByPerson() {
        return adoptedByPerson;
    }

    public void setAdoptedByPerson(Person adoptedByPerson) {
        this.adoptedByPerson = adoptedByPerson;
    }
}
