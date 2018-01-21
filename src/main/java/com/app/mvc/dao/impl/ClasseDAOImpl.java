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

import com.app.mvc.dao.IClasseDAO;
import com.app.mvc.entity.Classe;

public class ClasseDAOImpl implements IClasseDAO {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Classe> findAll() {
		// TODO Auto-generated method stub
		Query q = em.createQuery("from Classe c");
		return q.getResultList();
	}

	@Override
	public List<Classe> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Classe> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Classe> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends Classe> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return em.merge(entity);
	}

	@Override
	public void deleteInBatch(Iterable<Classe> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub

	}

	@Override
	public Classe getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Classe> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Classe> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Classe> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Classe> S save(S entity) {
		// TODO Auto-generated method stub
		if (entity != null) {
			em.persist(entity);
		}
		return entity;
	}

	@Override
	public Optional<Classe> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(em.find(Classe.class, id));
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
		Classe Classe = em.find(Classe.class, id);
		if (Classe != null) {
			em.remove(em.contains(Classe) ? Classe : em.merge(Classe));	

		}
	}

	@Override
	public void delete(Classe entity) {
		// TODO Auto-generated method stub
		em.remove(em.contains(entity) ? entity : em.merge(entity));	
	}

	@Override
	public void deleteAll(Iterable<? extends Classe> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends Classe> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Classe> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Classe> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Classe> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

}
