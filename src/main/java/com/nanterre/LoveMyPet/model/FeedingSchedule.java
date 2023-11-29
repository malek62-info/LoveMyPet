package com.nanterre.LoveMyPet.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "feeding_schedule")
public class FeedingSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "animal_id", nullable = false)
    private Animal animal;

    @Column(name = "feeding_frequency")
    private int feedingFrequency;

    @OneToMany(mappedBy = "feedingSchedule", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FeedingTime> feedingTimes;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public int getFeedingFrequency() {
        return feedingFrequency;
    }

    public void setFeedingFrequency(int feedingFrequency) {
        this.feedingFrequency = feedingFrequency;
    }

    public List<FeedingTime> getFeedingTimes() {
        return feedingTimes;
    }

    public void setFeedingTimes(List<FeedingTime> feedingTimes) {
        this.feedingTimes = feedingTimes;
    }

    // Equals and HashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeedingSchedule that = (FeedingSchedule) o;
        return id.equals(that.id) &&
                animal.equals(that.animal) &&
                feedingFrequency == that.feedingFrequency &&
                Objects.equals(feedingTimes, that.feedingTimes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, animal, feedingFrequency, feedingTimes);
    }

    // Additional methods or annotations as needed
}
