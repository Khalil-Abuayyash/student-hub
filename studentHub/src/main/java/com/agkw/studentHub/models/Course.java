package com.agkw.studentHub.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="courses")
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=3, max=255, message="Course name must be of three characters or more")
	private String name;
	
	@Size(min=3,max=255, message="Instructor name is required")
	private String instructor;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
	@ManyToMany
	@JoinTable(
			name = "enrollements",
	        joinColumns = @JoinColumn(name="course_id"),
	        inverseJoinColumns = @JoinColumn(name="user_id")
	)
	private List<User> users;
	
	@ManyToMany
	@JoinTable(
			name = "uni_courses",
	        joinColumns = @JoinColumn(name="course_id"),
	        inverseJoinColumns = @JoinColumn(name="university_id")
	)
	private List<University> universities;
	
	@OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
	private List<Post> posts;
	
	
    @PrePersist
    protected void onCreate(){this.createdAt = new Date();}
	@PreUpdate
    protected void onUpdate(){this.updatedAt = new Date();}
    
	public Course() {}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public List<University> getUniversities() {
		return universities;
	}
	public void setUniversities(List<University> universities) {
		this.universities = universities;
	}
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

}