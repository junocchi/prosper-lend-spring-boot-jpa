package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class WelcomeUserController {

	@RequestMapping("/welcome-user")
	public ModelAndView getWelcomeUserController() {
		return new ModelAndView("welcome-user.html");
	}
}
