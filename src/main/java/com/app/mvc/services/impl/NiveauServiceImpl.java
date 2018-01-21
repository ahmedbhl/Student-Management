package com.app.mvc.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.app.mvc.dao.INiveauDAO;
import com.app.mvc.entity.Niveau;
import com.app.mvc.services.INiveauService;

@Transactional
public class NiveauServiceImpl implements INiveauService {

	private INiveauDAO dao;

	public void setDao(INiveauDAO dao) {
		this.dao = dao;
	}

	@Override
	public Niveau save(Niveau entity) {
		// TODO Auto-generated method stub
		return dao.save(entity);
	}

	@Override
	public Niveau update(Niveau entity) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(entity);
	}

	@Override
	public Niveau findById(Long idNiveau) {
		// TODO Auto-generated method stub
		return dao.findById(idNiveau).orElse(null);//get();
	}

	@Override
	public List<Niveau> FindAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void Delete(Niveau entity) {
		// TODO Auto-generated method stub
		dao.delete(entity);
	}

	@Override
	public void DeleteById(Long idNiveau) {
		// TODO Auto-generated method stub
		dao.deleteById(idNiveau);
	}

}
