package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

import com.dto.entity.Business;
import com.dto.entity.Message;
import com.model.service.BusinessService;

@RestController
public class BusinessController {
	
	@Autowired
	private BusinessService service;
	
	
	@RequestMapping("/profile-page")
	public ModelAndView DisplayBusinessDetailsController(
	    @RequestParam(value = "businessId", defaultValue = "101") int businessId) {

	    ModelAndView modelAndView = new ModelAndView();
	    Business busi = service.getBusinessById(businessId);

	    if (busi != null) {
	        modelAndView.addObject("business", busi);
	        modelAndView.setViewName("profile-page.html");
	    } else {
	        modelAndView.addObject("message", "business with ID " + businessId + " does not exist");
	        modelAndView.setViewName("Output.html");
	    }
	    return modelAndView;
	}

