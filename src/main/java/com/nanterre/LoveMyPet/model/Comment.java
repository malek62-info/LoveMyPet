package com.nanterre.LoveMyPet.model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;

    @ManyToOne
    @JoinColumn(name = "adviceId")
    @JsonBackReference
    private Advice advice;

    @ManyToOne
    @JoinColumn(name = "idPerson")
    private Person commenter;

    public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public Advice getAdvice() {
		return advice;
	}

	public void setAdvice(Advice advice) {
		this.advice = advice;
	}

	public Person getCommenter() {
		return commenter;
	}

	public void setCommenter(Person commenter) {
		this.commenter = commenter;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	private String text;

    
}
