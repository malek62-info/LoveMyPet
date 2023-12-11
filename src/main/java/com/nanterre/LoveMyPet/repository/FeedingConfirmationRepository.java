package com.nanterre.LoveMyPet.repository;

import com.nanterre.LoveMyPet.model.FeedingConfirmation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedingConfirmationRepository extends JpaRepository<FeedingConfirmation, Integer> {
    // vérifié si une confirmatioon existe déjà
    @Query("SELECT COUNT(fc) > 0 FROM FeedingConfirmation fc WHERE fc.personId = :personId AND fc.animalId = :animalId AND fc.feedingTimeId = :feedingTimeId AND fc.confirmationCode = :confirmationCode")
    boolean existsByPersonIdAndAnimalIdAndFeedingTimeId(
            @Param("personId") Integer personId,
            @Param("animalId") Integer animalId,
            @Param("feedingTimeId") Integer feedingTimeId,
            @Param("confirmationCode") String confirmationCode
    );

}
