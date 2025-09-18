package com.Webdev2.Exam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests(auth -> auth
				.requestMatchers("/", "/css/**", "/h2-console/**", "/login", "/error", "/error/**").permitAll()
				.anyRequest().authenticated()
			)
			.formLogin(login -> login
				.loginPage("/login").permitAll()
				.defaultSuccessUrl("/employees", true)
			)
			.logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/login?logout").permitAll())
			.exceptionHandling(ex -> ex
				.accessDeniedHandler((request, response, accessDeniedException) -> {
					request.setAttribute("jakarta.servlet.error.status_code", 403);
					request.getRequestDispatcher("/error").forward(request, response);
				})
			)
			.csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**"))
			.headers(headers -> headers.frameOptions(frame -> frame.disable()))
			.addFilterBefore(new LoginValidationFilter(), UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}
}


