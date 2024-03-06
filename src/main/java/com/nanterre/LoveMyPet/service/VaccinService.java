
package com.nanterre.LoveMyPet.service;


import com.nanterre.LoveMyPet.model.Vaccin;

        import java.util.List;

public interface VaccinService {


    public List<String> getAllVaccinReferences();
    public Vaccin getVaccinById(Integer id);







}