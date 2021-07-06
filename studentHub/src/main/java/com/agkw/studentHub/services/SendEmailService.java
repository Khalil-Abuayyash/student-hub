package com.agkw.studentHub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendEmailService {
	
	@Autowired
    private JavaMailSender jMS;


public void sendingMail(String sendTo, String messageBody, String messageTitle) {
        SimpleMailMessage sMM = new SimpleMailMessage();
        sMM.setFrom("tt8897020@gmail.com");
        sMM.setTo(sendTo);
        sMM.setSubject(messageTitle);
        sMM.setText(messageBody);
        jMS.send(sMM);
    }
	

}
