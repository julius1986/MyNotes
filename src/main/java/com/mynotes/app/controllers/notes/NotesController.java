package com.mynotes.app.controllers.notes;

import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mynotes.app.models.Notes;
import com.mynotes.app.models.Users;
import com.mynotes.app.services.NotesService;
import com.mynotes.app.services.UsersService;
import com.mynotes.app.utils.JSONAnswer;

@RequestMapping(value = "notes")
@RestController
public class NotesController {
	
	@Autowired
	private NotesService noteService;
	@Autowired
	private UsersService usersService;
	@Autowired
	private JSONAnswer jsonAnswer;
	
	
	@GetMapping
	public JSONAnswer getAllNotesForCurrentUser(Principal principal){
		try {
			Users user = usersService.getByName(principal.getName());
			List<Notes> notes = noteService.findAllNotesByUserId(user.getId());
			jsonAnswer = new JSONAnswer("Notes for current user", "200", true, notes);
		} catch (Exception e) {
			jsonAnswer = new JSONAnswer("Error, cant take notes for current user", "200", false, null);
		}
		
		return jsonAnswer;
	}
	
	@PostMapping
	public JSONAnswer addNoteForCurrentUser(@RequestBody Notes notes ,Principal principal){
		try {
			Users user = usersService.getByName(principal.getName());
			notes.setUsers(user);
			noteService.addNewNote(notes);
			jsonAnswer = new JSONAnswer("Note added, back this note", "200", true, notes);
		} catch (Exception e) {
			jsonAnswer = new JSONAnswer("Error, cant add note", "200", false, null);
		}
		
		return jsonAnswer;
	}
	
	/*TODO update */
	@PutMapping
	public JSONAnswer updateNoteForCurrentUser(@RequestBody Notes updateNote ,Principal principal){
		try {
			boolean result = false;
			Long noteId = updateNote.getId();
			Users user = usersService.getByName(principal.getName());
			List<Notes> notes = noteService.findAllNotesByUserId(user.getId());
			for (Notes tempNote : notes) {
				if(tempNote.getId() == noteId) {
					result = true;
					break;
				}
			}
			if (result) {
				noteService.updateNote(updateNote);	
				jsonAnswer = new JSONAnswer("Note updated, back this note", "200", true, notes);
			}else {
				jsonAnswer = new JSONAnswer("Error, cant find note for update", "200", false, null);
			}
		} catch (Exception e) {
			jsonAnswer = new JSONAnswer("Error, cant update note", "200", false, null);
		}
		
		return jsonAnswer;
	}
	
	
	/*TODO delete */
	@DeleteMapping
	public JSONAnswer deleteNoteForCurrentUser(@RequestBody Long noteId ,Principal principal){
		try {
			Users user = usersService.getByName(principal.getName());
			List<Notes> notes = noteService.findAllNotesByUserId(user.getId());
			Notes deletingNote = null;
			for (Notes tempNote : notes) {
				if(tempNote.getId() == noteId) {
					deletingNote = tempNote;
					break;
				}
			}
			if (deletingNote != null) {
				noteService.deleteNoteById(deletingNote);	
				jsonAnswer = new JSONAnswer("Note deleted, back this note", "200", true, null);
			}else {
				jsonAnswer = new JSONAnswer("Error, cant find note", "200", false, null);
			}
		} catch (Exception e) {
			jsonAnswer = new JSONAnswer("Error, cant add note", "200", false, null);
		}
		
		return jsonAnswer;
	}
	
	
}
