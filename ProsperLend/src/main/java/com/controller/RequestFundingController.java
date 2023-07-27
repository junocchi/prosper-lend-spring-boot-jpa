package com.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.dto.entity.Loans;
import com.dto.entity.UserDetails;
import com.dto.entity.MyLoansObj;

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
	
	
	private MyLoansObj myLoans;
	
	

	@RequestMapping("/request-funding")
	public ModelAndView getRequestFundingController() {
		return new ModelAndView("request-funding.html");
	}
	
	
	
	
	
	
	@RequestMapping("/InterestDeduction")
	public ModelAndView fundingController(HttpServletRequest request) {
		
		
 		
		ModelAndView modelAndView=new ModelAndView();

		
		BigDecimal averageMonthlyIncome = new BigDecimal(request.getParameter("averageMonthlyIncome")); 
		BigDecimal currentDebt =new BigDecimal(request.getParameter("currentDebt"));
		BigDecimal funding = calc.fundingRequest(averageMonthlyIncome, currentDebt);
		String s = funding.toString();
		
		if (funding.compareTo(BigDecimal.valueOf(0)) < 0) {
			
			modelAndView.setViewName("funding-declined");
		}
		
		BigDecimal interest = BigDecimal.valueOf(10);
		
		String[] deductions = request.getParameterValues("checkboxList");
		
		for(int i = 0; i < deductions.length; i++) {
			
		interest =	interest.subtract(BigDecimal.valueOf(1));
			
		}
		
		BigDecimal repayment = calc.repaymentMonthly(interest, funding);
		
		repayment = repayment.setScale(2, RoundingMode.CEILING);
		
		String f = repayment.toString();
		
		BigDecimal months = repayment.divide(BigDecimal.valueOf(12),0, RoundingMode.UP);
		
		
		modelAndView.addObject("months", months);
		modelAndView.addObject("interest", interest);
		modelAndView.addObject("funding",s);
		modelAndView.addObject("repayment",f);
		modelAndView.setViewName("funding-options");
		
		return modelAndView;		
				
	
	
	}
}
	
	


	
	

