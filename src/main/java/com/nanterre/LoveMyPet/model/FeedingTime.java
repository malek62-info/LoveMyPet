package com.nanterre.LoveMyPet.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "feeding_times")
public class FeedingTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "feeding_schedule_id", nullable = false)
    private FeedingSchedule feedingSchedule;

    @Column(name = "feeding_time", columnDefinition = "TIME(0)") // Spécifie la longueur à 0 pour exclure les secondes
    @JsonFormat(pattern = "HH:mm")
    private LocalTime feedingTime;


    // Constructeur avec une chaîne
    public FeedingTime(String feedingTime) {
        this.feedingTime = LocalTime.parse(feedingTime);
    }

    // Ajoutez un constructeur sans arguments ou une méthode de fabrique avec des arguments
    public FeedingTime() {
        // Constructeur sans arguments pour la désérialisation JSON
    }

    public FeedingTime(LocalTime of) {
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FeedingSchedule getFeedingSchedule() {
        return feedingSchedule;
    }

    public void setFeedingSchedule(FeedingSchedule feedingSchedule) {
        this.feedingSchedule = feedingSchedule;
    }

    public LocalTime getFeedingTime() {
        return feedingTime;
    }

    public void setFeedingTime(LocalTime feedingTime) {
        this.feedingTime = feedingTime;
    }

    // Equals and HashCode

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeedingTime that = (FeedingTime) o;
        return id.equals(that.id) &&
                feedingSchedule.equals(that.feedingSchedule) &&
                feedingTime.equals(that.feedingTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, feedingSchedule, feedingTime);
    }
    */


    // Additional methods or annotations as needed
}
