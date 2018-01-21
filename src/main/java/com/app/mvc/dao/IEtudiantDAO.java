package com.app.mvc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.mvc.entity.Etudiant;

public interface IEtudiantDAO extends JpaRepository<Etudiant, Long> {

	public Boolean FindByMail(String mail);

	public Etudiant finByCin(int cin);

	public Boolean existByCin(int cin);

	public Etudiant finByNom(String nom);

	public List<Etudiant> finByClasse(String codeClasse);

	public List<Etudiant> finByParcour(String designation);

	public List<Etudiant> finByParcourNiveau(String designation, String niveau);

}
