package com.nanterre.LoveMyPet.service;


import java.util.List;

public interface VaccinService {


    void loadDataFromJson(String jsonFilePath);

    List<String> getAllVaccinNames();


    public Integer findVaccinIdByName(String vaccinName);






}
