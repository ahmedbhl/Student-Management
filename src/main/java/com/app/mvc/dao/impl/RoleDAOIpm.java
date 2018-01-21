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

import com.app.mvc.dao.IRoleDAO;
import com.app.mvc.entity.Admin;
import com.app.mvc.entity.Role;

public class RoleDAOIpm implements IRoleDAO {

	@PersistenceContext
	EntityManager em;
	private static final String ROLE_USER = "ROLE_USER";
	private static final String ROLE_ADMIN = "ROLE_ADMIN";

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> findAll() {
		List<Role> roles;
		Query q = em.createQuery("from Role r");
		roles = q.getResultList();
		return roles;
	}

	@Override
	public List<Role> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Role> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends Role> S saveAndFlush(S entity) {
		em.merge(entity);
		return entity;
	}

	@Override
	public void deleteInBatch(Iterable<Role> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub

	}

	@Override
	public Role getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Role> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Role> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Role> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Role> S save(S entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public Optional<Role> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(em.find(Role.class, id));
	}

	@Override
	public boolean existsById(Long id) {
		if (em.find(Role.class, id) != null) {
			return true;
		}
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		if (existsById(id)) {
			em.remove(em.find(Role.class, id));
		}

	}

	@Override
	public void delete(Role entity) {
		em.remove(em.contains(entity) ? entity : em.merge(entity));

	}

	@Override
	public void deleteAll(Iterable<? extends Role> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends Role> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Role> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Role> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Role> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Role update(Role entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateToAdmin(Long iduser) {
		// TODO Auto-generated method stub
		Role roleuser = em.find(Role.class, iduser);
		roleuser.setRoleName(ROLE_ADMIN);
		em.merge(roleuser);
	}

	@Override
	public void saveRoleAdmin(Admin User) {
		// TODO Auto-generated method stub
		em.persist(new Role(ROLE_ADMIN, User));
	}

	@Override
	public void saveAllRole(List<Admin> users) {
		// TODO Auto-generated method stub
		for (Admin Admin : users) {

			em.persist(new Role(ROLE_ADMIN, Admin));
		}
	}

	@Override
	public void updateToUser(Long iduser) {

		Role roleuser = em.find(Role.class, iduser);
		roleuser.setRoleName(ROLE_USER);
		em.merge(roleuser);

	}

	@Override
	public void saveRoleUser(Admin user) {
		em.persist(new Role(ROLE_USER, user));

	}

}