package com.agkw.studentHub.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.agkw.studentHub.services.Post_CommentServices;

@Controller
public class Post_CommentController {
	private final Post_CommentServices post_commentServices;

	public Post_CommentController(Post_CommentServices pCS) {
		
		post_commentServices = pCS;
	}
	
//	@RequestMapping("/Course/{id}")
//	public String showCourse(@PathVariable("id") Long id ,Model model) {
//		
//		
//		
//	}
//	

}
