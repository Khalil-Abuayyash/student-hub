package com.agkw.studentHub.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.agkw.studentHub.models.Course;
import com.agkw.studentHub.models.User;
import com.agkw.studentHub.services.CourseService;
import com.agkw.studentHub.services.UserService;

@Controller
public class UserController {

	private UserService userService;
	private CourseService courseService;

	public UserController(UserService userService,CourseService courseService) {
		this.userService = userService;
		this.courseService = courseService;
	}

//	----------------------------------ABOUT US PAGE----------------------------------
	@RequestMapping("/about")
	public String aboutUs() {
		return "aboutus.jsp";
	}
//	----------------------------------ABOUT US PAGE----------------------------------
	
//	!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!User Profile Page!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	@RequestMapping("/{id}")
	public String profile(@PathVariable("id")Long id, Model model,Principal principal) {
		String name = principal.getName();
		User user = userService.findByUsername(name);
		if(id == user.getId()) {
			model.addAttribute("user",user);
			model.addAttribute("courses", user.getCourses());
			return "profile.jsp";
		}
		return "redirect:/" +user.getId();
	}
		
	
//	!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!User Profile Page!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	
//	--------------------------------Delete course------------------------------------
	@RequestMapping("/courses/{id}/delete")
	public String destroyCourse(@PathVariable("id")Long id,Principal principal) {
		String name = principal.getName();
		User user = userService.findByUsername(name);
		Course course = courseService.findCourse(id);
		courseService.destroy(course, user);
		return "redirect:/" +user.getId();
	}
//	--------------------------------Delete course------------------------------------
	
//	++++++++++++++++++++++++++++++++User Logout++++++++++++++++++++++++++++++++++++++
	@RequestMapping("/logout")
    public String logout(HttpSession session) {
        // invalidate session
        // redirect to login page
        session.invalidate();
        return "redirect:/"; 
    }
//	++++++++++++++++++++++++++++++++User Logout+++++++++++++++++++++++++++++++++++++
	
	@RequestMapping("/registration")
	public String registerForm(@Valid @ModelAttribute("user") User user) {
		return "registrationPage.jsp";
	}

	@PostMapping("/registration")
	public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model,
			HttpSession session) {
		userService.validateRegistration(user, result);
		if (result.hasErrors()) {
			return "registrationPage.jsp";
		}
		userService.saveUserWithAdminRole(user);
//		userService.saveWithUserRole(user);
		return "redirect:/login";
	}

	@RequestMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {
		if (error != null) {
			model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
		}
		if (logout != null) {
			model.addAttribute("logoutMessage", "Logout Successful!");
		}
		return "loginPage.jsp";
	}
	
	@RequestMapping("/admin")
    public String adminPage(Principal principal, Model model) {
//        String username = principal.getName();
        List<Course> courses = courseService.allCourse();
        List<User> users = userService.allUsers();
        model.addAttribute("courses", courses);
        model.addAttribute("users", users);
        return "adminPage.jsp";
    }

	@RequestMapping(value = { "/", "/home" })
	public String home(Principal principal, Model model, HttpSession session) {
		// 1
		String username = principal.getName();
		User user = userService.findByUsername(username);
		session.setAttribute("id", user.getId());
//		model.addAttribute("currentUser", );
		return "redirect:/courses";
	}
	
	@GetMapping("/users/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model, Principal principal) {
		String name = principal.getName();
		User user = userService.findByUsername(name);
		if(id == user.getId()) {
			model.addAttribute("user", user);
			return "editProfile.jsp";
		}
		
		return "redirect:/users/"+user.getId()+"/edit";
	}
	
	@PutMapping("/users/{id}")
	public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("user") User user, BindingResult result, Principal principal) {
		if (result.hasErrors()) {
			return "editProfile.jsp";
		}
		userService.updateUser(user);
		return "redirect:/logout";
	}
	
	@GetMapping("/admin/users/{id}/edit")
	public String editUserByAdmin(@PathVariable("id") Long id, Model model) {
		User user = userService.findById(id);
		model.addAttribute("user", user);
		return "editProfileByAdmin.jsp";
	}
	
	@PutMapping("/admin/users/{id}")
	public String updateUserByAdmin(@PathVariable("id") Long id, @Valid @ModelAttribute("user") User user, BindingResult result, Principal principal) {
		if (result.hasErrors()) {
			return "editProfileByAdmin.jsp";
		}
		userService.updateUser(user);
		return "redirect:/admin";
	}
	
	@GetMapping("/admin/users/{id}/delete")
	public String destroyUser(@PathVariable("id") Long id) {
		User user = userService.findById(id);
		userService.destroyUser(user);
		return "redirect:/admin";
	}
	
}
