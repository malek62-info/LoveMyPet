package com.nanterre.LoveMyPet.controller;

import java.util.Map;

import com.nanterre.LoveMyPet.service.CandidatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nanterre.LoveMyPet.model.Person;
import com.nanterre.LoveMyPet.repository.PersonRepository;
import com.nanterre.LoveMyPet.service.ResourceNotFoundException;

@RestController
@RequestMapping("/api/like-dislike")
public class LikeDislikeController {

    @Autowired
    private CandidatureService.LikeDislikeServiceImpl likeDislikeService;

    @Autowired
    private PersonRepository personRepository;

    @PostMapping("/like")
    public ResponseEntity<String> addLike(@RequestBody Map<String, Object> request) {
        Integer adviceId = (Integer) request.get("advice_id");
        Integer personId = (Integer) request.get("person_id");

        // Par défaut, isLike est true pour l'action "like"
        Boolean isLike = true;

        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found with ID: " + personId));

        likeDislikeService.addLike(adviceId, person.getIdPerson(), isLike);
        return new ResponseEntity<>("Like added successfully", HttpStatus.CREATED);
    }

    @PostMapping("/dislike")
    public ResponseEntity<String> addDislike(@RequestBody Map<String, Object> request) {
        Integer adviceId = (Integer) request.get("advice_id");
        Integer personId = (Integer) request.get("person_id");

        // Par défaut, isLike est false pour l'action "dislike"
        Boolean isLike = false;

        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found with ID: " + personId));

        likeDislikeService.addDislike(adviceId, person.getIdPerson(), isLike);
        return new ResponseEntity<>("Dislike added successfully", HttpStatus.CREATED);
    }
}

