package com.app.mvc.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class Niveau implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long idNiveau;

	@NotNull(message = "Champ obligatoire")
	@Size(min = 6, message = "La designation doit contenir au moins 6 caractères")
	private String designNiveauFr;

	@NotNull(message = "Champ obligatoire")
	@Size(min = 6, message = "La designation doit contenir au moins 6 caractères")
	private String designNiveauAr;

	@JsonIgnore
	@OneToMany(mappedBy = "niveau", cascade = { CascadeType.REMOVE,CascadeType.MERGE})
	private List<Parcours> parcours;

	public Niveau() {
		super();
	}

	public Niveau(String designNiveauFr, String designNiveauAr) {
		super();
		this.designNiveauFr = designNiveauFr;
		this.designNiveauAr = designNiveauAr;
	}

	public Niveau(Long idNiveau, String designNiveauFr, String designNiveauAr) {
		super();
		this.idNiveau = idNiveau;
		this.designNiveauFr = designNiveauFr;
		this.designNiveauAr = designNiveauAr;
	}

	public Long getIdNiveau() {
		return idNiveau;
	}

	public void setIdNiveau(Long idNiveau) {
		this.idNiveau = idNiveau;
	}

	public String getDesignNiveauFr() {
		return designNiveauFr;
	}

	public void setDesignNiveauFr(String designNiveauFr) {
		this.designNiveauFr = designNiveauFr;
	}

	public String getDesignNiveauAr() {
		return designNiveauAr;
	}

	public void setDesignNiveauAr(String designNiveauAr) {
		this.designNiveauAr = designNiveauAr;
	}

	public List<Parcours> getParcours() {
		return parcours;
	}

	public void setParcours(List<Parcours> parcours) {
		this.parcours = parcours;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
