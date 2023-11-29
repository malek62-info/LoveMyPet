package com.nanterre.LoveMyPet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nanterre.LoveMyPet.model.FeedingSchedule;

public interface FeedingScheduleRepository extends JpaRepository<FeedingSchedule, Long> {
    // Ajoutez des méthodes personnalisées du repository si nécessaire
}
