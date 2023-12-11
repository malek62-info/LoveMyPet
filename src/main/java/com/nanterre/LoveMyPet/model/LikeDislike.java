package com.nanterre.LoveMyPet.model;

import jakarta.persistence.*;

@Entity
public class LikeDislike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "advice_id", referencedColumnName = "adviceId")
    private Advice advice;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    private boolean isLike; // true for like, false for dislike

    // Other fields, getters, and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }
}
