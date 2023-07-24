package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dto.entity.Transaction;
import com.model.service.TransactionServiceImpl;

@RestController
public class TestController {
	@Autowired 
	private TransactionServiceImpl service;

	@RequestMapping("test/")
	public ModelAndView getAllTransactions() {
		ModelAndView modelAndView = new ModelAndView();
		
		List<Transaction> transactionList = service.getAllTransactions();
		
		modelAndView.addObject("paymentList", transactionList);
		modelAndView.setViewName("payment-history.html");
		return modelAndView;
	}
}
