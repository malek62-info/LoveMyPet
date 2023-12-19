package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.Advice;
import com.nanterre.LoveMyPet.repository.AdviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public  class AdviceServiceImpl implements AdviceService { // Implémenter l'interface

    @Autowired
    private AdviceRepository adviceRepository;


    //référence de toutes les advices
    @Override
    public List<String> getAllAdviceReferences() {
        List<Advice> advices = adviceRepository.findAll();
        return advices.stream()
                .map(advice -> "advice/" + advice.getAdviceId())
                .collect(Collectors.toList());
    }

    //récupérer une advice précise a partir de lid
    @Override
    public Map<String, Object> getAdviceDetails(Integer adviceId) {
        Advice advice = adviceRepository.findById(adviceId).orElse(null);

        if (advice == null) {
            // Gérer le cas où l'avis n'est pas trouvé
            return null;
        }

        return mapAdviceToDetails(advice);
    }

    private Map<String, Object> mapAdviceToDetails(Advice advice) {
        Map<String, Object> adviceDetails = new HashMap<>();
        adviceDetails.put("adviceId", advice.getAdviceId());  // Ajout de l'ID de l'avis
        adviceDetails.put("authorName", advice.getAuthor().getFirstName() + " " + advice.getAuthor().getLastName());
        adviceDetails.put("textAdvice", advice.getTextAdvice());
        adviceDetails.put("imageUrl", advice.getImageUrl());
        adviceDetails.put("likeCount", advice.getLikeCount());
        adviceDetails.put("dislikeCount", advice.getDislikeCount());
        return adviceDetails;
    }

}