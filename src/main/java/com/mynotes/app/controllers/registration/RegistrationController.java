package com.mynotes.app.controllers.registration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mynotes.app.models.Users;
import com.mynotes.app.services.UsersService;


@Controller
public class RegistrationController {
	
	@Autowired
	UsersService userService;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String register(Model model) {

        return "registration";
    }	
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String register(Model model, HttpServletRequest request) {
        String page = "registration"; 
		String username;
         String password;
         String passwordrepeat;
         String role;
         Users user;
         username = request.getParameter("username");
         password = request.getParameter("password");
         passwordrepeat = request.getParameter("passwordrepeat");
         role = request.getParameter("role");
         
		if (username.length() < 3) {
			model.addAttribute("result",  "User name less than 7 symbols");
		}else if(password.length() < 3) {
			model.addAttribute("result",  "Password less than 7 symbols");
		}else if(!password.equals(passwordrepeat) ) { 
			model.addAttribute("result",  "Password not equals repeat password");
		}else {	
			user = userService.getByName(username);
			if (user==null) {
				if (userService.createNewUser(username, password, role)) {
					model.addAttribute("result",  "User was created");	
				}else {
					model.addAttribute("result",  "something go wrong");
				}
					
			} else {
				model.addAttribute("result",  "User has exist");
			}
			
		}
		
        return page;
    }	
	
}
