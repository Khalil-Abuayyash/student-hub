package com.agkw.studentHub.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.agkw.studentHub.models.Comment;
import com.agkw.studentHub.models.Post;
import com.agkw.studentHub.repositories.CommentRepository;
import com.agkw.studentHub.repositories.PostRepository;

@Service
public class Post_CommentServices {
	private final PostRepository PR;
	private final CommentRepository CR;
	public Post_CommentServices(PostRepository pR, CommentRepository cR) {
		PR = pR;
		CR = cR;
	}
	
	public List<Post> allPost(){
		return PR.findAll();
	}
	
	public List<Comment> allComment(){
		return CR.findAll();
	}
	
	
	

}
