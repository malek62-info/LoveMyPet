package com.nanterre.LoveMyPet.repository;

import com.nanterre.LoveMyPet.model.AnimalVuEmail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalVuEmailRepository extends JpaRepository<AnimalVuEmail, Long> {

    // Méthode pour trouver une entrée dans AnimalVuEmail par son idAnimalVue
    AnimalVuEmail findByIdAnimalVue(Long idAnimalVue);
}
