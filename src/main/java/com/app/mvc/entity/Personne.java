package com.app.mvc.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Personne implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long idPersonne;

	@NotNull(message = "Champ obligatoire")
	@Size(min = 3, message = "Le Nom doit contenir au moins 3 caractères")
	private String nomFr;

	@NotNull(message = "Champ obligatoire")
	@Size(min = 3, message = "Le Nom doit contenir au moins 3 caractères")
	private String nomAr;

	@NotNull(message = "Champ obligatoire")
	@Size(min = 3, message = "Le prénom doit contenir au moins 3 caractères")
	private String prenomFr;

	@NotNull(message = "Champ obligatoire")
	@Size(min = 3, message = "Le prénom doit contenir au moins 3 caractères")
	private String prenomAr;

	@NotNull(message = "Champ obligatoire")
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;

	private String nationalite;

	@NotNull(message = "Champ obligatoire")
	private String sexe;

	private String lieuNaissanceFr;

	private String lieuNaissanceAr;

	@NotNull(message = "Champ obligatoire")
	@Size(min = 3, message = "L'addresse doit contenir au moins 6 caractères")
	private String addresseFr;

	@NotNull(message = "Champ obligatoire")
	@Size(min = 3, message = "L'addresse doit contenir au moins 6 caractères")
	private String addresseAr;

	@NotNull(message = "Champ obligatoire")
	@Size(min = 3, message = "La ville doit contenir au moins 3 caractères")
	private String villeFr;

	@NotNull(message = "Champ obligatoire")
	@Size(min = 3, message = "Le ville doit contenir au moins 3 caractères")
	private String villeAr;

	@NotNull(message = "Champ obligatoire")
	@Range(min = 01000000, max = 99999999, message = "Le CIN doit contenir 8 chiffres ")
	private int cin;

	@NotNull(message = "Champ obligatoire")
	private String email;

	@NotNull(message = "Champ obligatoire")
	@Range(min = 10000000, message = "Le Num Tel doit contenir 8 chiffres ")
	private int tel;

	@NotNull(message = "Champ obligatoire")
	private String codePostal;

	private String photos;

	@Transient
	private String fullNameFr;

	@Transient
	private String fullNameAr;

	@Transient
	private String oldEmail;

	@Transient
	private int oldCIN;

	public Personne() {
		super();
	}

	public Long getIdPersonne() {
		return idPersonne;
	}

	public void setIdPersonne(Long idPersonne) {
		this.idPersonne = idPersonne;
	}

	public String getNomFr() {
		return nomFr;
	}

	public void setNomFr(String nomFr) {
		this.nomFr = nomFr;
	}

	public String getNomAr() {
		return nomAr;
	}

	public void setNomAr(String nomAr) {
		this.nomAr = nomAr;
	}

	public String getPrenomFr() {
		return prenomFr;
	}

	public void setPrenomFr(String prenomFr) {
		this.prenomFr = prenomFr;
	}

	public String getPrenomAr() {
		return prenomAr;
	}

	public void setPrenomAr(String prenomAr) {
		this.prenomAr = prenomAr;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getLieuNaissanceFr() {
		return lieuNaissanceFr;
	}

	public void setLieuNaissanceFr(String lieuNaissanceFr) {
		this.lieuNaissanceFr = lieuNaissanceFr;
	}

	public String getLieuNaissanceAr() {
		return lieuNaissanceAr;
	}

	public void setLieuNaissanceAr(String lieuNaissanceAr) {
		this.lieuNaissanceAr = lieuNaissanceAr;
	}

	public String getAddresseFr() {
		return addresseFr;
	}

	public void setAddresseFr(String addresseFr) {
		this.addresseFr = addresseFr;
	}

	public String getAddresseAr() {
		return addresseAr;
	}

	public void setAddresseAr(String addresseAr) {
		this.addresseAr = addresseAr;
	}

	public String getVilleFr() {
		return villeFr;
	}

	public void setVilleFr(String villeFr) {
		this.villeFr = villeFr;
	}

	public String getVilleAr() {
		return villeAr;
	}

	public void setVilleAr(String villeAr) {
		this.villeAr = villeAr;
	}

	public int getCin() {
		return cin;
	}

	public void setCin(int cin) {
		this.cin = cin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getPhotos() {
		return photos;
	}

	public void setPhotos(String photos) {
		this.photos = photos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getFullNameFr() {
		fullNameFr = getPrenomFr() + " " + getNomFr();
		return fullNameFr;
	}

	public void setFullNameFr(String fullNameFr) {
		this.fullNameFr = fullNameFr;
	}

	public String getFullNameAr() {
		fullNameFr = getPrenomAr() + " " + getNomAr();
		return fullNameAr;
	}

	public void setFullNameAr(String fullNameAr) {
		this.fullNameAr = fullNameAr;
	}

	public String getOldEmail() {
		return oldEmail;
	}

	public void setOldEmail(String oldEmail) {
		this.oldEmail = oldEmail;
	}

	public int getOldCIN() {
		return oldCIN;
	}

	public void setOldCIN(int oldCIN) {
		this.oldCIN = oldCIN;
	}

}
