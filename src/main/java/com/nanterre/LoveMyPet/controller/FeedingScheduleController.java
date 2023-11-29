package com.nanterre.LoveMyPet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nanterre.LoveMyPet.model.FeedingSchedule;
import com.nanterre.LoveMyPet.service.FeedingScheduleServiceImpl;

@RestController
@RequestMapping("/api/feeding-schedules")
public class FeedingScheduleController {

    @Autowired
    private FeedingScheduleServiceImpl feedingScheduleService;

    @PostMapping
    public ResponseEntity<String> createFeedingSchedule(@RequestBody FeedingSchedule feedingSchedule) {
        FeedingSchedule createdSchedule = feedingScheduleService.createFeedingSchedule(feedingSchedule);
        int feedingFrequency = feedingSchedule.getFeedingFrequency();

        String successMessage = String.format("Feeding schedule created for %d times a day at the specified hours.", feedingFrequency);
        return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
    }
}
