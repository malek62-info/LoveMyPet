package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.FeedingTime;

import java.util.List;

interface FeedingTimeService {
    public void addFeedingTime(FeedingTime feedingTime);
    public List<String> getAnimalFeedingTimesReferences(Integer idAnimal);
    public FeedingTime getFeedingTimeDetailsById(Integer id) ;
    public void deleteFeedingTime(Integer id) ;
    FeedingTime updateFeedingTime(Integer id, FeedingTime updatedFeedingTime) ;

    //detail email et animal
    public List<Object[]> getInfosCurrentFeedingTimes();
}