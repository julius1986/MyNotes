package com.mynotes.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mynotes.app.models.Authorities;
import com.mynotes.app.models.Users;

@Repository
public interface AuthoritiesRepository extends CrudRepository<Authorities, Long> {
		
}
