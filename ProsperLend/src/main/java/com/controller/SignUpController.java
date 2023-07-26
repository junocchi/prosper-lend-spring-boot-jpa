package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.service.FundingRequestCalc;
import com.model.service.UserDetailsService;
import com.dto.entity.UserDetails;

@Controller
public class SignUpController {

	@Autowired
	private UserDetailsService uService;

	@RequestMapping("/sign-up")
	public ModelAndView InsertUserDetailsPageController() {
		return new ModelAndView("sign-up-page.html");
	}

	@RequestMapping("/save-user")
	public ModelAndView saveUserController(HttpServletRequest request, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();

		String userLoginName = request.getParameter("userLoginName");
		String passcode = request.getParameter("passcode");
		String businessName = request.getParameter("businessName");
		String businessAdminEmail = request.getParameter("businessAdminEmail");
		long merchantID = Long.parseLong(request.getParameter("merchantId"));

		UserDetails user = new UserDetails(0, userLoginName, passcode, "", businessName, businessAdminEmail,
				merchantID);

		String message = null;

		if (uService.addUser(user)) {
			modelAndView.setViewName("home.html");
			session.setAttribute("username", userLoginName);
		} else {
			message = "There has been an error with your sign up";
			modelAndView.addObject("message", message);
			modelAndView.setViewName("sign-up-page.html");
		}

		return modelAndView;
	}

}