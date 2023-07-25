package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AboutUsController {
	
	@RequestMapping("/about-us")
	public ModelAndView getAboutUsController() {
		return new ModelAndView("about-us.html");
	}
}
