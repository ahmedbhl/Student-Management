package com.app.mvc.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.app.mvc.dao.IParcoursDAO;
import com.app.mvc.entity.Parcours;
import com.app.mvc.services.IParcourService;

@Transactional
public class ParcoursServiceImpl implements IParcourService {

	private IParcoursDAO dao;

	public void setDao(IParcoursDAO dao) {
		this.dao = dao;
	}

	@Override
	public Parcours save(Parcours entity) {
		// TODO Auto-generated method stub
		return dao.save(entity);
	}

	@Override
	public Parcours update(Parcours entity) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(entity);
	}

	@Override
	public Parcours findById(Long idParcours) {
		// TODO Auto-generated method stub
		return dao.findById(idParcours).orElse(null);//get();
	}

	@Override
	public List<Parcours> FindAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void Delete(Parcours entity) {
		// TODO Auto-generated method stub
		dao.delete(entity);
	}

	@Override
	public void DeleteById(Long idParcours) {
		// TODO Auto-generated method stub
		dao.deleteById(idParcours);
	}

}
