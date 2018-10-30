package com.mynotes.app.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mynotes.app.models.Notes;

@Repository
public interface NotesRepository extends CrudRepository<Notes, Long> {
		public Notes findByUsers(Long userId);
		public List<Notes> findAllNotesByUsersId(Long id);
}
