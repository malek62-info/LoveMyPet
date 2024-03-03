package com.nanterre.LoveMyPet.repository;

import com.nanterre.LoveMyPet.model.Traitement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TraitementRepository extends JpaRepository<Traitement, Integer> {
    List<Traitement> findByAnimalId(Integer animalId);
    Optional<Traitement> findById(Integer id);

    //Liste des details traitement actuel
    @Query(nativeQuery = true, value = "SELECT person.email, " +
            "medicament.medicamentname AS nom_medicament, " +
            "traitement.commentaire AS nom_traitement, " +
            "DATE_FORMAT(CURDATE(), '%Y-%m-%d') AS date_traitement, " +
            "animal.name AS nom_animal, " +
            "DATE_FORMAT(heure.heure, '%H:%i') AS heure_traitement " +
            "FROM traitement " +
            "JOIN animal ON traitement.idanimal = animal.idanimal " +
            "JOIN person ON animal.idperson = person.id_person " +
            "LEFT JOIN medicament ON traitement.idmedicament = medicament.idmedicament " +
            "LEFT JOIN heure ON traitement.idtraitement = heure.idtraitement " +
            "WHERE CURRENT_DATE >= traitement.datedebut " +
            "AND CURRENT_DATE <= traitement.datefin " +
            "AND heure.heure IS NOT NULL " +
            "AND HOUR(CURRENT_TIME()) = HOUR(heure.heure) " +
            "AND MINUTE(CURRENT_TIME()) = MINUTE(heure.heure)")
    List<Object[]> findEmailAndTreatmentDetails();




}
