package com.nanterre.LoveMyPet.model;

import jakarta.persistence.*;
import java.text.SimpleDateFormat;
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


    @Column(name = "gender") /*1 M , et 2 F*/
    private Integer gender;

    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;


    @Column(name = "imageurl")
    private String imageUrl;

    @Column(name = "adopted", columnDefinition = "tinyint(1) default 1")
    private Boolean adopted;

    @ManyToOne
    @JoinColumn(name = "idperson", referencedColumnName = "idperson", insertable = false, updatable = false)
    private Person adoptedByPerson;

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

    public Boolean getAdopted() {
        return adopted;
    }

    // Ajoutez le getter et le setter pour le genre
    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public void setAdopted(Boolean adopted) {
        this.adopted = adopted;
    }

    public Person getAdoptedByPerson() {
        return adoptedByPerson;
    }

    public void setAdoptedByPerson(Person adoptedByPerson) {
        this.adoptedByPerson = adoptedByPerson;
    }

    // Méthode pour formater la date au format "20/01/2023"
   /* public String getFormattedDateOfBirth() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return dateOfBirth != null ? sdf.format(dateOfBirth) : "";
    }*/
}
