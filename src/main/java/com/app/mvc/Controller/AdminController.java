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

import com.app.mvc.entity.Admin;
import com.app.mvc.services.IAdminService;
import com.app.mvc.services.IEtudiantService;
import com.app.mvc.services.IServiceRole;
import com.app.mvc.util.CryptPassword;

@Controller
@RequestMapping(value = "/admins")
public class AdminController {
	
	@Autowired
	IAdminService IAdminService;
	
	@Autowired
	IServiceRole IServiceRole;
	
	@Autowired
	IEtudiantService IEtudiantService;
	
	@Autowired
	CryptPassword CryptPassword;
	
	
	
	@RequestMapping("/")
	public String getListAdmin(Model model) {
		List<Admin> Admins = IAdminService.FindAll();
		if(Admins==null)
		{
			Admins=new ArrayList<Admin>();
		}
		model.addAttribute("listadmins", Admins);
		return "admin/admin";
	}

	@RequestMapping(value = "/nouveau", method = RequestMethod.GET)
	public String ajouterAdmin(Model model) {
		Admin Admin = new Admin();
		model.addAttribute("admin", Admin);
		return "admin/ajouteradmin";
	}

	@RequestMapping(value = "/enregistrer", method = RequestMethod.POST)
	public String saveAdmin(Model model, @Valid Admin admin, BindingResult result, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {

			return "admin/ajouteradmin";
		} else {
			if (admin != null) {
				
				if (admin.getIdAdmin() != null) {
					//check mail exist in the data base and if oldmail equals to new mail if the operation update
					if ((IEtudiantService.FindByMail(admin.getEmail()) || IAdminService.FindByMail(admin.getEmail())) && (!admin.getOldEmail().equals(admin.getEmail())) ) {
						result.rejectValue("email", "error.admin", "Un utilisateur existe déjà pour cet e-mail.");
						return "admin/ajouteradmin";
					}
					//if password changed then we need to crypt the password to md5
					if(!admin.getMotDePasse().equals(admin.getOldmotDePasse()))
					{
						admin.setMotDePasse(CryptPassword.getCryptedPassword(admin.getMotDePasse()));
					}
					IAdminService.update(admin);
				} else {
					//check mail exist in the data base if the operation create
					if (IEtudiantService.FindByMail(admin.getEmail()) || IAdminService.FindByMail(admin.getEmail())) {
						result.rejectValue("email", "error.admin", "Un utilisateur existe déjà pour cet e-mail.");
						return "admin/ajouteradmin";
					}
					admin.setMotDePasse(CryptPassword.getCryptedPassword(admin.getMotDePasse()));
					IAdminService.save(admin);
					IServiceRole.saveRoleAdmin(admin);

				}
			}
		}
		return "redirect:/admins/";
	}

	@RequestMapping("/supprimer/{id}")
	public String deleteAdmin(@PathVariable("id") Long idAdmin, Model model) {
		if (idAdmin != null) {
			Admin Admin = IAdminService.findById(idAdmin);
			if (Admin != null) {
				IAdminService.Delete(Admin);
			}
		}
		return "redirect:/admins/";
	}

	@RequestMapping("/modifier/{id}")
	public String updateAdmin(@PathVariable("id") Long idAdmin, Model model) {
		if (idAdmin != null) {

			Admin Admin = IAdminService.findById(idAdmin);
			if (Admin != null) {
				Admin.setOldEmail(Admin.getEmail());
				Admin.setOldmotDePasse(Admin.getMotDePasse());
				model.addAttribute("admin", Admin);
			}
		}
		return "admin/ajouteradmin";
	}

	@RequestMapping("/modifierEtat/{id}")
	public String modifierEtat(@PathVariable("id") Long idAdmin, Model model) {
		if (idAdmin != null) {

			Admin Admin = IAdminService.findById(idAdmin);
			if (Admin != null) {
				Admin.setActived(!Admin.isActived());
				IAdminService.update(Admin);
			}
		}
		return "redirect:/admins/";
	}

	@RequestMapping(value = "/*", method = RequestMethod.GET)
	public String getErrorPage() {
		return "redirect:/Access_Denied/404";
	}


}
