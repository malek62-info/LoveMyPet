package com.nanterre.LoveMyPet.service;



import com.nanterre.LoveMyPet.model.Advice;

import java.util.List;
import java.util.Map;

public  interface AdviceService {
    List<String> getAllAdviceReferences();
    Map<String, Object> getAdviceDetails(Integer adviceId);
    void addAdvice(Advice advice);
}

