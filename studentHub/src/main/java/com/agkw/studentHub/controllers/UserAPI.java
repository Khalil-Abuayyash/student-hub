package com.agkw.studentHub.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.agkw.studentHub.models.AjaxResponseBody;
import com.agkw.studentHub.models.Course;
import com.agkw.studentHub.models.SearchCriteria;
import com.agkw.studentHub.services.CourseService;

@RestController
public class UserAPI {
	private CourseService courseService;
	
	public UserAPI(CourseService courseService) {
		this.courseService = courseService;
	}
	
	 @PostMapping("/api/search")
	    public ResponseEntity<?> getSearchResultViaAjax(
	            @Valid @RequestBody SearchCriteria search, Errors errors) {

	        AjaxResponseBody result = new AjaxResponseBody();

	        //If error, just return a 400 bad request, along with the error message
	        if (errors.hasErrors()) {

	            result.setMsg(errors.getAllErrors()
	                        .stream().map(x -> x.getDefaultMessage())
	                        .collect(Collectors.joining(",")));

	            return ResponseEntity.badRequest().body(result);

	        }

	        List<Course> courses = (List<Course>) courseService.findById(search.getId());
	        if (courses.isEmpty()) {
	            result.setMsg("no course found!");
	        } else {
	            result.setMsg("success");
	        }
	        result.setResult(courses);

	        return ResponseEntity.ok(result);

	    }

	
}
