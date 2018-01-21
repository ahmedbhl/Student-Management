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

import com.app.mvc.dao.INiveauDAO;
import com.app.mvc.entity.Niveau;

public class NiveauDAOImpl implements INiveauDAO {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Niveau> findAll() {
		// TODO Auto-generated method stub
		Query q = em.createQuery("From Niveau n");
		return q.getResultList();
	}

	@Override
	public List<Niveau> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Niveau> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Niveau> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends Niveau> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return em.merge(entity);
	}

	@Override
	public void deleteInBatch(Iterable<Niveau> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub

	}

	@Override
	public Niveau getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Niveau> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Niveau> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Niveau> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Niveau> S save(S entity) {
		// TODO Auto-generated method stub
		if (entity != null) {
			em.persist(entity);
		}
		return entity;
	}

	@Override
	public Optional<Niveau> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(em.find(Niveau.class, id));
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
		Niveau Niveau = em.find(Niveau.class, id);
		if (Niveau != null) {

			em.remove(em.contains(Niveau) ? Niveau : em.merge(Niveau));
		}
	}

	@Override
	public void delete(Niveau entity) {
		// TODO Auto-generated method stub

		em.remove(em.contains(entity) ? entity : em.merge(entity));
	}

	@Override
	public void deleteAll(Iterable<? extends Niveau> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends Niveau> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Niveau> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Niveau> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Niveau> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

}
