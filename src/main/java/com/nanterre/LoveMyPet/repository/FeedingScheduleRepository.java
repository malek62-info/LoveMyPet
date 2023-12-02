package com.nanterre.LoveMyPet.repository;

import com.nanterre.LoveMyPet.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nanterre.LoveMyPet.model.FeedingSchedule;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FeedingScheduleRepository extends JpaRepository<FeedingSchedule, Long> {

    @Query(value = "SELECT DISTINCT p.email " +
            "FROM person p " +
            "JOIN animal a ON p.id_person = a.idperson " +
            "JOIN feeding_schedule fs ON a.idanimal = fs.animal_id " +
            "JOIN feeding_times ft ON fs.id = ft.feeding_schedule_id " +
            "WHERE HOUR(CURRENT_TIME()) = HOUR(ft.feeding_time) " +
            "AND MINUTE(CURRENT_TIME()) = MINUTE(ft.feeding_time)", nativeQuery = true)
    List<String> findEmailsForCurrentFeedingTime();



}