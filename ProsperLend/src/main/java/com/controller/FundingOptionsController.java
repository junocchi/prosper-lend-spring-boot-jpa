package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class FundingOptionsController {

	@RequestMapping("/funding-options")
	public ModelAndView getFundingOptions() {
		return new ModelAndView("funding-options.html");
	}
}
