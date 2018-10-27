package com.mynotes.app.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.WebSecurityEnablerConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
 		http
 		.csrf().disable()
 		.authorizeRequests()
 				.antMatchers("/users/**").authenticated()
 				.antMatchers("/users/private/**").hasRole("USER")
 				.antMatchers("/users/public/**").permitAll()
 				
 			.and()
 				.formLogin()
 			.and()
 		
 				//login?logout
 				.logout().logoutUrl("/logout").logoutSuccessUrl("/login")
 			.and()
 				.httpBasic();
 	}
	
	@Autowired
 	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
 		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(new BCryptPasswordEncoder());
 		
 		
// 			.inMemoryAuthentication()
// 				.withUser("user").password("{noop}password").roles("USER")
// 			.and()
// 				.withUser("admin").password("{noop}password").roles("USER", "ADMIN");
 	}
	
	
	
}
