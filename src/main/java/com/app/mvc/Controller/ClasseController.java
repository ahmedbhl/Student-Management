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

import com.app.mvc.entity.Classe;
import com.app.mvc.entity.Parcours;
import com.app.mvc.services.IClasseService;
import com.app.mvc.services.IParcourService;

@Controller
@RequestMapping(value = "/classes")
public class ClasseController {

	@Autowired
	IClasseService IClasseService;

	@Autowired
	IParcourService IParcourService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getListClasses(Model model) {
		model.addAttribute("listclasse", IClasseService.FindAll());
		return "classes/classes";
	}

	@RequestMapping(value = "/nouveau", method = RequestMethod.GET)
	public String ajouterclasse(Model model) {
		Classe classe = new Classe();
		List<Parcours> parcours =IParcourService.FindAll();
		if (parcours == null) {
			parcours = new ArrayList<Parcours>();
		}
		model.addAttribute("listparcours", parcours);
		model.addAttribute("classe", classe);
		return "classes/ajouterclasse";
	}

	@RequestMapping(value = "enregistrer", method = RequestMethod.POST)
	public String saveClasse(Model model, @Valid Classe classe, BindingResult result,
			RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			List<Parcours> parcours =IParcourService.FindAll();
			if (parcours == null) {
				parcours = new ArrayList<Parcours>();
			}
			model.addAttribute("listparcours", parcours);
			return "classes/ajouterclasse";
		} else {
			if (classe.getIdClasse() != null) {
				IClasseService.update(classe);
				redirectAttributes.addFlashAttribute("successMsg", "Le classe a été modifié avec succès");
			} else {
				IClasseService.save(classe);
				redirectAttributes.addFlashAttribute("successMsg", "Le classe a été ajouté avec succès");
			}

		}

		return "redirect:/classes/";
	}

	@RequestMapping("/supprimer/{id}")
	public String deleteClasse(@PathVariable("id") Long idClasse, Model model) {
		if (idClasse != null) {
			Classe classe = IClasseService.findById(idClasse);
			if (classe != null) {
				IClasseService.Delete(classe);
			}
		}
		return "redirect:/classes/";
	}

	@RequestMapping("/modifier/{id}")
	public String updateClasse(@PathVariable("id") Long idClasse, Model model) {
		if (idClasse != null) {

			Classe classe = IClasseService.findById(idClasse);
			if (classe != null) {
				model.addAttribute("classe", classe);
			}
			List<Parcours> parcours =IParcourService.FindAll();
			if (parcours == null) {
				parcours = new ArrayList<Parcours>();
			}
			model.addAttribute("listparcours", parcours);
		}
		return "classes/ajouterclasse";
	}

	@RequestMapping(value = "/*", method = RequestMethod.GET)
	public String getErrorPage() {
		return "redirect:/Access_Denied/404";
	}

}
