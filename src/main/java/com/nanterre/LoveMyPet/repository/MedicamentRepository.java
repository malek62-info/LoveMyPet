package com.nanterre.LoveMyPet.repository;

import org.springframework.data.repository.CrudRepository;
import com.nanterre.LoveMyPet.model.Medicament;

public interface MedicamentRepository extends CrudRepository<Medicament, Integer> {
  
}
