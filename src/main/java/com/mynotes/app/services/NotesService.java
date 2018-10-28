package com.mynotes.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mynotes.app.models.Notes;
import com.mynotes.app.models.Users;
import com.mynotes.app.repositories.NotesRepository;

@Service
public class NotesService {

	@Autowired
	private NotesRepository notesRepository;
	
	public List<Notes> getAllNotes(){
		return (List<Notes>) notesRepository.findAll();
	}
	
	public Notes getCurrentUserNotes(Users users){
		return notesRepository.findByUsers(users.getId());
	}
}
