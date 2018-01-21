package com.app.mvc.services;

import java.util.List;

import com.app.mvc.entity.Parcours;

public interface IParcourService {

	public Parcours save(Parcours entity);

	public Parcours update(Parcours entity);

	public Parcours findById(Long idParcours);

	public List<Parcours> FindAll();

	public void Delete(Parcours entity);

	public void DeleteById(Long idParcours);

}
