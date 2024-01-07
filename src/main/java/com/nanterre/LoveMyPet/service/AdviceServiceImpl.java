package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.Advice;
import com.nanterre.LoveMyPet.model.Comment;
import com.nanterre.LoveMyPet.model.HistoriqueWeight;
import com.nanterre.LoveMyPet.model.Person;
import com.nanterre.LoveMyPet.repository.AdviceRepository;
import com.nanterre.LoveMyPet.repository.CommentRepository;
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
    @Autowired
    private CommentRepository commentRepository;


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
        adviceDetails.put("comments", advice.getComments());
        return adviceDetails;
    }



    @Override
    public void addAdvice(Advice advice) {
        adviceRepository.save(advice);
    }
    
    @Override
    public void addCommentToAdvice(Integer adviceId, String commentText, Integer idPerson) {
        Advice advice = adviceRepository.findById(adviceId).orElse(null);

        if (advice != null) {
            Comment comment = new Comment();
            comment.setText(commentText);

            // Créer un objet Person avec l'ID fourni
            Person commenter = new Person();
            commenter.setIdPerson(idPerson);
            comment.setCommenter(commenter);

            // Ajouter le commentaire à l'avis
            advice.addComment(comment);

            // Mettre à jour la base de données
            adviceRepository.save(advice);
        }
    }
    
    @Override 
    public List<String> getCommentLinksByAdviceId(Integer adviceId) {
        Advice advice = adviceRepository.findById(adviceId).orElse(null);

        return advice.getComments().stream()
                .map(comment -> "/advice/" + adviceId + "/comment/" + comment.getCommentId())
                .collect(Collectors.toList());
    }
    @Override
    public Comment getCommentDetailsById(Integer commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }
    
    @Override
    public List<Comment> getCommentsByAdviceId(Integer adviceId) {
        Advice advice = adviceRepository.findById(adviceId).orElse(null);


        return advice.getComments();
    }
}

