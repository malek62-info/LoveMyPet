package com.nanterre.LoveMyPet.service.interfaces;

import java.util.List;
import java.util.Map;

public interface AdviceService {
    List<String> getAllAdviceReferences();
     Map<String, Object> getAdviceDetails(Integer adviceId);

}
