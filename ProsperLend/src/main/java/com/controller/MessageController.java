package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dto.entity.Messages;
import com.model.service.MessageService;

@Controller
public class MessageController {
	
	@Autowired
	private MessageService service;	
	
	
	@RequestMapping("/contact-us")
	public ModelAndView InputMessagePageController() {
		ModelAndView modelAndView=new ModelAndView();
		
		modelAndView.addObject("mess", new Messages());
		modelAndView.setViewName("contact-us.html");
		return modelAndView;
	}
	
	
	@RequestMapping("/save-message")
	public ModelAndView saveMessageController(@ModelAttribute("mess") Messages message) {
		ModelAndView modelAndView = new ModelAndView();
	
		String message1 = null;
		if (service.insertNewMessage(message)) {
		System.out.println(message);
			message1 = "Message sent";
		}
		else {
			System.out.println(message);
			message1 = "Message not sent";
		}
			
		modelAndView.addObject("message", message1);
		modelAndView.setViewName("Output");

		return modelAndView;
	}

}
