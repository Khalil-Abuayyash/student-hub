package com.agkw.studentHub.controllers;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.agkw.studentHub.models.Comment;
import com.agkw.studentHub.models.Course;
import com.agkw.studentHub.models.Post;
import com.agkw.studentHub.models.User;
import com.agkw.studentHub.repositories.UserRepository;
import com.agkw.studentHub.services.CourseService;
import com.agkw.studentHub.services.Post_CommentServices;
import com.agkw.studentHub.services.UserService;

@Controller
public class Post_CommentController {
	private final Post_CommentServices post_commentServices;
	private final CourseService courseservice;
	private final UserService userService;

	

	public Post_CommentController(Post_CommentServices post_commentServices, CourseService courseservice,
			UserService userService) {
		
		this.post_commentServices = post_commentServices;
		this.courseservice = courseservice;
		this.userService = userService;
	}

	@RequestMapping("/Course/{id}")
	public String showCourse(@ModelAttribute("Post") Post p, @ModelAttribute("Comment") Comment c,
			@PathVariable("id") Long id, Model model) {
		Course course = courseservice.findCourse(id);
		List<Post> posts = post_commentServices.allPost();
		model.addAttribute("course", course);
		model.addAttribute("posts", posts);
		return "showcourse.jsp";

	}

	@PostMapping("/addPost/{id}")
	public String addPost(@Valid @ModelAttribute("Post") Post p, BindingResult res, @PathVariable("id") Long id,@ModelAttribute("Comment") Comment c,
			Model model, Principal principal) {

		if (res.hasErrors()) {
			return "showcourse.jsp";
		}
		String name = principal.getName(); 
		User user = userService.findByUsername(name);
		post_commentServices.createpost(p, id, user);
		return "redirect:/Course/"+id;

	}

	@PostMapping("/addcomment/{id}")
	public String addcomment(@Valid @ModelAttribute("Comment") Comment c, BindingResult res,@ModelAttribute("Post") Post p,
			@PathVariable("id") Long id,Principal principal) {
		if(res.hasErrors()) {
			return "showcourse.jsp";
		}
		String name = principal.getName(); 
		User user = userService.findByUsername(name);
		post_commentServices.createcomment(c,id,user);
		return "redirect:/Course/"+id;
		
		

	}

}
