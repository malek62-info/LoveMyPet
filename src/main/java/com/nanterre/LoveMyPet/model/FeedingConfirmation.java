package com.nanterre.LoveMyPet.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "feeding_confirmation")
public class FeedingConfirmation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "person_id")
    private Integer personId;

    @Column(name = "animal_id")
    private Integer animalId;

    @Column(name = "feeding_time_id")
    private Integer feedingTimeId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "confirmation_date", nullable = false, updatable = false)
    private Date confirmationDate;

    private String confirmationCode;

    // Getters

    public Integer getId() {
        return id;
    }

    public Integer getPersonId() {
        return personId;
    }

    public Integer getAnimalId() {
        return animalId;
    }

    public Integer getFeedingTimeId() {
        return feedingTimeId;
    }

    public Date getConfirmationDate() {
        return confirmationDate;
    }

    public String getConfirmationCode() {
        return confirmationCode;
    }

    // Setters

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public void setAnimalId(Integer animalId) {
        this.animalId = animalId;
    }

    public void setFeedingTimeId(Integer feedingTimeId) {
        this.feedingTimeId = feedingTimeId;
    }

    public void setConfirmationDate(Date confirmationDate) {
        this.confirmationDate = confirmationDate;
    }

    public void setConfirmationCode(String confirmationCode) {
        this.confirmationCode = confirmationCode;
    }
}
