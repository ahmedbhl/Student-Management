package com.app.mvc.dao.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.app.mvc.dao.IParcoursDAO;
import com.app.mvc.entity.Parcours;

public class ParcourDAOImpl implements IParcoursDAO {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Parcours> findAll() {
		// TODO Auto-generated method stub
		Query q = em.createQuery("From Parcours p");
		return q.getResultList();
	}

	@Override
	public List<Parcours> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Parcours> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Parcours> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends Parcours> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return em.merge(entity);
	}

	@Override
	public void deleteInBatch(Iterable<Parcours> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub

	}

	@Override
	public Parcours getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Parcours> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Parcours> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Parcours> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Parcours> S save(S entity) {
		// TODO Auto-generated method stub
		if (entity != null) {
			em.persist(entity);
		}
		return entity;
	}

	@Override
	public Optional<Parcours> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(em.find(Parcours.class, id));
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		Parcours parcour = em.find(Parcours.class, id);
		if (parcour != null) {
			em.remove(em.contains(parcour) ? parcour : em.merge(parcour));
		}
	}

	@Override
	public void delete(Parcours entity) {
		// TODO Auto-generated method stub
		em.remove(em.contains(entity) ? entity : em.merge(entity));
	}

	@Override
	public void deleteAll(Iterable<? extends Parcours> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends Parcours> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Parcours> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Parcours> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Parcours> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

}
