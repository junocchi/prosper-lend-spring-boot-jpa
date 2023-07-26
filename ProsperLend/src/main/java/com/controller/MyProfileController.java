package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MyProfileController {

	@RequestMapping("/my-profile")
	public ModelAndView getMyProfileController() {
		return new ModelAndView("my-profile.html");
	}
}
