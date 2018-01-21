package com.app.mvc.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.mvc.entity.Classe;
import com.app.mvc.entity.Etudiant;
import com.app.mvc.services.IAdminService;
import com.app.mvc.services.IClasseService;
import com.app.mvc.services.IEtudiantService;
import com.app.mvc.services.IFlickrService;

@Controller
@RequestMapping(value = "/etudiants")
public class EtudiantController {
	private static final List<String> contentTypes = Arrays.asList("image/png", "image/jpeg", "image/gif");

	@Autowired
	IEtudiantService IEtudiantService;

	@Autowired
	IClasseService IClasseService;

	@Autowired
	IFlickrService IFlickrService;
	
	@Autowired
	IAdminService IAdminService;

	@Autowired
	ServletContext servletContext;
	private static final Logger LOGGER = LoggerFactory.getLogger(EtudiantController.class);
	private static final String REDIRECTETUDIANT = "redirect:/etudiants/";
	private static final String AJOUTERETUDIANT="etudiant/ajouteretudiant";
	

	@InitBinder
	public final void initBinderUsuariosFormValidator(final WebDataBinder binder, final Locale locale) {
		final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getListetudiant(Model model) {
		model.addAttribute("listetudiant", IEtudiantService.FindAll());
		return "etudiant/etudiant";
	}

	@RequestMapping(value = "/nouveau", method = RequestMethod.GET)
	public String ajouteretudiant(Model model) {

		Etudiant etudiant = new Etudiant();
		List<Classe> classe = IClasseService.FindAll();
		if (classe == null) {
			classe = new ArrayList<Classe>();
		}
		model.addAttribute("listclasse", classe);
		model.addAttribute("etudiant", etudiant);
		return AJOUTERETUDIANT;
	}

	@RequestMapping(value = "enregistrer", method = RequestMethod.POST)
	public String saveetudiant(Model model, @Valid Etudiant etudiant, BindingResult result,
			RedirectAttributes redirectAttributes, MultipartFile file) throws Exception {
		String photoUrl = "https://c1.staticflickr.com/5/4679/27622367909_fdb23990af_z.jpg";

		if (result.hasErrors()) {
			List<Classe> classe = IClasseService.FindAll();
			if (classe == null) {
				classe = new ArrayList<Classe>();
			}
			model.addAttribute("listclasse", classe);
			return AJOUTERETUDIANT;
		} else {
			if (file != null && !file.isEmpty()) {
				InputStream stream = null;
				String fileContentType = file.getContentType();
				if (!contentTypes.contains(fileContentType)) {
					result.rejectValue("photos", "error.etudiant", "L'extension de l'image invalide.");
					List<Classe> classe = IClasseService.FindAll();
					if (classe == null) {
						classe = new ArrayList<Classe>();
					}
					model.addAttribute("listclasse", classe);
					return AJOUTERETUDIANT;
				}
				try {
					stream = file.getInputStream();
					String photosName = etudiant.getNomAr() + etudiant.getCin();
					photoUrl = IFlickrService.savePhoto(stream, photosName);
				} catch (Exception e) {
					LOGGER.info("context", e);
					e.printStackTrace();

				} finally {
					try {
						stream.close();
					} catch (IOException e) {
						LOGGER.info("context", e);
						e.printStackTrace();

					}

				}
				etudiant.setPhotos(photoUrl);
			}

			if (etudiant.getIdPersonne() != null) {
				if ((IEtudiantService.FindByMail(etudiant.getEmail()) || IAdminService.FindByMail(etudiant.getEmail())) && (!etudiant.getOldEmail().equals(etudiant.getEmail())) ) {
					result.rejectValue("email", "error.etudiant", "Un utilisateur existe déjà pour cet e-mail.");
					return AJOUTERETUDIANT;
				}
				if ((IEtudiantService.existByCin(etudiant.getCin())!=null)  && (etudiant.getOldCIN()!=etudiant.getCin()) ){
					result.rejectValue("cin", "error.etudiant", "Un utilisateur existe déjà pour ce CIN.");
					return AJOUTERETUDIANT;
				}
				IEtudiantService.update(etudiant);
				redirectAttributes.addFlashAttribute("successMsg", "Le etudiant a été modifié avec succès");
			} else {
				//check mail exist in the data base if the operation create
				if (IEtudiantService.FindByMail(etudiant.getEmail()) || IAdminService.FindByMail(etudiant.getEmail())) {
					result.rejectValue("email", "error.etudiant", "Un utilisateur existe déjà pour cet e-mail.");
					return AJOUTERETUDIANT;
				}
				if (IEtudiantService.existByCin(etudiant.getCin())){
					result.rejectValue("cin", "error.etudiant", "Un utilisateur existe déjà pour ce CIN."); 
					return AJOUTERETUDIANT;
				}
				etudiant.setPhotos(photoUrl);
				IEtudiantService.save(etudiant);
				redirectAttributes.addFlashAttribute("successMsg", "Le etudiant a été ajouté avec succès");
			}

		}

		return REDIRECTETUDIANT;
	}

	@RequestMapping("/supprimer/{id}")
	public String deleteetudiant(@PathVariable("id") Long idetudiant, Model model) {
		if (idetudiant != null) {
			Etudiant etudiant = IEtudiantService.findById(idetudiant);
			if (etudiant != null) {
				IEtudiantService.Delete(etudiant);
			}
		}
		return REDIRECTETUDIANT;
	}

	@RequestMapping("/modifier/{id}")
	public String updateetudiant(@PathVariable("id") Long idetudiant, Model model) {
		if (idetudiant != null) {

			Etudiant etudiant = IEtudiantService.findById(idetudiant);
			if (etudiant != null) {
				etudiant.setOldEmail(etudiant.getEmail());
				etudiant.setOldCIN(etudiant.getCin());
				model.addAttribute("etudiant", etudiant);
			}
			List<Classe> classe = IClasseService.FindAll();
			if (classe == null) {
				classe = new ArrayList<Classe>();
			}
			model.addAttribute("listclasse", classe);
		}
		return AJOUTERETUDIANT;
	}

	@RequestMapping("/modifierEtatDispo/{id}")
	public String modifierEtat(@PathVariable("id") Long idEtudiant, Model model) {
		if (idEtudiant != null) {

			Etudiant etudiant = IEtudiantService.findById(idEtudiant);
			if (etudiant != null) {
				etudiant.setDispoSport(!etudiant.getDispoSport());
				IEtudiantService.update(etudiant);
			}
		}
		return REDIRECTETUDIANT;
	}

	@RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
	public String details(Model model, @PathVariable("id") Long idEtudiant) {
		if (idEtudiant != null) {
			Etudiant etudiant = IEtudiantService.findById(idEtudiant);
			if (etudiant != null) {
				model.addAttribute("etudiantt", etudiant);
			}

		}
		return "etudiant/detaills";

	}

	@RequestMapping(value = "/*", method = RequestMethod.GET)
	public String getErrorPage() {
		return "redirect:/Access_Denied/404";
	}

}
