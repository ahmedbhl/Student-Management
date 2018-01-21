package com.app.mvc.services;

import java.util.List;

import com.app.mvc.entity.Niveau;

public interface INiveauService {

	public Niveau save(Niveau entity);

	public Niveau update(Niveau entity);

	public Niveau findById(Long idNiveau);

	public List<Niveau> FindAll();

	public void Delete(Niveau entity);

	public void DeleteById(Long idNiveau);
}
