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
public class UsersService {
	
	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private AuthoritiesService authoritiesService;
	
	@Autowired
	private EncoderForPass encoderForPass;
	
	public List<Users> getAll(){
		return (List<Users>) usersRepository.findAll();
	}
	
	public Users getByName(String userName){
		return usersRepository.findByUserName(userName);
	}
	
	public boolean createNewUser(String userName, String password, String role){
		Users user = new Users();
		user.setUserName(userName);
		user.setPassword(encoderForPass.codePassword(password));
		user.setEnabled("1");
		user = usersRepository.save(user);
		if(user != null) {
			authoritiesService.saveAuthorities(user.getUserName(), role);	
			return true;
		}
		return false;
	}
}
