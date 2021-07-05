package com.agkw.studentHub.controllers;

import java.security.Principal;
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
public String showcourses(@ModelAttribute("course") Course course, Model model, HttpSession session ,Principal principal) {
	
	List<Course> courses=courseService.allCourse();
	String name = principal.getName();
	User user = userService.findByUsername(name);
	model.addAttribute("courses",courses);
	model.addAttribute(user);
	
	
	return "courses.jsp";
}
@RequestMapping("/addcourse/{id}")
public String addcourse(@PathVariable("id") long id,Principal principal, Model model) {
	String name = principal.getName();
	User user = userService.findByUsername(name);
	Course course=courseService.findCourse(id);
	List<Course> courses = user.getCourses();
	courses.add(course);
	user.setCourses(courses);
	userService.saveUser(user);
	return "redirect:/courses";
	
	
}

//--------------------------------delete course------------------------------
@RequestMapping("/courses/{id}/remove")
public String destroyCourse(@PathVariable("id")Long id,Principal principal) {
	String name = principal.getName();
	User user = userService.findByUsername(name);
	Course course = courseService.findCourse(id);
	courseService.destroy(course, user);
	return "redirect:/courses";
}
//--------------------------------delete course------------------------------




}