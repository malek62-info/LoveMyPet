package com.nanterre.LoveMyPet.controller;

import com.nanterre.LoveMyPet.service.implementations.FeedingConfirmationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



import com.nanterre.LoveMyPet.model.FeedingConfirmation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feeding-confirmation")
public class FeedingConfirmationController {

    @Autowired
    private FeedingConfirmationServiceImpl feedingConfirmationService;

    @GetMapping("/confirm")
    public String confirmFeeding(
            @RequestParam Integer personId,
            @RequestParam Integer animalId,
            @RequestParam Integer feedingTimeId,
            @RequestParam String confirmationCode
    ) {
        if (feedingConfirmationService.confirmFeeding(personId, animalId, feedingTimeId, confirmationCode)) {
            // Redirection vers la page de confirmation
            return "Comfirmation réussie";
        } else {
            return "Failed to confirm feeding.";
        }
    }
}




