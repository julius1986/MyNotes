package com.mynotes.app.controllers.users;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mynotes.app.models.Users;
import com.mynotes.app.services.UsersService;

@RestController
@RequestMapping("users")
public class UsersController {

	@Autowired
	private UsersService userService;
	
	@GetMapping("test")
	public String test() {
		return "Test Users Controller Done";
	}
	
	@GetMapping("public/test")
	public String testPublic() {
		return "Test Users Controller Done. This is public.";
	}
	

	@GetMapping("private/test")
	public String testPrivate(Principal principal) {
		return "Test Users Controller Done. This is private.";
	}
	
	@GetMapping("currentUser")
	public Users getCurrentUser(Principal principal) {
		Users user =  userService.getByName(principal.getName());
		return user;
	}
	
}
