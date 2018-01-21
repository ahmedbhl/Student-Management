package com.app.mvc.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.mvc.entity.Admin;
import com.app.mvc.services.IAdminService;
import com.app.mvc.util.CryptPassword;

@Controller
@RequestMapping(value = "/reset")
public class ResetPasswordController {

	@Autowired
	IAdminService IAdminService;

	@Autowired
	CryptPassword cryptMD5;

	@RequestMapping(value = "/")
	public String resetpassword(ModelMap model) {

		return "login/resetpassword";
	}

	@RequestMapping(value = "/nvmotdepasse", method = RequestMethod.POST)
	public String reset(ModelMap model, @RequestParam String key, @RequestParam String mail) {
		Admin user = IAdminService.FindBypassword(key, mail);
		if (user != null) {
			model.addAttribute("userid", user.getIdAdmin());
			model.addAttribute("action", user);
			return "login/resetpasswordForm";
		} else {
			model.addAttribute("msgerror", "Le clé ou le mail invalide.");
			model.addAttribute("error", "true");
			return "login/resetpassword";
		}
	}

	@RequestMapping(value = "/savepassword")
	public String savepassord(ModelMap model, RedirectAttributes redirectAttributes, @RequestParam String password1,
			@RequestParam String password2, @RequestParam Long id, @RequestParam String action,
			HttpServletRequest request) {

		if (id != null && !action.isEmpty()) {

			Admin user = null;
			if (password1.isEmpty() || password2.isEmpty()) {
				model.addAttribute("msgerror", "les champs ne doivent pas être vides");
				model.addAttribute("error", "true");
				model.addAttribute("userid", id);
				model.addAttribute("action", action);
				return "login/resetpasswordForm";
			}
			if (!password1.equals(password2)) {
				model.addAttribute("msgerror", "les deux mots de passe ne sont pas identiques");
				model.addAttribute("error", "true");
				model.addAttribute("userid", id);
				model.addAttribute("action", action);
				return "login/resetpasswordForm";
			}
			user = IAdminService.findById(id);

			if (user != null) {
				user.setMotDePasse(cryptMD5.getCryptedPassword(password1));
				IAdminService.update(user);
				model.addAttribute("success", "Votre mot de passe mis à jour avec succès.");
				model.addAttribute("error", false);
				id = null;
				action = null;
				return "login/resetpassword";
			} else {
				model.addAttribute("msgerror", "Une erreur est survenue. veuillez réessayer ultérieurement.");
				model.addAttribute("error", "true");
				return "login/resetpassword";
			}
		} else {
			model.addAttribute("msgerror", "Une erreur est survenue. veuillez réessayer ultérieurement.");
			model.addAttribute("error", "true");
			return "login/resetpassword";
		}
	}
}
