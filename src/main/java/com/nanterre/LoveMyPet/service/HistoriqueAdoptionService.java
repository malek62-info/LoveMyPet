package com.nanterre.LoveMyPet.service;

import java.util.Date;

import com.nanterre.LoveMyPet.model.HistoriqueAdoption;

public interface HistoriqueAdoptionService {
	void ajouterAdoption(Integer idAnimal, Integer idPerson, Date endDate);
}

