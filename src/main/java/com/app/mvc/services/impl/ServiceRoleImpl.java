package com.app.mvc.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.app.mvc.dao.IRoleDAO;
import com.app.mvc.entity.Admin;
import com.app.mvc.entity.Role;
import com.app.mvc.services.IServiceRole;

@Transactional
public class ServiceRoleImpl implements IServiceRole {

	IRoleDAO dao;

	public void setDao(IRoleDAO dao) {
		this.dao = dao;
	}

	@Override
	public Role save(Role entity) {
		// TODO Auto-generated method stub
		return dao.save(entity);
	}

	@Override
	public Role update(Role entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}

	@Override
	public Role findById(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);//get();
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return dao.existsById(id);
	}

	@Override
	public Iterable<Role> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void deleteById(Long id) {
		dao.deleteById(id);
	}

	@Override
	public void delete(Role entity) {
		dao.delete(entity);
	}

	@Override
	public void saveRole(Admin user) {
		dao.saveRoleUser(user);
	}

	@Override
	public void saveRoleAdmin(Admin User) {
		dao.saveRoleAdmin(User);
	}

	@Override
	public void updateToAdmin(Long iduser) {
		dao.updateToAdmin(iduser);
	}

	@Override
	public void updateToUser(Long iduser) {
		dao.updateToUser(iduser);

	}

	@Override
	public void saveAllRole(List<Admin> user) {
		// TODO Auto-generated method stub
		dao.saveAllRole(user);
	}

}
