package com.app.mvc.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.app.mvc.dao.IEtudiantDAO;
import com.app.mvc.entity.Etudiant;
import com.app.mvc.services.IEtudiantService;

@Transactional
public class EtudiantServiceImpl implements IEtudiantService {

	private IEtudiantDAO dao;

	public void setDao(IEtudiantDAO dao) {
		this.dao = dao;
	}

	@Override
	public Etudiant save(Etudiant entity) {
		// TODO Auto-generated method stub
		return dao.save(entity);
	}

	@Override
	public Etudiant update(Etudiant entity) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(entity);
	}

	@Override
	public Etudiant findById(Long idEtudiant) {
		// TODO Auto-generated method stub
		return dao.findById(idEtudiant).orElse(null);// .get();
	}

	@Override
	public List<Etudiant> FindAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void Delete(Etudiant entity) {
		// TODO Auto-generated method stub
		dao.delete(entity);
	}

	@Override
	public void DeleteById(Long idEtudiant) {
		// TODO Auto-generated method stub
		dao.deleteById(idEtudiant);
	}

	@Override
	public Boolean FindByMail(String mail) {
		// TODO Auto-generated method stub
		return dao.FindByMail(mail);
	}

	@Override
	public Etudiant finByCin(int cin) {
		return dao.finByCin(cin);
	}

	@Override
	public Etudiant finByNom(String nom) {
		return dao.finByNom(nom);
	}

	@Override
	public List<Etudiant> finByClasse(String codeClasse) {
		return dao.finByClasse(codeClasse);
	}

	@Override
	public List<Etudiant> finByParcour(String designation) {
		return dao.finByParcour(designation);
	}

	@Override
	public List<Etudiant> finByParcourNiveau(String designation, String niveau) {
		return dao.finByParcourNiveau(designation, niveau);
	}

	@Override
	public Boolean existByCin(int cin) {
		// TODO Auto-generated method stub
		return dao.existByCin(cin);
	}

}
