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

import com.app.mvc.entity.Classe;
import com.app.mvc.services.IClasseService;

@Controller
@RequestMapping(value = "/api/classes/")
public class ClasseRest {

	@Autowired
	IClasseService IClasseService;

	@ResponseStatus(value = HttpStatus.CREATED)
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public Classe CreateClasse(@RequestBody Classe Classe) {
		return IClasseService.save(Classe);
	}

	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json")
	@ResponseBody
	public Classe UpdateClasse(@PathVariable(value = "id") Long id, @RequestBody Classe Classe) {
		if (id != null) {
			Classe admi = IClasseService.findById(id);
			if (admi != null) {
				Classe.setIdClasse(id);
				Classe = IClasseService.update(Classe);
				return Classe;

			}
		}
		return null;

	}

	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	@ResponseBody
	public void DeletClasse(@RequestBody Classe Classe) {
		IClasseService.Delete(Classe);
	}

	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	@ResponseBody
	public void DeletClasseById(@PathVariable(value = "id") Long id) {
		if (id != null) {
			Classe mob = IClasseService.findById(id);
			if (mob != null) {
				IClasseService.DeleteById(id);
			}
		}
	}

	@ResponseStatus(value = HttpStatus.FOUND)
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Classe> getAllClasse() {
		List<Classe> listClassex = IClasseService.FindAll();
		if (listClassex.isEmpty()) {
			listClassex = new ArrayList<Classe>();
		}
		return listClassex;
	}

	@ResponseStatus(value = HttpStatus.FOUND)
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Object getById(@PathVariable(value = "id") Long id) {
		Object Classe = IClasseService.findById(id);
		if (Classe == null) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return Classe;

	}

	@RequestMapping(value = "/*", method = RequestMethod.GET)
	public ResponseEntity<Void> getErrorPage() {
		return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
	}

}
