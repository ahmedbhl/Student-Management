package com.app.mvc.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class Parcours implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long idParcours;

	@NotNull(message = "Champ obligatoire")
	@Size(min = 6, message = "La designation doit contenir au moins 6 caractères")
	private String designParcours;

	@NotNull(message = "Champ obligatoire")
	private int semestreDeb;

	@NotNull(message = "Champ obligatoire")
	private int duree;

	@NotNull(message = "Champ obligatoire")
	@ManyToOne
	@JoinColumn(name = "idNiveau")
	private Niveau niveau;

	@JsonIgnore
	@OneToMany(mappedBy = "parcour", cascade = { CascadeType.REMOVE })
	private List<Classe> classes;

	public Parcours() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdParcours() {
		return idParcours;
	}

	public void setIdParcours(Long idParcours) {
		this.idParcours = idParcours;
	}

	public String getDesignParcours() {
		return designParcours;
	}

	public void setDesignParcours(String designParcours) {
		this.designParcours = designParcours;
	}

	public int getSemestreDeb() {
		return semestreDeb;
	}

	public void setSemestreDeb(int semestreDeb) {
		this.semestreDeb = semestreDeb;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public Niveau getNiveau() {
		return niveau;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}

	public List<Classe> getClasses() {
		return classes;
	}

	public void setClasses(List<Classe> classes) {
		this.classes = classes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
