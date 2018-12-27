package com.mynotes.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mynotes.app.models.Authorities;
import com.mynotes.app.models.Users;
import com.mynotes.app.repositories.AuthoritiesRepository;
import com.mynotes.app.repositories.UsersRepository;
import com.mynotes.app.utils.EncoderForPass;

@Service
public class AuthoritiesService {

	@Autowired
	private AuthoritiesRepository authoritiesRepository;
	
    private final String userRole = "ROLE_USER";
	private final String adminRole = "ROLE_ADMIN";
	
	public boolean saveAuthorities(String userName, String role) {
		Authorities authorities = new Authorities();
		if (role.equals(adminRole)) {
			authorities.setAuthority(adminRole);
		} else {
			authorities.setAuthority(userRole);
		}
		authorities.setUsername(userName);
		authorities = authoritiesRepository.save(authorities);
		
		return true;
	}
}
