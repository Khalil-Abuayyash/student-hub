package com.agkw.studentHub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.agkw.studentHub.models.Course;
import com.agkw.studentHub.models.User;
import com.agkw.studentHub.services.CourseService;
import com.agkw.studentHub.services.UserService;

@Controller
public class CourseController {

private final CourseService courseService;
private  final UserService userService;

public CourseController(CourseService courseService, UserService userService) {
	this.courseService = courseService;
	this.userService = userService;
}

@RequestMapping("/courses")
public String showcourses(@ModelAttribute("course") Course course, Model model, HttpSession session ) {
	
	List<Course> courses=courseService.allCourse();
	
	model.addAttribute("courses",courses);
	
	
	return "courses.jsp";
}
@RequestMapping("/addcourse/{id}")
public String addcourse(@PathVariable("id") long id,HttpSession session, Model model) {
	Long user_id=(Long) session.getAttribute("id");
	Course course=courseService.findCourse(id);
	User user = courseService.findById(user_id);
	
	List<Course> courses = user.getCourses();
	courses.add(course);
	user.setCourses(courses);
	userService.saveUser(user);
	return "redirect:/courses";
	
	
}






}