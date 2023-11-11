package com.nanterre.LoveMyPet.repository;

import com.nanterre.LoveMyPet.model.Animal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

/*public interface AnimalRepository extends CrudRepository<Animal, Integer> {
    Iterable<Animal> findByAdoptedFalse();

    @Query("SELECT a FROM Animal a WHERE a.adopted = false " +
            "AND (lower(a.name) LIKE lower(concat('%', :keyword, '%')) " +
            "OR lower(a.category) LIKE lower(concat('%', :keyword, '%')) " +
            "OR lower(a.race) LIKE lower(concat('%', :keyword, '%')))")
    Iterable<Animal> searchByKeyword(@Param("keyword") String keyword);

    // Nouvelles méthodes pour les critères de filtrage
    @Query("SELECT a FROM Animal a WHERE a.adopted = false " +
            "AND (:age IS NULL OR a.age >= :age) " +
            "AND (:weight IS NULL OR a.weight >= :weight) " +
            "AND (:race IS NULL OR lower(a.race) LIKE lower(concat('%', :race, '%')))" +
            "AND (:category IS NULL OR lower(a.category) LIKE lower(concat('%', :category, '%')))")
    Iterable<Animal> filterAnimals(@Param("age") Integer age, @Param("weight") Double weight,
                                   @Param("race") String race, @Param("category") String category);
}
*/

public interface AnimalRepository extends CrudRepository<Animal, Integer> {
    Iterable<Animal> findByAdoptedFalse();

    @Query("SELECT a FROM Animal a WHERE a.adopted = false " +
            "AND (lower(a.name) LIKE lower(concat('%', :keyword, '%')) " +
            "OR lower(a.category) LIKE lower(concat('%', :keyword, '%')) " +
            "OR lower(a.race) LIKE lower(concat('%', :keyword, '%')))")
    Iterable<Animal> searchByKeyword(@Param("keyword") String keyword);

    // Nouvelles méthodes pour les critères de filtrage
    @Query("SELECT a FROM Animal a WHERE a.adopted = false " +
            "AND (:dateOfBirth IS NULL OR a.dateOfBirth <= :dateOfBirth) " +
            "AND (:weight IS NULL OR a.weight >= :weight) " +
            "AND (:race IS NULL OR lower(a.race) LIKE lower(concat('%', :race, '%')))" +
            "AND (:category IS NULL OR lower(a.category) LIKE lower(concat('%', :category, '%')))" +
            "AND (:gender IS NULL OR a.gender = :gender)")
    Iterable<Animal> filterAnimals(@Param("dateOfBirth") Date dateOfBirth, @Param("weight") Double weight,
                                   @Param("race") String race, @Param("category") String category,
                                   @Param("gender") Integer gender);

}
