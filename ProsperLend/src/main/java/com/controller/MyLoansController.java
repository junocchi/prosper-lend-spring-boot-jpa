package com.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dto.entity.Loans;
import com.dto.entity.MyLoansObj;
import com.dto.entity.Transaction;
import com.dto.entity.UserDetails;
import com.model.service.LoanServiceImp;
import com.model.service.TransactionServiceImpl;
import com.model.service.UserDetailsServiceImpl;

@RestController
public class MyLoansController {
	@Autowired 
	private TransactionServiceImpl transactionService;
	@Autowired 
	private LoanServiceImp loansService;
	@Autowired 
	private UserDetailsServiceImpl usersService;

	@RequestMapping("/my-loans")
	public ModelAndView getMyLoansController(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		
		List<MyLoansObj> loanList = new ArrayList<MyLoansObj>();
		List<Loans> allLoans = loansService.getAllLoans();
		
		UserDetails user = usersService.getUserByUsername((String) session.getAttribute("username"));
		System.out.println("My loans controller username: " + session.getAttribute("username"));
		
		MyLoansObj loan = new MyLoansObj();
		
		for (Loans aLoan : allLoans) {
			if(aLoan.getUserLoginId() == user.getUserLoginId()) {
				loan.setLoanCount(loanList.size() + 1);
				loan.setBorrowAmount(BigDecimal.valueOf(aLoan.getAmount()).setScale(2, RoundingMode.HALF_UP));
				loan.setLoanDate(aLoan.getLoanDate());
				loan.setInterest(aLoan.getInterest() * 100);
				loan.setStatus(aLoan.getLoanStatus());
				loan.setDeduction(10 - loan.getInterest());
				loan.setRepayAmount( loan.getBorrowAmount().add( loan.getBorrowAmount().multiply(BigDecimal.valueOf(loan.getInterest())).divide(new BigDecimal(100))).setScale(2, RoundingMode.HALF_UP));
				
				java.time.LocalDate currentDate = java.time.LocalDate.now();
				java.time.LocalDate sqlDate = loan.getLoanDate().toLocalDate();
				
				loan.setTime(sqlDate.until(currentDate, ChronoUnit.MONTHS) + " Months Ago");
				
				System.out.println("Loan so far: " + loan);
				
				loan.setBalance(loan.getRepayAmount());
				
				List<Transaction> transactionList = transactionService.findAllTransactionsForLoan(aLoan.getLoanID());
				System.out.println(transactionList.get(0));
				
				for (Transaction transaction : transactionList) {
					System.out.println("Transaction: " + transaction);
					loan.setBalance(loan.getBalance().subtract(BigDecimal.valueOf(transaction.getAmount())));
				}
				System.out.println(loan);
				loanList.add(loan);
				loan = new MyLoansObj();
			}
		}
		
		modelAndView.addObject("loanList", loanList);
		modelAndView.setViewName("my-loans.html");
		return modelAndView;
	}
}
