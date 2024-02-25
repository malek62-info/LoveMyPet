package com.nanterre.LoveMyPet.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Traitement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idtraitement")
	private Integer idTraitement;

	@ManyToOne
	@JoinColumn(name = "idmedicament", referencedColumnName = "idmedicament")
	private Medicament medicament;

	@ManyToOne
	@JoinColumn(name = "idanimal", referencedColumnName = "idAnimal")
	private Animal animal;

	@Temporal(TemporalType.DATE)
	@Column(name = "datedebut")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateDebut;

	@Temporal(TemporalType.DATE)
	@Column(name = "datefin")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateFin;

	@Column(name = "nombre_prises")
	private Integer nombrePrises; // Nombre de fois que le traitement se prend

	@Column(name = "commentaire", length = 1000) // longueur maximale du commentaire
	private String commentaire; // Commentaire sur le traitement

	// Champ pour stocker le fichier de type image ou PDF
	@Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "fichier", length = 1048576) // 1 Mo
    private byte[] fichier;

	// Relation One-to-Many avec la classe Heure
    @OneToMany(mappedBy = "traitement", cascade = CascadeType.ALL)
    private List<Heure> heures;
    
	// Getters and setters

	public Integer getIdTraitement() {
		return idTraitement;
	}

	public void setIdTraitement(Integer idTraitement) {
		this.idTraitement = idTraitement;
	}

	public Medicament getMedicament() {
		return medicament;
	}

	public void setMedicament(Medicament medicament) {
		this.medicament = medicament;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Integer getNombrePrises() {
		return nombrePrises;
	}

	public void setNombrePrises(Integer nombrePrises) {
		this.nombrePrises = nombrePrises;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public byte[] getFichier() {
		return fichier;
	}

	public void setFichier(byte[] fichier) {
		this.fichier = fichier;
	}
	
	public List<Heure> getHeures() {
        return heures;
    }

    public void setHeures(List<Heure> heures) {
        this.heures = heures;
    }

}
