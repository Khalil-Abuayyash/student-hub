package com.agkw.studentHub.controllers;

import java.security.Principal;
import java.util.List;

//import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.agkw.studentHub.models.Course;
import com.agkw.studentHub.models.UniCourse;
import com.agkw.studentHub.models.University;
import com.agkw.studentHub.models.User;
import com.agkw.studentHub.services.CourseService;
import com.agkw.studentHub.services.UserService;

@Controller
public class CourseController {

	private final CourseService courseService;
	private final UserService userService;

	public CourseController(CourseService courseService, UserService userService) {
		this.courseService = courseService;
		this.userService = userService;
	}

	@RequestMapping("/courses")
	public String showcourses(@ModelAttribute("course") Course course, Model model, Principal principal) {
		String name = principal.getName();
		User user = userService.findByUsername(name);
		List<Course> courses = courseService.allCourse();

		model.addAttribute("courses", courses);
		model.addAttribute("user", user);

		return "courses.jsp";
	}

	@RequestMapping("/addcourse/{id}")
	public String addcourse(@PathVariable("id") long id, Principal principal, Model model) {
		String name = principal.getName();
		User user = userService.findByUsername(name);
		Course course = courseService.findCourse(id);
		List<Course> courses = user.getCourses();
		courses.add(course);
		user.setCourses(courses);
		userService.saveUser(user);
		return "redirect:/courses";
	}

	@RequestMapping("/deletecourse/{id}")
	public String deletecourse(@PathVariable("id") long id, Principal principal, Model model) {
		String name = principal.getName();
		User user = userService.findByUsername(name);
		Course course = courseService.findCourse(id);
//		List<Course> courses = user.getCourses();

		courseService.destroy(course, user);
		return "redirect:/courses";
	}
	
	@GetMapping("courses/{id}/edit")
	public String editCourse(Model model,@PathVariable("id") Long id) {
		Course course = courseService.findCourse(id);
		model.addAttribute("course", course);
		return "editCourse.jsp";
	}
	
	@PutMapping("courses/{id}")
	public String updateCourse(@Valid @ModelAttribute("course") Course course, BindingResult result) {
		if (result.hasErrors()) {
			return "editCourse.jsp";
		}
		courseService.updateCourse(course);
		return "redirect:/admin";
	}

	@GetMapping("/courses/{id}/delete")
	public String destroyCourse(@PathVariable("id") Long id) {
		Course course = courseService.findCourse(id);
		courseService.deleteCourse(course);
		return "redirect:/admin";
	}
	
	@RequestMapping("/admin/unicourses")
	public String uniCourses(Model model) {
		List<UniCourse> uniCourses = courseService.allUniCourses();
		model.addAttribute("uniCourses", uniCourses);
        return "adminUni.jsp";
	}
	
	@GetMapping("/unicourses/{id}/edit")
	public String editUniCourse(Model model, @PathVariable("id") Long id) {
		UniCourse uniCourse = courseService.findUniCourseById(id);
		model.addAttribute("uniCourse", uniCourse);
		return "editUniCourse.jsp";
	}
	
	@PutMapping("unicourses/{id}")
	public String updateUniCourse(@PathVariable("id") Long id, @RequestParam("outline") String outline) {
		UniCourse uniCourse = courseService.findUniCourseById(id);
		uniCourse.setOutline(outline);
		courseService.updateUniCourse(uniCourse);
		return "redirect:/admin/unicourses";
	}
	
	@GetMapping("unicourses/{id}/delete")
	public String deleteUniCourse(@PathVariable("id") Long id) {
		UniCourse uniCourse = courseService.findUniCourseById(id);
		courseService.destroyUniCourse(uniCourse);
		return "redirect:/admin/unicourses";
	}
	
	@GetMapping("/courses/new")
	public String newCourse(@ModelAttribute("course") Course course) {
		return "newCourse.jsp";
	}
	
	@PostMapping("courses")
	public String createCourse(@Valid @ModelAttribute("course") Course course, BindingResult result) {
		if (result.hasErrors()) {
			return "newCourse.jsp";
		}
		courseService.updateCourse(course);
		return "redirect:/admin";
	}
	
	@GetMapping("/universities/new")
	public String newUniversity(@ModelAttribute("university") University university) {
		return "newUniversity.jsp";
	}
	
	@PostMapping("universities")
	public String createUniversity(@Valid @ModelAttribute("university") University university, BindingResult result) {
		if (result.hasErrors()) {
			return "newUniversity.jsp";
		}
		courseService.createUniversity(university);
		return "redirect:/admin";
	}
	
	
}