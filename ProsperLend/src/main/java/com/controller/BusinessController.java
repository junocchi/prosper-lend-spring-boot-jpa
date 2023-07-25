package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dto.entity.Business;
import com.dto.entity.Message;
import com.model.service.BusinessService;

@Controller
public class BusinessController {
	
	@Autowired
	private BusinessService service;
	
	
	@RequestMapping("/profile-page")
	public ModelAndView searchBusinessByIdController(@ModelAttribute("business") Business business) {
	    ModelAndView modelAndView = new ModelAndView();
	    return null;
	}
	    


}
