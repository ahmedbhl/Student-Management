package com.app.mvc.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.app.mvc.dao.IClasseDAO;
import com.app.mvc.entity.Classe;
import com.app.mvc.services.IClasseService;

@Transactional
public class ClasseServiceImpl implements IClasseService {

	private IClasseDAO dao;

	public void setDao(IClasseDAO dao) {
		this.dao = dao;
	}

	@Override
	public Classe save(Classe entity) {
		// TODO Auto-generated method stub
		return dao.save(entity);
	}

	@Override
	public Classe update(Classe entity) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(entity);
	}

	@Override
	public Classe findById(Long idClasse) {
		// TODO Auto-generated method stub
		return dao.findById(idClasse).orElse(null);//get();
	}

	@Override
	public List<Classe> FindAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void Delete(Classe entity) {
		// TODO Auto-generated method stub
		dao.delete(entity);
	}

	@Override
	public void DeleteById(Long idClasse) {
		// TODO Auto-generated method stub
		dao.deleteById(idClasse);
	}

}
