package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MyLoansController {

	@RequestMapping("/my-loans")
	public ModelAndView getMyLoansController() {
		return new ModelAndView("my-loans.html");
	}
}
