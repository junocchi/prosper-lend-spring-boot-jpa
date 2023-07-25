package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AboutUsUserViewController {
	
	@RequestMapping("/about-us-user-view")
	public ModelAndView getAboutUsUserViewController() {
		return new ModelAndView("about-us-user-view.html");
	}
}
