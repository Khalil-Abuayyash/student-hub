package com.agkw.studentHub.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.agkw.studentHub.models.Comment;
import com.agkw.studentHub.models.Post;
import com.agkw.studentHub.repositories.CommentRepository;
import com.agkw.studentHub.repositories.PostRepository;

@Service
public class Post_CommentServices {
	private final PostRepository postrepo;
	private final CommentRepository commentrepo;
	public Post_CommentServices(PostRepository pR, CommentRepository cR) {
		postrepo = pR;
		commentrepo = cR;
	}
	
	public List<Post> allPost(){
		return postrepo.findAll();
	}
	
	public List<Comment> allComment(){
		return commentrepo.findAll();
	}
	
	public Post findPost(Long id) {			
		return postrepo.findById(id).orElse(null);
		
	}
	
	public Comment findComment (Long id ) {
		
		return commentrepo.findById(id).orElse(null);
		
	}
	
	

}
