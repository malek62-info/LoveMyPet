package com.nanterre.LoveMyPet.repository;

import com.nanterre.LoveMyPet.model.ItemToDonate; // Modification du nom de l'entité

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemToDonateRepository extends JpaRepository<ItemToDonate, Integer> {
    List<ItemToDonate> findByDonatingPerson_IdPerson(Integer personId); 
}



