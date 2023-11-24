package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.Animal;

import java.util.List;
import java.util.Map;

public interface AdoptionService {
  List<String> getAllAdoptionUrls();
  Map<String, Object> getAdoptionDetails(Integer idAdoption);
}
