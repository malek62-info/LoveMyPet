package com.nanterre.LoveMyPet.repository;
import com.nanterre.LoveMyPet.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    List<Animal> findByIdPerson(Integer idPerson);

   // modifier le champ isScheduled a tru , car des alertes ont été crées
   @Modifying
   @Query(value = "UPDATE Animal SET is_scheduled = :isScheduled WHERE idanimal = :animalId", nativeQuery = true)
   void updateIsScheduled(@Param("animalId") Integer animalId, @Param("isScheduled") boolean isScheduled);


}
