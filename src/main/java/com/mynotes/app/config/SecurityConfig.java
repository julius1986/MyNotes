package com.mynotes.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.WebSecurityEnablerConfiguration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityEnablerConfiguration {

	protected void configure(HttpSecurity http) throws Exception {
 		http.authorizeRequests()
 				.antMatchers("/users/public/**").permitAll()
 				.antMatchers("/users/private/**").hasAnyRole("USER")
 				
 			.and()
 				.formLogin().permitAll()
 			.and()
 				//login?logout
 				.logout().permitAll();
 	}
	
	@Autowired
 	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
 		auth
 			.inMemoryAuthentication()
 				.withUser("user").password("{noop}password").roles("USER")
 			.and()
 				.withUser("admin").password("{noop}password").roles("USER", "ADMIN");
 	}
	
	
	
}
