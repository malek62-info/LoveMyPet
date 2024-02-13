package com.nanterre.LoveMyPet.model;

import jakarta.persistence.*;

@Entity
@Table(name = "items_to_donate")
public class ItemToDonate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "description")
    private String description;

    @Column(name = "image_url")
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "idperson", referencedColumnName = "idPerson")
    private Person donatingPerson;

    public ItemToDonate() {
    }

    public ItemToDonate(String itemName, String description, String imageUrl, Person person) {
        this.itemName = itemName;
        this.description = description;
        this.imageUrl = imageUrl;
        this.donatingPerson = person;
    }

    // Getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Person getDonatingPerson() {
        return donatingPerson;
    }

    public void setDonatingPerson(Person donatingPerson) {
        this.donatingPerson = donatingPerson;
    }

}
