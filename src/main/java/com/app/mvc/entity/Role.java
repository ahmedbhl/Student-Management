package com.app.mvc.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idRole;
	private String roleName;

	@ManyToOne
	@JoinColumn(name = "idAdmin")
	private Admin admin;

	@Transient
	private String nameOfRole;

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(String roleName, Admin Admin) {
		super();
		this.roleName = roleName;
		this.admin = Admin;
	}

	public Long getIdRole() {
		return idRole;
	}

	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getNameOfRole() {
		return nameOfRole.substring(5);
	}

	public void setNameOfRole(String nameOfRole) {
		this.nameOfRole = nameOfRole;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
