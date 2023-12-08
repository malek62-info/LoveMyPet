package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.FeedingSchedule;
import com.nanterre.LoveMyPet.model.Person;

import java.time.LocalTime;
import java.util.List;

public interface FeedingScheduleService {
    FeedingSchedule createFeedingSchedule(FeedingSchedule feedingSchedule);

    //email utilisateur avec feeding time == maintenant
    public List<String> getUsersWithCurrentFeedingTime();

    public List<LocalTime> getFeedingTimesForAnimal(Long animalId);
}
