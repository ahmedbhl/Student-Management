package com.app.mvc.Controller;

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
import com.app.mvc.services.INiveauService;

@Controller
@RequestMapping(value = "/niveau")
public class NiveauController {

	@Autowired
	INiveauService iserviceNiveau;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getListNiveau(Model model) {
		model.addAttribute("listniveau", iserviceNiveau.FindAll());
		return "niveau/niveau";
	}

	@RequestMapping(value = "/nouveau", method = RequestMethod.GET)
	public String ajouterNiveau(Model model) {
		Niveau niveau = new Niveau();
		model.addAttribute("niveau", niveau);
		return "niveau/ajouterNiveau";
	}

	@RequestMapping(value = "enregistrer", method = RequestMethod.POST)
	public String saveNiveau(Model model,@Valid Niveau niveau, BindingResult result, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "niveau/ajouterNiveau";
		} else {
			if(niveau!=null)
			{
				iserviceNiveau.update(niveau);
				redirectAttributes.addFlashAttribute("successMsg", "Le niveau a été modifié avec succès");
			}
			else
			{
				iserviceNiveau.save(niveau);
				redirectAttributes.addFlashAttribute("successMsg", "Le niveau a été ajouté avec succès");
			}
			
		}

		return "redirect:/niveau/";
	}

	@RequestMapping("/supprimer/{id}")
	public String deleteEnseignant(@PathVariable("id") Long idNiveau, Model model) {
		if (idNiveau != null) {
			Niveau niveau = iserviceNiveau.findById(idNiveau);
			if (niveau != null) {
				iserviceNiveau.Delete(niveau);
			}
		}
		return "redirect:/niveau/";
	}

	@RequestMapping("/modifier/{id}")
	public String updateEnseignant(@PathVariable("id") Long idNiveau, Model model) {
		if (idNiveau != null) {

			Niveau niveau = iserviceNiveau.findById(idNiveau);
			if (niveau != null) {
				model.addAttribute("niveau", niveau);
			}
		}
		return "niveau/ajouterNiveau";
	}
	
	@RequestMapping(value = "/*", method = RequestMethod.GET)
	public String getErrorPage() {
		return "redirect:/Access_Denied/404";
	}
}
