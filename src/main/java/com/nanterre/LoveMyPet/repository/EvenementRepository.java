package com.nanterre.LoveMyPet.repository;
import com.nanterre.LoveMyPet.model.Evenement;
import com.nanterre.LoveMyPet.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface EvenementRepository extends JpaRepository<Evenement, Integer> {
    // Autres méthodes génériques fournies par JpaRepository

    // Recherche un événement par son titre
    List<Evenement> findByTitre(String titre);

    // Recherche tous les événements après une certaine date
    List<Evenement> findByDateAfter(LocalDate date);

    // Recherche tous les événements créés par une personne spécifique
    List<Evenement> findByCreateur(Person createur);







}
