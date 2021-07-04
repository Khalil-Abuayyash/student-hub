package com.agkw.studentHub.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.agkw.studentHub.models.Course;

@Repository
public interface CourseRepoistory extends CrudRepository<Course, Long> {
	
	List<Course> findAll();
	
}
