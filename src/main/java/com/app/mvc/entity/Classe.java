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
public class Classe implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long idClasse;

	@NotNull(message = "Champ obligatoire")
	@Size(min = 3, message = "Le code de classe doit contenir au moins 3 caractères")
	private String codeClasse;

	@NotNull(message = "Champ obligatoire")
	@Size(min = 6, message = "La designation doit contenir au moins 6 caractères")
	private String designClasseFr;

	@NotNull(message = "Champ obligatoire")
	@Size(min = 6, message = "La designation doit contenir au moins 6 caractères")
	private String designClasseAr;

	@NotNull(message = "Champ obligatoire")
	@ManyToOne
	@JoinColumn(name = "idParcours")
	private Parcours parcour;

	@JsonIgnore
	@OneToMany(mappedBy = "classe", cascade = { CascadeType.REMOVE })
	private List<Etudiant> etudiants;

	public Classe() {
		super();
	}

	public Long getIdClasse() {
		return idClasse;
	}

	public void setIdClasse(Long idClasse) {
		this.idClasse = idClasse;
	}

	public String getCodeClasse() {
		return codeClasse;
	}

	public void setCodeClasse(String codeClasse) {
		this.codeClasse = codeClasse;
	}

	public String getDesignClasseFr() {
		return designClasseFr;
	}

	public void setDesignClasseFr(String designClasseFr) {
		this.designClasseFr = designClasseFr;
	}

	public String getDesignClasseAr() {
		return designClasseAr;
	}

	public void setDesignClasseAr(String designClasseAr) {
		this.designClasseAr = designClasseAr;
	}

	public Parcours getParcour() {
		return parcour;
	}

	public void setParcour(Parcours parcour) {
		this.parcour = parcour;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

}
