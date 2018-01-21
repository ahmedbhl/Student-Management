package com.app.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.axis.utils.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.mvc.util.ApplicationUtils;

@Controller
@RequestMapping(value = "/changelocale")
public class ChangeLocaleController {

	private static final String REFERER = "referer";

	@RequestMapping(value = "/{locale}")
	public String changelocale(HttpServletRequest request, HttpServletResponse response, @PathVariable String locale) {
		if (!StringUtils.isEmpty(locale)) {
			ApplicationUtils.changeLocale(request, response, locale);
		}
		String lasturl = request.getHeader(REFERER);
		if (!StringUtils.isEmpty(lasturl)) {
			return "redirect:" + lasturl;
		}
		return "redirect:/home";
	}
}
