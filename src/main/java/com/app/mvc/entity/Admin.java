package com.app.mvc.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class Admin implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long idAdmin;

	@NotNull(message = "Champ obligatoire")
	@Size(min = 3, message = "Le Nom doit contenir au moins 3 caractères")
	private String nom;

	@NotNull(message = "Champ obligatoire")
	@Size(min = 3, message = "Le Prénom doit contenir au moins 3 caractères")
	private String prenom;

	@NotNull(message = "Champ obligatoire")
	private String email;

	private String numTel;

	@NotNull(message = "Champ obligatoire")
	@Size(min = 3, message = "Le Mot De Passe doit contenir au moins 3 caractères")
	private String motDePasse;

	@Transient
	private String FullName;

	@Transient
	private String oldEmail;
	
	@Transient
	private String oldmotDePasse;
	
	@JsonIgnore
	@OneToMany(mappedBy = "admin", cascade = { CascadeType.REMOVE })
	private List<Role> roleUsers;

	private boolean Actived;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(Long idAdmin) {
		this.idAdmin = idAdmin;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Role> getRoleUsers() {
		return roleUsers;
	}

	public void setRoleUsers(List<Role> roleUsers) {
		this.roleUsers = roleUsers;
	}

	public boolean isActived() {
		return Actived;
	}

	public void setActived(boolean actived) {
		Actived = actived;
	}

	public String getFullName() {
		return getPrenom() + " " + getNom();
	}

	public void setFullName(String fullName) {
		this.FullName = fullName;
	}

	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	public String getOldEmail() {
		return oldEmail;
	}

	public void setOldEmail(String oldEmail) {
		this.oldEmail = oldEmail;
	}

	public String getOldmotDePasse() {
		return oldmotDePasse;
	}

	public void setOldmotDePasse(String oldmotDePasse) {
		this.oldmotDePasse = oldmotDePasse;
	}

}
