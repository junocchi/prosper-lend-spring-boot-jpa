package com.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dto.entity.UserDetails;
import com.dto.entity.UserDetailsList;
import com.model.service.UserDetailsService;

@RestController

public class UserDetailsController {
	
	
	@Autowired
	private UserDetailsService userDetailsService;
	

}
	


