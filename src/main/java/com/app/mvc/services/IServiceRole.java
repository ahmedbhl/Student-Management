package com.app.mvc.services;

import java.util.List;

import com.app.mvc.entity.Admin;
import com.app.mvc.entity.Role;

public interface IServiceRole {

	public Role save(Role entity);

	public Role findById(Long id);

	public boolean existsById(Long id);

	public Iterable<Role> findAll();

	public void deleteById(Long id);

	public void delete(Role entitys);

	public Role update(Role entity);

	public void saveRole(Admin user);

	public void saveAllRole(List<Admin> user);

	public void saveRoleAdmin(Admin Admin);

	public void updateToAdmin(Long idAdmin);

	public void updateToUser(Long iduser);

}