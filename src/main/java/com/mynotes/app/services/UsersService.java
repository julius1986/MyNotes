package com.mynotes.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mynotes.app.models.Users;
import com.mynotes.app.repositories.UsersRepository;

@Service
public class UsersService {

	@Autowired
	private UsersRepository usersRepository;
	
	public List<Users> getAll(){
		return (List<Users>) usersRepository.findAll();
	}
	
	public Users getByName(String userName){
		return usersRepository.findByUserName(userName);
	}
}
