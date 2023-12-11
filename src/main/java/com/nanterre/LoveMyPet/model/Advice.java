package com.nanterre.LoveMyPet.model;

import jakarta.persistence.*;

@Entity
public class Advice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adviceId;

    @ManyToOne
    @JoinColumn(name = "idPerson")
    private Person author;

    private String textAdvice;

    private String imageUrl; // Path to the image

    // Other fields, getters, and setters

    public Integer getAdviceId() {
        return adviceId;
    }

    public void setAdviceId(Integer adviceId) {
        this.adviceId = adviceId;
    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    public String getTextAdvice() {
        return textAdvice;
    }

    public void setTextAdvice(String textAdvice) {
        this.textAdvice = textAdvice;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}