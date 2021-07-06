//package com.agkw.studentHub.controllers;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.agkw.studentHub.models.Course;
//import com.agkw.studentHub.services.CourseService;
//
//@Controller
//public class ajaxController {
//	@Autowired
//	private CourseService courseService;
//	
//	@RequestMapping("/ajax")
//	public ModelAndView showResult() {
//		return new ModelAndView("ajax.jsp", "message","sxsdfsdgdh");
//	}
//	
//	@RequestMapping(value = "/ajaxtest", method = RequestMethod.GET)
//    public @ResponseBody
//    List<Course> search() {
//		return courseService.allCourse();
//    }
//	
//	
//}
