package com.mynotes.app.controllers.test;

import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mynotes.app.models.Notes;
import com.mynotes.app.models.Users;
import com.mynotes.app.services.NotesService;
import com.mynotes.app.services.UsersService;


@RestController
@RequestMapping("test")
public class ShowAll {
	
	@Autowired
	private NotesService notesService;
	
	@Autowired
	private UsersService usersService;
	
	@GetMapping("showall")
	public String test() {
		return "Test Users Controller Done";
	}
	
	@GetMapping("users")
	public List<Users> getAllUsers() {
		return usersService.getAll();
	}
		
	/*
	 fetch("http://localhost:8080/test/notes",{method:"POST", 
	 headers:{ "Content-Type" : "application/json" }, body:JSON.stringify({note:"lalala" }) })
	 .then(function(res){console.log(res)});
	  
	  
	 */
	
	@PostMapping("notes")
	public String addNewNotes(@RequestBody Notes notes, Principal principal) {
		Users user = usersService.getByName(principal.getName());
		notes.setUsers(user);
		notesService.addNewNotes(notes);
		
		return "done";
	}
	
	
	

}
