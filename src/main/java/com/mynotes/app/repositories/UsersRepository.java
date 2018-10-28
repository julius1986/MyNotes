package com.mynotes.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mynotes.app.models.Users;

@Repository
public interface UsersRepository extends CrudRepository<Users, Long> {
		public Users findByUserName(String userName);
}
