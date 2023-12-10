package com.nanterre.LoveMyPet.service.interfaces;

import java.util.List;
import java.time.LocalTime;

import com.nanterre.LoveMyPet.model.FeedingTime;

public interface FeedingTimeService {
    public void addFeedingTime(FeedingTime feedingTime);
    public List<String> getAnimalFeedingTimesReferences(Integer idAnimal);
    public FeedingTime getFeedingTimeDetailsById(Integer id) ;
    public void deleteFeedingTime(Integer id) ;
    FeedingTime updateFeedingTime(Integer id, FeedingTime updatedFeedingTime) ;
}
