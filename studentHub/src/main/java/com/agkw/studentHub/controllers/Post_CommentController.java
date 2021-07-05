package com.agkw.studentHub.controllers;

import java.util.List;

import javax.naming.Binding;
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
import com.agkw.studentHub.services.CourseService;
import com.agkw.studentHub.services.Post_CommentServices;

@Controller
public class Post_CommentController {
	private final Post_CommentServices post_commentServices;
	private final CourseService courseservice;

	public Post_CommentController(Post_CommentServices post_commentServices, CourseService courseservice) {
		this.post_commentServices = post_commentServices;
		this.courseservice = courseservice;
	}

	@RequestMapping("/Course/{id}")
	public String showCourse(@ModelAttribute("Post") Post p,@ModelAttribute("Comment") Comment c ,@PathVariable("id") Long id ,Model model) {
		Course course = courseservice.findCourse(id);
		List<Post> post= post_commentServices.allPost();
		model.addAttribute("course",course);
		model.addAttribute("post",post);
		return "showcourse.jsp";
		
		
	}

	@PostMapping("/addPost/{id}")
	public String addPost(@Valid@ModelAttribute("Post") Post p,BindingResult res,@PathVariable("id") Long id ,Model model) {
	
		if (res.hasErrors()) {
			return "showcourse.jsp";
		}
		post_commentServices.createpost(p,id);
		return "redirect:/Course/id";
		
		
		
		
		
	}
	
	

}
