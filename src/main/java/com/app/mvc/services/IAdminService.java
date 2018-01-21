package com.app.mvc.services;

import java.util.List;

import com.app.mvc.entity.Admin;

public interface IAdminService {

	public Admin save(Admin entity);

	public Admin update(Admin entity);

	public Admin findById(Long idAdmin);

	public List<Admin> FindAll();
	
	public void Delete(Admin entity);
	
	public void DeleteById(Long idAdmin);
	
	public Boolean FindByMail(String mail);
	
	public Admin FindBypassword(String password, String mail);

}
