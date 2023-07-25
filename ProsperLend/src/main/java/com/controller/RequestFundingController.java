package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class RequestFundingController {

	@RequestMapping("/request-funding")
	public ModelAndView getRequestFundingController() {
		return new ModelAndView("request-funding.html");
	}
}
