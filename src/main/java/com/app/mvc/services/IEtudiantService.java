package com.app.mvc.services;

import java.util.List;

import com.app.mvc.entity.Etudiant;

public interface IEtudiantService {

	public Etudiant save(Etudiant entity);

	public Etudiant update(Etudiant entity);

	public Etudiant findById(Long idEtudiant);

	public List<Etudiant> FindAll();

	public void Delete(Etudiant entity);

	public void DeleteById(Long idEtudiant);

	public Boolean FindByMail(String mail);

	public Etudiant finByCin(int cin);

	public Etudiant finByNom(String nom);

	public List<Etudiant> finByClasse(String codeClasse);

	public List<Etudiant> finByParcour(String designation);

	public List<Etudiant> finByParcourNiveau(String designation, String niveau);

	public Boolean existByCin(int cin);
}
