package com.nanterre.LoveMyPet.repository;

import com.nanterre.LoveMyPet.model.Animal;
import com.nanterre.LoveMyPet.model.FeedingTime;

import java.util.List;  

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalTime;


@Repository
public interface FeedingTimeRepository extends JpaRepository<FeedingTime, Integer> {
     boolean existsByAnimalAndFeedingTime(Animal animal, LocalTime feedingTime);
     List<FeedingTime> findByAnimalId(Integer idAnimal);

     @Query(nativeQuery = true, value =
             "SELECT p.email, p.first_name, p.id_person, a.idanimal, a.name AS animal_name, a.imageurl AS animal_url, ft.id AS feeding_time_id " +
                     "FROM person p " +
                     "JOIN animal a ON p.id_person = a.idperson " +
                     "JOIN feeding_times ft ON a.idanimal = ft.animal_id " +
                     "WHERE HOUR(CURRENT_TIME()) = HOUR(ft.feeding_time) " +
                     "AND MINUTE(CURRENT_TIME()) = MINUTE(ft.feeding_time)")
     List<Object[]> findEmailsAndAnimalDetailsForUsersWithCurrentFeedingTime();


}
