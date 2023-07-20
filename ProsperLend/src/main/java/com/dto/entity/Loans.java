package com.dto.entity;

import java.math.BigDecimal;
import java.sql.Date;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

public class Loans {
	
	@Id
	int loanID;
	BigDecimal amount;
	BigDecimal interest;
	int businessID;
	Date loanDate;
	@OneToMany
	 private List<Transaction> transactionList = new ArrayList<Transaction>();
	
	
	
//	loanID INT PRIMARY KEY,
//	  loanStatus VARCHAR(10),
//	  amount DECIMAL(10, 2),
//	  interest DECIMAL(5, 2),
//	  businessID INT,
//	  loanDate DATE,
//	  FOREIGN KEY (businessID) REFERENCES businesses(businessID)
//	

}
