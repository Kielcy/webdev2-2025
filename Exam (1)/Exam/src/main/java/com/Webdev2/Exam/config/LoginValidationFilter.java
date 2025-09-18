package com.Webdev2.Exam.config;

import java.io.IOException;

import org.springframework.http.HttpMethod;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginValidationFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		boolean isLoginPost = 
			HttpMethod.POST.matches(request.getMethod()) && 
			request.getServletPath().equals("/login");

		if (isLoginPost) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			boolean usernameMissing = !StringUtils.hasText(username);
			boolean passwordMissing = !StringUtils.hasText(password);
			if (usernameMissing || passwordMissing) {
				response.sendRedirect(request.getContextPath() + "/login?error=missing");
				return;
			}
		}

		filterChain.doFilter(request, response);
	}
}


