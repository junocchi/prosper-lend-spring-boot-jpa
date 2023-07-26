package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UpdateImageController {
	@RequestMapping("/update-image")
	public ModelAndView getUpdateImageControllerController() {
		return new ModelAndView("update-image.html");
	}
}
