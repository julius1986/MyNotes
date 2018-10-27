package com.mynotes.app.controllers.users;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UsersController {

	@GetMapping("test")
	public String test() {
		return "Test Users Controller Done";
	}
	
	@GetMapping("public/test")
	public String testPublic() {
		return "Test Users Controller Done. This is public.";
	}
	

	@GetMapping("private/test")
	public String testPrivate() {
		return "Test Users Controller Done. This is private.";
	}
	
}
