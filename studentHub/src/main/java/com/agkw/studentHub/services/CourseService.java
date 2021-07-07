package com.agkw.studentHub.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.agkw.studentHub.models.Course;
import com.agkw.studentHub.models.Enrollement;
import com.agkw.studentHub.models.UniCourse;
import com.agkw.studentHub.models.University;
import com.agkw.studentHub.models.User;
import com.agkw.studentHub.repositories.CourseRepoistory;
import com.agkw.studentHub.repositories.EnrollementRepository;
import com.agkw.studentHub.repositories.UniCourseRepository;
import com.agkw.studentHub.repositories.UniversityRepository;
import com.agkw.studentHub.repositories.UserRepository;

@Service
public class CourseService {
	private final CourseRepoistory courserepo;
	private final UserRepository userRepoistory;
	private final EnrollementRepository enrollementRepository;
	private final UniCourseRepository uniCourseRepository;
	private final UniversityRepository universityRepository;

	public CourseService(CourseRepoistory courserepo, UserRepository userRepoistory,
			EnrollementRepository enrollementRepository, UniCourseRepository uniCourseRepository, UniversityRepository universityRepository) {

		this.courserepo = courserepo;
		this.userRepoistory = userRepoistory;
		this.enrollementRepository = enrollementRepository;
		this.uniCourseRepository = uniCourseRepository;
		this.universityRepository = universityRepository;
	}

	public List<Course> allCourse() {

		return courserepo.findAll();

	}

	public Course findCourse(Long id) {

		return courserepo.findById(id).orElse(null);
	}

	public User findById(Long id) {
		return userRepoistory.findById(id).orElse(null);
	}

	public Course addCourse(Course course) {

		return courserepo.save(course);
	}

	public Enrollement findEnrollement(Course course, User user) {

		return enrollementRepository.findByCourseAndUser(course, user).orElse(null);
	}

	public void destroy(Course course, User user) {
		Enrollement enroll = this.findEnrollement(course, user);
		enrollementRepository.delete(enroll);
	}

	public Course updateCourse(Course course) {
		return courserepo.save(course);
	}
	
	public void deleteCourse(Course course) {
		courserepo.delete(course);
	}
	
	public List<UniCourse> allUniCourses() {
		return uniCourseRepository.findAll();	
	}
	
	public UniCourse findUniCourseById(Long id) {
		return uniCourseRepository.findById(id).orElse(null);
	}
	
	public UniCourse updateUniCourse(UniCourse uniCourse) {
		return uniCourseRepository.save(uniCourse);
	}
	
	public void destroyUniCourse(UniCourse uniCourse) {
		uniCourseRepository.delete(uniCourse);
	}
	
	public University createUniversity(University university) {
		return universityRepository.save(university);
	}
	
	public List<UniCourse> unisCourse(Course course) {
		return uniCourseRepository.findByCourse(course);
	}
}