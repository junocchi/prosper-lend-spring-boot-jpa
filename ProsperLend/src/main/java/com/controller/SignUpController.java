package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.service.BusinessService;
import com.model.service.FundingRequestCalc;
import com.model.service.UserDetailsService;
import com.model.service.UserLoginService;
import com.dto.entity.UserDetails;
import com.dto.entity.Businesses;



@Controller
public class SignUpController {
	

	
	@Autowired
	private UserDetailsService uService;
	
	
	

	@RequestMapping("/InputUserDetails")
	public ModelAndView InsertUserDetailsPageController() {
		return new ModelAndView("sign-up-page");
	}
	
	
	@RequestMapping("/saveUser")
	public ModelAndView saveUserController(HttpServletRequest request) {
		
	
		
		
		ModelAndView modelAndView = new ModelAndView();
		
		String userLoginName = request.getParameter("userLoginName");
		String passcode = request.getParameter("passcode");
		String businessName = request.getParameter("businessName");
		String businessAdminEmail = request.getParameter("businessAdminEmail");
		long merchantID = Long.parseLong(request.getParameter("merchantId"));
		
		UserDetails user = new UserDetails(userLoginName, passcode, businessName, businessAdminEmail, merchantID);		
		
		


		
		String message = null;
		
		if ( uService.addUser(user))
			message = "Welcome to ProsperLend!";
		else
			message = "There has been an error with your sign up";

		modelAndView.addObject("message", message);
		modelAndView.setViewName("sign-up-page");

		return modelAndView;
	}


}