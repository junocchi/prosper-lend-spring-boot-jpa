package com.model.service;

import java.math.BigDecimal;

public interface FundingRequestCalc {

	
	
	public BigDecimal maxAmountCalc(BigDecimal averageMonthlyIncome);
	BigDecimal NewmaxAmountCalc(BigDecimal maxAmount ,BigDecimal currentDebt);
	BigDecimal options(BigDecimal newmaxAmount, BigDecimal currentDebt);
	BigDecimal fundingRequest(BigDecimal averageMonthlyIncome, BigDecimal currentDebt);
	
	
}
