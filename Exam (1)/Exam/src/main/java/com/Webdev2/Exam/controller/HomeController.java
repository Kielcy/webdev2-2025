package com.Webdev2.Exam.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String root(Authentication authentication) {
		if (authentication != null && authentication.isAuthenticated()) {
			return "redirect:/employees";
		}
		return "login";
	}

	@GetMapping("/login")
	public String login(Authentication authentication) {
		if (authentication != null && authentication.isAuthenticated()) {
			return "redirect:/employees";
		}
		return "login";
	}
}


