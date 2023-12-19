package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.*;
import com.nanterre.LoveMyPet.repository.AdviceRepository;
import com.nanterre.LoveMyPet.repository.LikeDislikeRepository;
import com.nanterre.LoveMyPet.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CandidatureService {
    //public List<Candidature> getCandidaturesByAnimalId(Integer animalId);
    public List<String> getCandidatureLinksByAnimalId(Integer animalId);
    Candidature getCandidatureDetailsByAnimalIdAndCandidatureId(Integer animalId, Integer candidatureId);
    void saveCandidature(Candidature candidature);
    void deleteCandidature(Candidature candidature);



    @Service
    class LikeDislikeServiceImpl implements LikeDislikeService {

        @Autowired
        private LikeDislikeRepository likeDislikeRepository;

        @Autowired
        private AdviceRepository adviceRepository;

        @Autowired
        private PersonRepository personRepository;

        @Override
        public void addLike(Integer adviceId, Integer personId, boolean isLike) {
            Advice advice = adviceRepository.findById(adviceId)
                    .orElseThrow(() -> new ResourceNotFoundException("Advice not found"));

            Person existingPerson = personRepository.findById(personId)
                    .orElseThrow(() -> new ResourceNotFoundException("Person not found with ID: " + personId));

            // Check if the person has already interacted with the advice
            LikeDislike existingInteraction = likeDislikeRepository.findByAdviceAndPerson(advice, existingPerson);
            if (existingInteraction != null) {
                // If the person has already interacted, update the existing interaction only if changing from dislike to like
                if (!existingInteraction.isLike() && isLike) {
                    existingInteraction.setLike(isLike);
                    likeDislikeRepository.save(existingInteraction);
                }
            } else {
                // If the person has not interacted, create a new interaction
                LikeDislike like = new LikeDislike();
                like.setAdvice(advice);
                like.setPerson(existingPerson);
                like.setLike(isLike);
                likeDislikeRepository.save(like);
            }
        }

        @Override
        public void addDislike(Integer adviceId, Integer personId, boolean isLike) {
            Advice advice = adviceRepository.findById(adviceId)
                    .orElseThrow(() -> new ResourceNotFoundException("Advice not found"));

            Person existingPerson = personRepository.findById(personId)
                    .orElseThrow(() -> new ResourceNotFoundException("Person not found with ID: " + personId));

            // Check if the person has already interacted with the advice
            LikeDislike existingInteraction = likeDislikeRepository.findByAdviceAndPerson(advice, existingPerson);
            if (existingInteraction != null) {
                // If the person has already interacted, update the existing interaction only if changing from like to dislike
                if (existingInteraction.isLike() && !isLike) {
                    existingInteraction.setLike(isLike);
                    likeDislikeRepository.save(existingInteraction);
                }
            } else {
                // If the person has not interacted, create a new interaction
                LikeDislike dislike = new LikeDislike();
                dislike.setAdvice(advice);
                dislike.setPerson(existingPerson);
                dislike.setLike(isLike);
                likeDislikeRepository.save(dislike);
            }
        }
    }
}

