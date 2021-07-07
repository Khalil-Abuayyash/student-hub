package com.agkw.studentHub.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.agkw.studentHub.models.Course;
import com.agkw.studentHub.models.UniCourse;

@Repository
public interface UniCourseRepository extends CrudRepository<UniCourse, Long> {
	List<UniCourse> findAll();
	Optional<UniCourse> findById(Long id);
	List<UniCourse> findByCourse(Course course);
}
