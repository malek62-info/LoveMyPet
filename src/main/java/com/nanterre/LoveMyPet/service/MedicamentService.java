package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.Medicament;

public interface MedicamentService {
    Iterable<Medicament> getAllMedicaments();
    Medicament getMedicamentById(Integer id);
}
