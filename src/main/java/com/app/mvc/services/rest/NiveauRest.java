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

import com.app.mvc.entity.Niveau;
import com.app.mvc.services.INiveauService;

@Controller
@RequestMapping(value = "/api/niveaux")
public class NiveauRest {

	@Autowired
	INiveauService INiveauService;

	//@ResponseStatus(value = HttpStatus.CREATED)
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public Object CreateNiveau(@RequestBody Niveau Niveau) {
		try {
			if (Niveau == null) {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
			return INiveauService.save(Niveau);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		
	}

	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json")
	@ResponseBody
	public Niveau UpdateNiveau(@PathVariable(value = "id") Long id, @RequestBody Niveau Niveau) {
		if (id != null) {
			Niveau niveau = INiveauService.findById(id);
			if (niveau != null) {
				Niveau.setIdNiveau(id);
				Niveau = INiveauService.update(Niveau);
				return Niveau;

			}
		}
		return null;

	}

	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	@ResponseBody
	public void DeletNiveau(@RequestBody Niveau Niveau) {
		INiveauService.Delete(Niveau);
	}

	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	@ResponseBody
	public void DeletNiveauById(@PathVariable(value = "id") Long id) {
		if (id != null) {
			Niveau mob = INiveauService.findById(id);
			if (mob != null) {
				INiveauService.DeleteById(id);
			}
		}
	}

	//@ResponseStatus(value = HttpStatus.FOUND)
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Niveau> getAllNiveau() {
		List<Niveau> listNiveaux = INiveauService.FindAll();
		if (listNiveaux.isEmpty()) {
			listNiveaux = new ArrayList<Niveau>();
		}
		return listNiveaux;
	}

	//@ResponseStatus(value =HttpStatus.FOUND)
	@RequestMapping(value = "/{idNiveau}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Object  getById(@PathVariable(value = "idNiveau") Long id) {
		Object  niveau=INiveauService.findById(id);
		if(niveau==null)
		{
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return niveau;

	}
	

	@RequestMapping(value = "/*", method = RequestMethod.GET)
	public ResponseEntity<Void> getErrorPage() {
		return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
	}

}
