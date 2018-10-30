package com.mynotes.app.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mynotes.app.models.Notes;
import com.mynotes.app.repositories.NotesRepository;

@Service
public class NotesService {

	@Autowired
	private NotesRepository notesRepository;
	
	
	public Notes addNewNote(Notes notes) {
		return notesRepository.save(notes);
	}
	
	public List<Notes> findAllNotesByUserId(Long id) {
		return notesRepository.findAllNotesByUsersId(id);
	}
	
	public void deleteNoteById(Notes note) {
		notesRepository.delete(note);
	}
	
	public Notes updateNote(Notes note) {
		return notesRepository.save(note);
	}
	
}
