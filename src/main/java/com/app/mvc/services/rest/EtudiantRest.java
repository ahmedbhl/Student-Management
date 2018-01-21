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

import com.app.mvc.entity.Etudiant;
import com.app.mvc.services.IEtudiantService;

@Controller
@RequestMapping(value = "/api/etudiants/")
public class EtudiantRest {

	@Autowired
	IEtudiantService IEtudiantService;

	@ResponseStatus(value = HttpStatus.CREATED)
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public Etudiant CreateEtudiant(@RequestBody Etudiant Etudiant) {
		Etudiant.setIdPersonne(null);
		return IEtudiantService.save(Etudiant);
	}

	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json")
	@ResponseBody
	public Etudiant UpdateEtudiant(@PathVariable(value = "id") Long id, @RequestBody Etudiant Etudiant) {
		if (id != null) {
			Etudiant etud = IEtudiantService.findById(id);
			if (etud != null) {
				Etudiant.setIdPersonne(id);
				Etudiant = IEtudiantService.update(Etudiant);
				return Etudiant;

			}
		}
		return null;

	}

	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	@ResponseBody
	public void DeletEtudiant(@RequestBody Etudiant Etudiant) {
		IEtudiantService.Delete(Etudiant);
	}

	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	@ResponseBody
	public void DeletEtudiantById(@PathVariable(value = "id") Long id) {
		if (id != null) {
			Etudiant mob = IEtudiantService.findById(id);
			if (mob != null) {
				IEtudiantService.DeleteById(id);
			}
		}
	}

	@ResponseStatus(value = HttpStatus.FOUND)
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Etudiant> getAllEtudiant() {
		List<Etudiant> listEtudiantx = IEtudiantService.FindAll();
		if (listEtudiantx.isEmpty()) {
			listEtudiantx = new ArrayList<Etudiant>();
		}
		return listEtudiantx;
	}

	@ResponseStatus(value = HttpStatus.FOUND)
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Object getById(@PathVariable(value = "id") Long id) {
		Object Etudiant = IEtudiantService.findById(id);
		if (Etudiant == null) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return Etudiant;

	}
	
	@ResponseStatus(value = HttpStatus.FOUND)
	@RequestMapping(value = "/nom/{nom}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Object getBynom(@PathVariable(value = "nom") String name) {
		Object Etudiant = IEtudiantService.finByNom(name);
		if (Etudiant == null) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return Etudiant;

	}
	
	@ResponseStatus(value = HttpStatus.FOUND)
	@RequestMapping(value = "/cin/{cin}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Object getBynCIN(@PathVariable int cin) {
		Object Etudiant = IEtudiantService.finByCin(cin);
		if (Etudiant == null) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return Etudiant;

	}
	
	@ResponseStatus(value = HttpStatus.FOUND)
	@RequestMapping(value = "/classe/{codeClasse}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Object getBynClasse(@PathVariable String codeClasse) {
		List<Etudiant> Etudiant = IEtudiantService.finByClasse(codeClasse);
		if (Etudiant == null) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return Etudiant;

	}
	
	@ResponseStatus(value = HttpStatus.FOUND)
	@RequestMapping(value = "/specialite/{specialite}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Object getBynParcour(@PathVariable String specialite) {
		List<Etudiant> Etudiant = IEtudiantService.finByParcour(specialite);
		if (Etudiant == null) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return Etudiant;

	}
	
	@ResponseStatus(value = HttpStatus.FOUND)
	@RequestMapping(value = "/specialite/{specialite}/niveau/{niveau}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Object getBynParcouNiveau(@PathVariable String specialite,@PathVariable String niveau) {
		List<Etudiant> Etudiant = IEtudiantService.finByParcourNiveau(specialite, niveau);
		if (Etudiant == null) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return Etudiant;

	}

	@RequestMapping(value = "/*", method = RequestMethod.GET)
	public ResponseEntity<Void> getErrorPage() {
		return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
	}

}
