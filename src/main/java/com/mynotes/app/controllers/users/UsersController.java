package com.mynotes.app.controllers.users;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mynotes.app.models.Users;
import com.mynotes.app.services.UsersService;
import com.mynotes.app.utils.JSONAnswer;

@RestController
@RequestMapping("users")
public class UsersController {

	@Autowired
	private UsersService userService;
	
	@Autowired
	private JSONAnswer jsonAnswer;
	
	@GetMapping("currentUser")
	public JSONAnswer getCurrentUser(Principal principal) {
		try {
			Users user =  userService.getByName(principal.getName());	
			jsonAnswer = new JSONAnswer("User Data", "200", true, user);
		} catch (Exception e) {
			jsonAnswer = new JSONAnswer("Error, can't take data ", "200", false, null);
		}
		
		return jsonAnswer;
	}
	
}
