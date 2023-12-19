package com.nanterre.LoveMyPet.service;

public interface LikeDislikeService {
    public void addLike(Integer adviceId, Integer personId, boolean isLike);

    public void addDislike(Integer adviceId, Integer personId, boolean isLike) ;
}
