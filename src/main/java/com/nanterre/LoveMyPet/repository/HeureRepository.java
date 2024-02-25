package com.nanterre.LoveMyPet.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nanterre.LoveMyPet.model.Heure;

@Repository
public interface HeureRepository extends JpaRepository<Heure, Integer> {
    // Vous pouvez ajouter des méthodes de requête personnalisées ici si nécessaire
}
