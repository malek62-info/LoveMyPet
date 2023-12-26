package com.nanterre.LoveMyPet.model;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "historique_weight")
public class HistoriqueWeight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idhistorique")
    private Integer id;

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdAnimal() {
		return idAnimal;
	}

	public void setIdAnimal(Integer idAnimal) {
		this.idAnimal = idAnimal;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "idanimal")
    private Integer idAnimal;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    // Getters and setters
}
