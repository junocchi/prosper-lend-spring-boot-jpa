
package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.dto.entity.UserDetails;
import com.model.service.UserDetailsService;

@Controller

public class MyProfileController {

	@Autowired
	UserDetailsService service;

	
	@RequestMapping("/my-profile")
	public ModelAndView DisplaUserDetailsController()
	// @RequestParam(value = "userLoginId", defaultValue = "1") int userLoginId)
	{
		ModelAndView modelAndView = new ModelAndView();
		UserDetails userDetails = service.getUserById(1);
		System.out.println(userDetails);
		if (userDetails != null) {
			modelAndView.addObject("userDetails", userDetails);
			modelAndView.setViewName("my-profile.html");
		}
		else {
			modelAndView.addObject("message", "user with ID " + 1 + " does not exist");
			modelAndView.setViewName("Output.html");
		}
		return modelAndView;
	}

}
