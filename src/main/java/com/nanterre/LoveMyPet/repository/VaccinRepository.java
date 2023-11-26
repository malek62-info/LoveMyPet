package com.nanterre.LoveMyPet.repository;
import org.springframework.data.repository.CrudRepository;
import com.nanterre.LoveMyPet.model.Vaccin;

public interface VaccinRepository extends CrudRepository<Vaccin, Integer> {
  
}
