package com.agkw.studentHub.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.agkw.studentHub.models.Comment;
import com.agkw.studentHub.models.Course;
import com.agkw.studentHub.models.Post;
import com.agkw.studentHub.models.User;
import com.agkw.studentHub.repositories.CommentRepository;
import com.agkw.studentHub.repositories.CourseRepoistory;
import com.agkw.studentHub.repositories.PostRepository;

@Service
public class Post_CommentServices {
	private final PostRepository postrepo;
	private final CommentRepository commentrepo;
	private final CourseRepoistory courseRepoistory; 
	
	
	
	public Post_CommentServices(PostRepository postrepo, CommentRepository commentrepo,
			CourseRepoistory courseRepoistory) {
		this.postrepo = postrepo;
		this.commentrepo = commentrepo;
		this.courseRepoistory = courseRepoistory;
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

	public void createpost(Post p, Long id, User user) {
		Post post = new Post();
		post.setText(p.getText());
		post.setUser(user);
		post=postrepo.save(post);
		Course course=courseRepoistory.findById(id).orElse(null);
		List<Post> posts= course.getPosts();
		posts.add(post);
		course.setPosts(posts);
	}

	public void createcomment(Comment c, Long id,User user) {
		Comment comment =new Comment();
		Post p=postrepo.findById(id).orElse(null);
		comment.setPost(p);
		comment.setText(c.getText());
		comment.setUser(user);
		comment=commentrepo.save(comment);
		Post post=postrepo.findById(id).orElse(null);
		List<Comment> comments= post.getComments();
		comments.add(comment);
		post.setComments(comments);
		
		
		
		
		
	}
	
	

}
