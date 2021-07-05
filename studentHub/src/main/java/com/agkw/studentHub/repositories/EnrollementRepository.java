package com.agkw.studentHub.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.agkw.studentHub.models.Course;
import com.agkw.studentHub.models.Enrollement;
import com.agkw.studentHub.models.User;

public interface EnrollementRepository extends CrudRepository<Enrollement, Long> {
	Optional<Enrollement> findByCourseAndUser(Course course, User user);
}
