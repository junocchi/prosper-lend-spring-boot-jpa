package com.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dto.entity.Transaction;
import com.dto.entity.MyLoansObj;
import com.dto.entity.Loans;
import com.model.service.TransactionServiceImpl;
import com.model.service.LoanServiceImp;

@RestController
public class TestController {
	@Autowired 
	private TransactionServiceImpl transactionService;
	@Autowired 
	private LoanServiceImp loansService;

	@RequestMapping("test/payment-history")
	public ModelAndView getAllTransactions() {
		ModelAndView modelAndView = new ModelAndView();
		
		List<Transaction> transactionList = transactionService.getAllTransactions();
		
		modelAndView.addObject("paymentList", transactionList);
		modelAndView.setViewName("payment-history.html");
		return modelAndView;
	}
  
//	Loans for business with ID 101
	@RequestMapping("test/my-loans")
	public ModelAndView myLoansPageController() {
		ModelAndView modelAndView = new ModelAndView();
		
		List<MyLoansObj> loanList = new ArrayList<MyLoansObj>();
		List<Transaction> transactionList = transactionService.getAllTransactions();
		List<Loans> allLoans = loansService.getAllLoans();
		
		MyLoansObj loan = new MyLoansObj();
		
		for (Loans aLoan : allLoans) {
			if(aLoan.getBusinessID() == 101) {
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
				
				loan.setBalance(BigDecimal.valueOf(0));
				for (Transaction transaction : transactionList) {
					System.out.println(transaction);
					if (transaction.getLoanId() == aLoan.getLoanID()) {
						loan.setBalance(loan.getBalance().add(BigDecimal.valueOf(1)));
					}
				}
				System.out.println(loan.getBorrowAmount() + "-" + loan.getBalance() + "*" + loan.getRepayAmount());
				loan.setBalance(loan.getBorrowAmount().subtract(loan.getBalance().multiply(loan.getRepayAmount())));
				
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
