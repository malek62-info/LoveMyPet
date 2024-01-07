package com.nanterre.LoveMyPet.model;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
public class Advice {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adviceId;

    @ManyToOne
    @JoinColumn(name = "idPerson")
    private Person author;

    private String textAdvice;

    private String imageUrl; // Path to the image


    public Advice() {
    }
    // Constructeur avec paramètres
    public Advice(Integer adviceId, Person author, String textAdvice, String imageUrl, List<LikeDislike> likeDislikes,List<Comment> comments) {
        this.adviceId = adviceId;
        this.author = author;
        this.textAdvice = textAdvice;
        this.imageUrl = imageUrl;
        this.likeDislikes = likeDislikes;
        this.comments = comments;
    }

    @OneToMany(mappedBy = "advice", cascade = CascadeType.ALL)
    private List<LikeDislike> likeDislikes;
    
    @OneToMany(mappedBy = "advice", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Comment> comments;
    
    public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	


    // Other fields, getters, and setters

    public Integer getAdviceId() {
        return adviceId;
    }

    public void setAdviceId(Integer adviceId) {
        this.adviceId = adviceId;
    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    public String getTextAdvice() {
        return textAdvice;
    }

    public void setTextAdvice(String textAdvice) {
        this.textAdvice = textAdvice;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    public List<LikeDislike> getLikeDislikes() {
        return likeDislikes;
    }

    public void setLikeDislikes(List<LikeDislike> likeDislikes) {
        this.likeDislikes = likeDislikes;
    }

    public int getLikeCount() {
        return (int) likeDislikes.stream().filter(LikeDislike::isLike).count();
    }

    public int getDislikeCount() {
        return (int) likeDislikes.stream().filter(likeDislike -> !likeDislike.isLike()).count();
    }
    public void addComment(Comment comment) {
        comments.add(comment);
        comment.setAdvice(this);
    }
}
