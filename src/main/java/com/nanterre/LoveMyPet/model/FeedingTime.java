package com.nanterre.LoveMyPet.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "feeding_times")
public class FeedingTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "animal_id", nullable = false)
    private Animal animal;

    @Column(name = "feeding_time", columnDefinition = "TIME(0)")
    @JsonFormat(pattern = "HH:mm")
    private LocalTime feedingTime;

    // Constructors, getters, setters

    public FeedingTime() {
        // Constructor without arguments for JSON deserialization
    }

    public FeedingTime(LocalTime feedingTime) {
        this.feedingTime = feedingTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public LocalTime getFeedingTime() {
        return feedingTime;
    }

    public void setFeedingTime(LocalTime feedingTime) {
        this.feedingTime = feedingTime;
    }
}

