package com.mynotes.app.controllers.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("notes")
	public List<Notes> getAllNotes() {
		return notesService.getAllNotes();
	}
	
	@GetMapping("users")
	public List<Users> getAllUsers() {
		return usersService.getAll();
	}

}
