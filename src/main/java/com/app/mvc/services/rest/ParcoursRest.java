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

import com.app.mvc.entity.Parcours;
import com.app.mvc.services.IParcourService;

@Controller
@RequestMapping(value = "/api/parcours/")
public class ParcoursRest {

	@Autowired
	IParcourService IParcourService;

	@ResponseStatus(value = HttpStatus.CREATED)
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public Parcours CreateParcours(@RequestBody Parcours Parcours) {
		return IParcourService.save(Parcours);
	}

	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json")
	@ResponseBody
	public Parcours UpdateParcours(@PathVariable(value = "id") Long id, @RequestBody Parcours Parcours) {
		if (id != null) {
			Parcours admi = IParcourService.findById(id);
			if (admi != null) {
				Parcours.setIdParcours(id);
				Parcours = IParcourService.update(Parcours);
				return Parcours;

			}
		}
		return null;

	}

	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	@ResponseBody
	public void DeletParcours(@RequestBody Parcours Parcours) {
		IParcourService.Delete(Parcours);
	}

	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	@ResponseBody
	public void DeletParcoursById(@PathVariable(value = "id") Long id) {
		if (id != null) {
			Parcours mob = IParcourService.findById(id);
			if (mob != null) {
				IParcourService.DeleteById(id);
			}
		}
	}

	@ResponseStatus(value = HttpStatus.FOUND)
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Parcours> getAllParcours() {
		List<Parcours> listParcoursx = IParcourService.FindAll();
		if (listParcoursx.isEmpty()) {
			listParcoursx = new ArrayList<Parcours>();
		}
		return listParcoursx;
	}

	@ResponseStatus(value = HttpStatus.FOUND)
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Object getById(@PathVariable(value = "id") Long id) {
		Object Parcours = IParcourService.findById(id);
		if (Parcours == null) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return Parcours;

	}

	@RequestMapping(value = "/*", method = RequestMethod.GET)
	public ResponseEntity<Void> getErrorPage() {
		return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
	}

}
