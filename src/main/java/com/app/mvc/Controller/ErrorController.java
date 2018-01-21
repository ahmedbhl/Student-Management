package com.app.mvc.Controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.axis.utils.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Access_Denied")
public class ErrorController {

	private static final String REFERER = "referer";

	@RequestMapping("/401")
	public String errorPage401(Model model, HttpServletRequest request) {
		String lastUrl = request.getHeader(REFERER);
		if (!StringUtils.isEmpty(lastUrl)) {
			model.addAttribute("url401", lastUrl);
		}
		return "errors/401";
	}

	@RequestMapping("/403")
	public String errorPage403(Model model, HttpServletRequest request) {
		String lastUrl = request.getHeader(REFERER);
		if (!StringUtils.isEmpty(lastUrl)) {
			model.addAttribute("url403", lastUrl);
		}
		return "errors/403";
	}

	@RequestMapping("/404")
	public String errorPage404(Model model, HttpServletRequest request) {
		String lastUrl = request.getHeader(REFERER);
		if (!StringUtils.isEmpty(lastUrl)) {
			model.addAttribute("url404", lastUrl);
		}
		return "errors/404";
	}

	@RequestMapping("/500")
	public String errorPage500(Model model, HttpServletRequest request) {
		String lastUrl = request.getHeader(REFERER);
		if (!StringUtils.isEmpty(lastUrl)) {
			model.addAttribute("url505", lastUrl);
		}
		return "errors/500";
	}
}
