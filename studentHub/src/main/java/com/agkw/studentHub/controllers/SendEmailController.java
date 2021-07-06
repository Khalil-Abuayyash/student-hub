package com.agkw.studentHub.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.agkw.studentHub.services.SendEmailService;

@Controller
public class SendEmailController {
	private final SendEmailService sendEmailService;

	public SendEmailController(SendEmailService sendEmailService) {
		this.sendEmailService = sendEmailService;
	}
	
	@RequestMapping("/sendmail/{mailTo}")
    public String sendEmail(@PathVariable("mailTo") String reciever) {
    String message = "Hello our dear user welcome to Student hub please go to this link to confirm "+"https://www.google.com/";
    sendEmailService.sendingMail(reciever, message, "Student Hub team ");
    return "redirect:/";
    }
	

}
