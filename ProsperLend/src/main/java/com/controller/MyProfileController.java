
package com.controller;

import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.dto.entity.UserDetails;
import com.model.service.UserDetailsService;

@Controller
public class MyProfileController {

	@Autowired
	UserDetailsService service;

	
//	@RequestMapping("/my-profile")
//	public ModelAndView DisplaUserDetailsController()
//	// @RequestParam(value = "userLoginId", defaultValue = "1") int userLoginId)
//	{
//		ModelAndView modelAndView = new ModelAndView();
//		UserDetails userDetails = service.getUserById(1);
//		System.out.println(userDetails);
//		if (userDetails != null) {
//			modelAndView.addObject("userDetails", userDetails);
//			modelAndView.setViewName("my-profile.html");
//		}
//		else {
//			modelAndView.addObject("message", "user with ID " + 1 + " does not exist");
//			modelAndView.setViewName("Output.html");
//		}
//		return modelAndView;
//	}
	
	
	@RequestMapping("/my-profile")
	public ModelAndView displayUserDetailsController(HttpSession session) {
	    ModelAndView modelAndView = new ModelAndView();

	    //session.setAttribute("username", "user");

	    String username = (String) session.getAttribute("username");
	    UserDetails userDetails = service.getUserByUsername(username);

	    if (userDetails != null) {
	        UserDetails userDetailsToDisplay = new UserDetails();
	        userDetailsToDisplay.setUserLoginName(userDetails.getUserLoginName());
	        userDetailsToDisplay.setBusinessName(userDetails.getBusinessName());
	        userDetailsToDisplay.setBusinessAdminEmail(userDetails.getBusinessAdminEmail());
	        userDetailsToDisplay.setMerchantId(userDetails.getMerchantId());

	        modelAndView.addObject("userDetails", userDetailsToDisplay);
	        modelAndView.setViewName("my-profile.html");
	    } else {
	        modelAndView.addObject("message", "User with username " + username + " does not exist");
	        modelAndView.setViewName("Output.html");
	    }

	    return modelAndView;
	}
	
	@RequestMapping("/update-email")
	public ModelAndView emailUpdateController(){
		return new ModelAndView("update-email.html");
	}
	
	
	@PostMapping("/update-email-message")
	public ModelAndView updateEmailController(HttpSession session, @RequestParam("newEmail") String businessAdminEmail) {

		//session.setAttribute("username", "test_user");

		UserDetails userDetails = service.getUserByUsername( (String) session.getAttribute("username") );
		
		userDetails.setBusinessAdminEmail(businessAdminEmail);
		
		String message=null;
		
		if(service.updateEmail(userDetails))
			message="Email updated";
		else
			message="Email not updated";
		
		return new ModelAndView("Output", "message", message);
	}
	
	

	@RequestMapping("/update-name")
	public ModelAndView nameUpdateController(){
		return new ModelAndView("update-login-name.html");
	}

	
	@PostMapping("/update-name-message")
	public ModelAndView updateNameController(HttpSession session, @RequestParam("newName") String userLoginName) {

		//session.setAttribute("username", "test_user");

		UserDetails userDetails = service.getUserByUsername( (String) session.getAttribute("username") );
		
		userDetails.setUserLoginName(userLoginName);
		
		String message=null;
		
		if(service.updateLoginName(userDetails))
			message="Login Name Updated";
		else
			message="Login Name Not Updated";
		
		return new ModelAndView("Output", "message", message);
	}
	
//	@RequestMapping("/update-merchant-id")
//	public ModelAndView merchantIdUpdateController(){
//		return new ModelAndView("update-merchant-id.html");
//	}
//	
//	
//	@PostMapping("/update-merchant-id-message")
//	public ModelAndView updateMerchantIdController(HttpSession session, @RequestParam("newId") long merchantId) {
//		//session.setAttribute("username", "test_user2");
//		UserDetails userDetails = service.getUserByUsername( (String) session.getAttribute("username") );
//		
//		userDetails.setMerchantId(merchantId);
//		
//		String message=null;
//		
//		if(service.updateMerchantId(userDetails))
//			message="Merchant ID Updated";
//		else
//			message="Merchant ID Not Updated";
//		
//		return new ModelAndView("Output", "message", message);
//	}
	
	@RequestMapping("/update-image")
	public ModelAndView imageUpdateController(){
		return new ModelAndView("update-image.html");
	}
	

	@PostMapping("/update-image-message")
	public ModelAndView updateImageController(HttpSession session, @RequestParam("newImage") String userLoginName) {
		//session.setAttribute("username", "test_user");
		UserDetails userDetails = service.getUserByUsername( (String) session.getAttribute("image") );

	@PostMapping("/update-merchant-id-message")
	public ModelAndView updateMerchantIdController(HttpSession session, @RequestParam("newId") long merchantId) {
		
		UserDetails userDetails = service.getUserByUsername( (String) session.getAttribute("username") );

		
		userDetails.setUserLoginName(userLoginName);
		
		String message=null;
		
		if(service.updateLoginName(userDetails))
			message="Login Name Updated";
		else
			message="Login Name Not Updated";
		
		return new ModelAndView("Output", "message", message);
	}
	
	
}
