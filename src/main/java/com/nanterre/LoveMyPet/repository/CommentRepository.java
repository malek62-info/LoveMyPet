package com.nanterre.LoveMyPet.repository;

import com.nanterre.LoveMyPet.model.Comment;


import org.springframework.data.jpa.repository.JpaRepository;


public interface CommentRepository  extends JpaRepository<Comment, Integer> {


}
