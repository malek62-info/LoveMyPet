package com.nanterre.LoveMyPet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nanterre.LoveMyPet.model.Medicament;
import com.nanterre.LoveMyPet.repository.MedicamentRepository;

@Service
public class MedicamentServiceImpl implements MedicamentService {

    @Autowired
    private MedicamentRepository medicamentRepository;

    @Override
    public Iterable<Medicament> getAllMedicaments() {
        return medicamentRepository.findAll();
    }

    @Override
    public Medicament getMedicamentById(Integer id) {
        return null;
    }
}
