package com.agkw.studentHub.controllers;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.agkw.studentHub.models.User;
import com.agkw.studentHub.services.UserService;

@Controller
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
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
//		userService.saveUserWithAdminRole(user);
		userService.saveWithUserRole(user);
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
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        return "adminPage.jsp";
    }

	@RequestMapping(value = { "/", "/home" })
	public String home(Principal principal, Model model) {
		// 1
		String username = principal.getName();
		model.addAttribute("currentUser", userService.findByUsername(username));
		return "homePage.jsp";
	}

}
