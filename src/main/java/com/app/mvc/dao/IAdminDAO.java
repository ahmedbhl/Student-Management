package com.app.mvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.mvc.entity.Admin;

public interface IAdminDAO extends JpaRepository<Admin, Long> {

	public Boolean FindByMail(String mail);

	public Admin FindBypassword(String password, String mail);

}
