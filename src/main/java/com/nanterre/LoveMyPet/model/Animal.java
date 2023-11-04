package com.nanterre.LoveMyPet.model;

import jakarta.persistence.*;

@Entity
@Table(name = "animal")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idanimal")
    private Integer id;

    @Column(name = "idperson") // Utilisation du nom de colonne "idperson" au lieu de "adopted_by"
    private Integer idPerson; // Clé étrangère faisant référence à l'ID de la personne qui a adopté l'animal

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private String category;

    @Column(name = "race")
    private String race;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "age")
    private Integer age;

    @Column(name = "imageurl")
    private String imageUrl;

    @Column(name = "adopted", columnDefinition = "tinyint(1) default 1")
    private Boolean adopted;

    @ManyToOne
    @JoinColumn(name = "idperson", referencedColumnName = "idperson", insertable = false, updatable = false) // Utilisation de "idperson"
    private Person adoptedByPerson; // Référence à la personne qui a adopté l'animal

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public void setAdopted(Boolean adopted) {
        this.adopted = adopted;
    }

    public Person getAdoptedByPerson() {
        return adoptedByPerson;
    }

    public void setAdoptedByPerson(Person adoptedByPerson) {
        this.adoptedByPerson = adoptedByPerson;
    }
}
