package com.nanterre.LoveMyPet.controller;

import com.nanterre.LoveMyPet.service.AdoptionServiceImpl;

import com.nanterre.LoveMyPet.service.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/advices")
public class AdviceController {

    @Autowired
    private AdviceService adviceService;
    
    //liste de toutes les advices
    @GetMapping
    public List<String> getAllAdviceReferences() {
        return adviceService.getAllAdviceReferences();
    }
    //récupérer une advice a parir de id
    @GetMapping("advice/{adviceId}")
    public Map<String, Object> getAdviceDetails(@PathVariable Integer adviceId) {
        return adviceService.getAdviceDetails(adviceId);
    }
}
