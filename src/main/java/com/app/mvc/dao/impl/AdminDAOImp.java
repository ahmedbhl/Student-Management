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

import com.app.mvc.dao.IAdminDAO;
import com.app.mvc.entity.Admin;

public class AdminDAOImp implements IAdminDAO {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Admin> findAll() {
		// TODO Auto-generated method stub
		// Find All Admin Except The super Admin
		Query q = em.createQuery("From Admin a where a.email!=?1").setParameter(1, "admin@admin.com");
		return q.getResultList();
	}

	@Override
	public List<Admin> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Admin> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Admin> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends Admin> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return em.merge(entity);
	}

	@Override
	public void deleteInBatch(Iterable<Admin> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub

	}

	@Override
	public Admin getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <S extends Admin> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		Query q = em.createQuery("From Admin a");
		return q.getResultList();
	}

	@Override
	public <S extends Admin> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Admin> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Admin> S save(S entity) {
		// TODO Auto-generated method stub
		if (entity != null) {
			em.persist(entity);
		}
		return entity;
	}

	@Override
	public Optional<Admin> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(em.find(Admin.class, id));
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
		Admin Admin = em.find(Admin.class, id);
		if (Admin != null) {
			em.remove(em.contains(Admin) ? Admin : em.merge(Admin));
		}
	}

	@Override
	public void delete(Admin entity) {
		// TODO Auto-generated method stub
		em.remove(em.contains(entity) ? entity : em.merge(entity));

	}

	@Override
	public void deleteAll(Iterable<? extends Admin> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends Admin> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Admin> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Admin> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Admin> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Boolean FindByMail(String mail) {
		Query q = em.createQuery("from Admin a where a.email=?1").setParameter(1, mail);
		if (!q.getResultList().isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public Admin FindBypassword(String password, String mail) {
		Query q = em.createQuery("from Admin a where a.motDePasse=?1 AND a.email=?2").setParameter(1, password)
				.setParameter(2, mail);
		if (!q.getResultList().isEmpty()) {
			return (Admin) q.getSingleResult();
		}
		return null;
	}

}
