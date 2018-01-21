package com.app.mvc.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.mvc.entity.Niveau;
import com.app.mvc.entity.Parcours;
import com.app.mvc.services.INiveauService;
import com.app.mvc.services.IParcourService;

@Controller
@RequestMapping(value = "/parcours")
public class ParcourController {

	@Autowired
	IParcourService IParcourService;

	@Autowired
	INiveauService INiveauService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getlistparcours(Model model) {
		model.addAttribute("listparcour", IParcourService.FindAll());
		return "parcour/parcour";
	}

	@RequestMapping(value = "/nouveau", method = RequestMethod.GET)
	public String ajouterparcour(Model model) {
		Parcours parcour = new Parcours();
		List<Niveau> niveau = INiveauService.FindAll();
		if (niveau == null) {
			niveau = new ArrayList<Niveau>();
		}
		model.addAttribute("listniveau", niveau);
		model.addAttribute("parcours", parcour);
		return "parcour/ajouterparcour";
	}

	@RequestMapping(value = "enregistrer", method = RequestMethod.POST)
	public String saveparcour(Model model, @Valid Parcours parcours, BindingResult result,
			RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			List<Niveau> niveau = INiveauService.FindAll();
			if (niveau == null) {
				niveau = new ArrayList<Niveau>();
			}
			model.addAttribute("listniveau", niveau);
			return "parcour/ajouterparcour";
		} else {
			if (parcours.getIdParcours() != null) {
				IParcourService.update(parcours);
				redirectAttributes.addFlashAttribute("successMsg", "Le parcour a été modifié avec succès");
			} else {
				IParcourService.save(parcours);
				redirectAttributes.addFlashAttribute("successMsg", "Le parcour a été ajouté avec succès");
			}

		}

		return "redirect:/parcours/";
	}

	@RequestMapping("/supprimer/{id}")
	public String deleteparcour(@PathVariable("id") Long idparcour, Model model) {
		if (idparcour != null) {
			Parcours parcour = IParcourService.findById(idparcour);
			if (parcour != null) {
				IParcourService.Delete(parcour);
			}
		}
		return "redirect:/parcours/";
	}

	@RequestMapping("/modifier/{id}")
	public String updateparcour(@PathVariable("id") Long idparcour, Model model) {
		if (idparcour != null) {
			Parcours parcour = IParcourService.findById(idparcour);
			if (parcour != null) {
				model.addAttribute("parcours", parcour);
			}
			List<Niveau> niveau = INiveauService.FindAll();
			if (niveau == null) {
				niveau = new ArrayList<Niveau>();
			}
			model.addAttribute("listniveau", niveau);
		}
		return "parcour/ajouterparcour";
	}

	@RequestMapping(value = "/*", method = RequestMethod.GET)
	public String getErrorPage() {
		return "redirect:/Access_Denied/404";
	}

}
