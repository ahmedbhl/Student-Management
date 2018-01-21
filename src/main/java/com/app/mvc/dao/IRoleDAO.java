package com.app.mvc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.mvc.entity.Admin;
import com.app.mvc.entity.Role;

public interface IRoleDAO extends JpaRepository<Role, Long> {

	public Role update(Role entity);

	public void updateToAdmin(Long iduser);

	public void updateToUser(Long iduser);

	public void saveRoleUser(Admin user);

	public void saveRoleAdmin(Admin User);

	public void saveAllRole(List<Admin> user);

}
