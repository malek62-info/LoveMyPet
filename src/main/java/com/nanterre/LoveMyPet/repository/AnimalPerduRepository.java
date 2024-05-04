package com.nanterre.LoveMyPet.repository;

import com.nanterre.LoveMyPet.model.AnimalPerdu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
public interface AnimalPerduRepository extends JpaRepository<AnimalPerdu,Integer> {
    @Query("SELECT ap FROM AnimalPerdu ap JOIN Animal a ON ap.idAnimal = a.id WHERE a.idPerson = :idPerson")
    List<AnimalPerdu> findAllByPersonId(@Param("idPerson") Integer idPerson);
    void deleteByIdAnimal(Integer idAnimal);
    boolean existsByIdAnimal(Integer idAnimal);


}

