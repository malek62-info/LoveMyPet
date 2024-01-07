package com.nanterre.LoveMyPet.repository;


import com.nanterre.LoveMyPet.model.Evenement;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EvenementRepository extends CrudRepository<Evenement, Integer> {

    // Les mails des personnes inscrites à un évenement ou la date est J-1
    @Query(nativeQuery = true, value =
            "SELECT p.email, p.first_name, p.last_name, e.titre AS event_name, e.place AS event_place " +
                    "FROM Inscription i " +
                    "JOIN Evenement e ON i.id_evenement = e.id_evenement " +
                    "JOIN Person p ON i.id_person = p.id_person " +
                    "WHERE e.date = CURRENT_DATE() + 1")
    List<Object[]> findEmailsAndEventDetailsForReminders();




}
