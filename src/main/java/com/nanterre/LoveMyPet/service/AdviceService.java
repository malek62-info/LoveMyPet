package com.nanterre.LoveMyPet.service;



import com.nanterre.LoveMyPet.model.Advice;
import com.nanterre.LoveMyPet.model.Comment;

import java.util.List;
import java.util.Map;

public  interface AdviceService {
    List<String> getAllAdviceReferences();
    Map<String, Object> getAdviceDetails(Integer adviceId);
    void addAdvice(Advice advice);
    void addCommentToAdvice(Integer adviceId, String commentText, Integer idPerson) ;
    List<Comment> getCommentsByAdviceId(Integer adviceId);
    Comment getCommentDetailsById(Integer commentId);
    List<String> getCommentLinksByAdviceId(Integer adviceId);
}

