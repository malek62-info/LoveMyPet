package com.nanterre.LoveMyPet.repository;


import com.nanterre.LoveMyPet.model.Evenement;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

import com.nanterre.LoveMyPet.model.Person;


import java.time.LocalDate;

public interface EvenementRepository extends CrudRepository<Evenement, Integer> {

    // Les mails des personnes inscrites à un évenement ou la date est J-1
    @Query(nativeQuery = true, value =
            "SELECT p.email, p.first_name, p.last_name, e.titre AS event_name, e.place AS event_place " +
                    "FROM Inscription i " +
                    "JOIN Evenement e ON i.id_evenement = e.id_evenement " +
                    "JOIN Person p ON i.id_person = p.id_person " +
                    "WHERE e.date = CURRENT_DATE() + 1")
    List<Object[]> findEmailsAndEventDetailsForReminders();


    // Autres méthodes génériques fournies par JpaRepository
    // Recherche un événement par son titre
    List<Evenement> findByTitre(String titre);

    // Recherche tous les événements après une certaine date
    List<Evenement> findByDateAfter(LocalDate date);

    // Recherche tous les événements créés par une personne spécifique
    List<Evenement> findByCreateur(Person createur);










}
