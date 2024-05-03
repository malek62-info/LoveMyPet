package com.nanterre.LoveMyPet.repository;

import com.nanterre.LoveMyPet.model.AnimalVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AnimalVuRepository extends JpaRepository <AnimalVu,Long>{

    @Query(nativeQuery = true, value =
            "SELECT " +
                    "    av.id_animal_vu, " +
                    "    a.name AS nom_animal, " +
                    "    p1.email AS email_voyeur, " +
                    "    p2.email AS email_proprietaire " +
                    "FROM " +
                    "    animaux_vus av " +
                    "JOIN " +
                    "    animal a ON av.id_animal = a.idanimal " +
                    "JOIN " +
                    "    person p1 ON av.id_personne = p1.id_person " +
                    "JOIN " +
                    "    person p2 ON a.idperson = p2.id_person ")
    List<Object[]> getEmailsByAnimalVue();
    List<AnimalVu> findAllByidAnimal(Integer idAnimal);

}
