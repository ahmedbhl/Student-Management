package com.app.mvc.services.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.app.mvc.entity.Admin;
import com.app.mvc.services.IAdminService;

@Controller
@RequestMapping(value = "/api/admins/")
public class AdminRest {

	@Autowired
	IAdminService IAdminService;

	@ResponseStatus(value = HttpStatus.CREATED)
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public Admin CreateAdmin(@RequestBody Admin Admin) {
		return IAdminService.save(Admin);
	}

	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json")
	@ResponseBody
	public Admin UpdateAdmin(@PathVariable(value = "id") Long id, @RequestBody Admin Admin) {
		if (id != null) {
			Admin admi = IAdminService.findById(id);
			if (admi != null) {
				Admin.setIdAdmin(id);
				Admin = IAdminService.update(Admin);
				return Admin;

			}
		}
		return null;

	}

	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	@ResponseBody
	public void DeletAdmin(@RequestBody Admin Admin) {
		IAdminService.Delete(Admin);
	}

	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	@ResponseBody
	public void DeletAdminById(@PathVariable(value = "id") Long id) {
		if (id != null) {
			Admin mob = IAdminService.findById(id);
			if (mob != null) {
				IAdminService.DeleteById(id);
			}
		}
	}

	@ResponseStatus(value = HttpStatus.FOUND)
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Admin> getAllAdmin() {
		List<Admin> listAdminx = IAdminService.FindAll();
		if (listAdminx.isEmpty()) {
			listAdminx = new ArrayList<Admin>();
		}
		return listAdminx;
	}

	@ResponseStatus(value = HttpStatus.FOUND)
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Object getById(@PathVariable(value = "id") Long id) {
		Object Admin = IAdminService.findById(id);
		if (Admin == null) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return Admin;

	}

	@RequestMapping(value = "/*", method = RequestMethod.GET)
	public ResponseEntity<Void> getErrorPage() {
		return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
	}

}
