package com.app.mvc.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.app.mvc.dao.IAdminDAO;
import com.app.mvc.entity.Admin;
import com.app.mvc.services.IAdminService;
import com.app.mvc.util.CryptPassword;

@Transactional
public class AdminServiceImpl implements IAdminService {

	private IAdminDAO dao;

	@SuppressWarnings("unused")
	private CryptPassword cryptMD5;

	public void setDao(IAdminDAO dao) {
		this.dao = dao;
	}

	public void setCryptMD5(CryptPassword cryptMD5) {
		this.cryptMD5 = cryptMD5;
	}

	@Override
	public Admin save(Admin entity) {
		// TODO Auto-generated method stub
		return dao.save(entity);
	}

	@Override
	public Admin update(Admin entity) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(entity);
	}

	@Override
	public Admin findById(Long idAdmin) {
		// TODO Auto-generated method stub
		return dao.findById(idAdmin).orElse(null);//get();
	}

	@Override
	public List<Admin> FindAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void Delete(Admin entity) {
		// TODO Auto-generated method stub
		dao.delete(entity);
	}

	@Override
	public void DeleteById(Long idAdmin) {
		// TODO Auto-generated method stub
		dao.deleteById(idAdmin);
	}

	@Override
	public Boolean FindByMail(String mail) {
		// TODO Auto-generated method stub
		return dao.FindByMail(mail);
	}

	@Override
	public Admin FindBypassword(String password, String mail) {
		// TODO Auto-generated method stub
		return dao.FindBypassword(password, mail);
	}

}
