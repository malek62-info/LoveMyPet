package com.nanterre.LoveMyPet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nanterre.LoveMyPet.model.Advice;
import com.nanterre.LoveMyPet.model.LikeDislike;
import com.nanterre.LoveMyPet.model.Person;


@Repository
public interface LikeDislikeRepository extends JpaRepository<LikeDislike, Integer> {
  /* *@Query(value = "SELECT * FROM like_dislike ld WHERE ld.advice_id = :adviceId AND ld.person_id = :personId AND ld.is_like = :isLike", nativeQuery = true)
    LikeDislike findByAdviceAndPersonAndIsLike(@Param("adviceId") Integer adviceId, @Param("personId") Integer personId, @Param("isLike") boolean isLike);
*/
@Query("SELECT ld FROM LikeDislike ld WHERE ld.advice = :advice AND ld.person = :person")
LikeDislike findByAdviceAndPerson(@Param("advice") Advice advice, @Param("person") Person person);


}


