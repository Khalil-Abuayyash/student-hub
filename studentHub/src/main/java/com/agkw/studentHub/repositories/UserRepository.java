package com.agkw.studentHub.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.agkw.studentHub.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User findByName(String name);
}
