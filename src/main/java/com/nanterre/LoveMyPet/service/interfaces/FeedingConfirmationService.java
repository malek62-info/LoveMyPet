package com.nanterre.LoveMyPet.service.interfaces;

public interface FeedingConfirmationService {
    public boolean confirmFeeding(Integer personId, Integer animalId, Integer feedingTimeId, String confirmationCode);
}

