package com.controller;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.dto.entity.Loans;
import com.dto.entity.UserDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.model.service.FundingRequestCalc;
import com.model.service.LoanService;
import com.model.service.UserDetailsService;

@RestController
public class RequestFundingController {
	
	@Autowired
	private FundingRequestCalc calc;
	
	
	@Autowired
	private LoanService dao;
	
	
	@Autowired
	private UserDetailsService udao;
	

	@RequestMapping("/request-funding")
	public ModelAndView getRequestFundingController() {
		return new ModelAndView("request-funding.html");
	}
	
	
	
	
	
	
	@RequestMapping("/InterestDeduction")
	public ModelAndView fundingController(HttpServletRequest request) {
		
		
 		
		ModelAndView modelAndView=new ModelAndView();

		int userID = Integer.parseInt(request.getParameter("userLoginId"));
		BigDecimal averageMonthlyIncome = new BigDecimal(request.getParameter("averageMonthlyIncome")); 
		BigDecimal currentDebt = dao.getDebtByUserID(userID);
		String t = currentDebt.toString();
	
		
		modelAndView.addObject("funding", t);
		modelAndView.setViewName("fundingRequestTest");
		
		return modelAndView;		
				
	
	
	}
}
	
	


	
	

