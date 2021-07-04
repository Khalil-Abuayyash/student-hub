package com.agkw.studentHub.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.agkw.studentHub.models.Course;
import com.agkw.studentHub.repositories.CourseRepoistory;

@Service
public class CourseService {
private final CourseRepoistory courserepo;



public CourseService(CourseRepoistory courserepo) {
	
	this.courserepo = courserepo;
}



public List<Course> allCourse(){
	
	return courserepo.findAll();
	
}

public Course findCourse(Long id) {
	
	return courserepo.findById(id).orElse(null);
}


}
