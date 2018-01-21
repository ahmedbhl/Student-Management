package com.app.mvc.services;

import java.util.List;

import com.app.mvc.entity.Classe;

public interface IClasseService {

	public Classe save(Classe entity);

	public Classe update(Classe entity);

	public Classe findById(Long idClasse);

	public List<Classe> FindAll();

	public void Delete(Classe entity);

	public void DeleteById(Long idClasse);

}
