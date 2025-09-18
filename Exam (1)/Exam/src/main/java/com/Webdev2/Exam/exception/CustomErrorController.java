package com.Webdev2.Exam.exception;

import java.util.Map;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.ServletWebRequest;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {

	private final ErrorAttributes errorAttributes;

	public CustomErrorController(ErrorAttributes errorAttributes) {
		this.errorAttributes = errorAttributes;
	}

	@RequestMapping("/error")
	public String handleError(HttpServletRequest request, Model model) {
		ServletWebRequest webRequest = new ServletWebRequest(request);
		ErrorAttributeOptions options = ErrorAttributeOptions.defaults()
			.including(ErrorAttributeOptions.Include.MESSAGE);
		Map<String, Object> attrs = errorAttributes.getErrorAttributes(webRequest, options);

		model.addAttribute("timestamp", attrs.get("timestamp"));
		model.addAttribute("status", attrs.get("status"));
		model.addAttribute("error", attrs.get("error"));
		model.addAttribute("message", attrs.get("message"));
		model.addAttribute("path", attrs.get("path"));

		// Choose specific template for common statuses if present
		Object status = attrs.get("status");
		if (status instanceof Integer s) {
			if (s == 404) {
				return "error/404";
			}
			if (s == 403) {
				return "error/403";
			}
			if (s >= 500) {
				return "error/500";
			}
		}
		return "error";
	}
}


