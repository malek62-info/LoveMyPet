

package com.nanterre.LoveMyPet.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nanterre.LoveMyPet.model.Heure;

@Repository
public interface HeureRepository extends JpaRepository<Heure, Integer> {
    List<Heure> findByTraitementIdTraitement(Integer traitementId);
}
