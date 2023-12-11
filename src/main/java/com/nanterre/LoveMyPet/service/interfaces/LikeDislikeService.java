package com.nanterre.LoveMyPet.service.interfaces;

import com.nanterre.LoveMyPet.model.Person;

public interface LikeDislikeService {
    public void addLike(Integer adviceId, Integer personId, boolean isLike);

    public void addDislike(Integer adviceId, Integer personId, boolean isLike) ;
}
