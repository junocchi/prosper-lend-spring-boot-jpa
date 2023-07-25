package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AboutUsVisitorViewController {

	@RequestMapping("/about-us-visitor-view")
	public ModelAndView getAboutUsVisitorViewController() {
		return new ModelAndView("about-us-visitor-view.html");
	}
}
