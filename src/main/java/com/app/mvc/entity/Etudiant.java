package com.app.mvc.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Etudiant extends Personne {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String situationdepart;

	private String profPere;

	private String profMere;

	@NotNull(message = "Champ obligatoire")
	@Temporal(TemporalType.DATE)
	private Date datePremierInscri;

	@NotNull(message = "Champ obligatoire")
	@Size(min = 6, message = "Le code CNSS doit contenir au moins 6 caractères")
	private String codeCNSS;

	private Boolean dispoSport = false;

	@NotNull(message = "Champ obligatoire")
	@ManyToOne
	@JoinColumn(name = "idClasse")
	private Classe classe;

	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getSituationdepart() {
		return situationdepart;
	}

	public void setSituationdepart(String situationdepart) {
		this.situationdepart = situationdepart;
	}

	public String getProfPere() {
		return profPere;
	}

	public void setProfPere(String profPere) {
		this.profPere = profPere;
	}

	public String getProfMere() {
		return profMere;
	}

	public void setProfMere(String profMere) {
		this.profMere = profMere;
	}

	public Date getDatePremierInscri() {
		return datePremierInscri;
	}

	public void setDatePremierInscri(Date datePremierInscri) {
		this.datePremierInscri = datePremierInscri;
	}

	public String getCodeCNSS() {
		return codeCNSS;
	}

	public void setCodeCNSS(String codeCNSS) {
		this.codeCNSS = codeCNSS;
	}

	public Boolean getDispoSport() {
		return dispoSport;
	}

	public void setDispoSport(Boolean dispoSport) {
		this.dispoSport = dispoSport;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
