package com.app.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {

	@RequestMapping(value = { "/admin", "/admin/", "/home", "/home/" }, method = RequestMethod.GET)
	public String adminPage(ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("user", authentication.getName());
		model.addAttribute("username", getPrincipal());
		return "HomeAdmin/dashboard";
	}

	@RequestMapping(value = "/failedlogin", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		model.addAttribute("error", "true");
		return "login/login";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loginPage() {
		return "login/login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}

	@RequestMapping(value = "/*", method = RequestMethod.GET)
	public String getErrorPage() {
		return "errors/404";
	}

	// optionnal
	private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}

}
