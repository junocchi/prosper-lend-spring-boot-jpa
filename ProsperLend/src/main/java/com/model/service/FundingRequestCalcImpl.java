package com.model.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

@Service

public class FundingRequestCalcImpl implements FundingRequestCalc{

	
	@Override
	public BigDecimal fundingRequest(BigDecimal averageMonthlyIncome, BigDecimal currentDebt) {
		
		
		
		BigDecimal maxAmount = maxAmountCalc(averageMonthlyIncome);
		BigDecimal newMaxAmount = NewmaxAmountCalc(maxAmount,currentDebt);
        BigDecimal funding = options(newMaxAmount, maxAmount );
		
		
		return funding;
		
		
		
	}

	@Override
	public BigDecimal maxAmountCalc(BigDecimal averageMonthlyIncome) {
		
		BigDecimal maxAmount = averageMonthlyIncome.divide(BigDecimal.valueOf(10),2, RoundingMode.HALF_EVEN).multiply(BigDecimal.valueOf(24));
		
		return maxAmount;
	}
	
	
	
	
	
	@Override
	public BigDecimal NewmaxAmountCalc(BigDecimal maxAmount, BigDecimal currentDebt ) {
		
		BigDecimal newMaxAmount = (maxAmount).subtract(currentDebt);
		
		return newMaxAmount;
	}
	
	@Override
	public BigDecimal options(BigDecimal newMaxAmount, BigDecimal maxAmount) {
		
		BigDecimal optionOne = newMaxAmount;
		BigDecimal optionTwo = (optionOne).subtract(optionOne).multiply(BigDecimal.valueOf(25).divide(BigDecimal.valueOf(100),2, RoundingMode.HALF_EVEN));
		BigDecimal optionThree = (optionOne).subtract(optionTwo).multiply(BigDecimal.valueOf(25).divide(BigDecimal.valueOf(100),2, RoundingMode.HALF_EVEN));
   
	if ((newMaxAmount).compareTo(optionThree) > 0) {
		
		return optionOne;
	}
	
	else if ((optionTwo).compareTo(BigDecimal.valueOf(0)) > 0) {
		
		return optionTwo;
	}
		
	
	else if ((optionThree).compareTo(BigDecimal.valueOf(0)) > 0)  {
		
	
		return optionThree;
	}
		
		
	else	
		
		System.out.println("Your funding request has been declined");
		
		return (BigDecimal.valueOf(0));
		
		
		
	}
	


	
	
	
//	Calculation for Funding Request:
//		1) Calculate maxAmount:
//		maxAmount = (10% of averageMonthlyIncome) x 24
//		2) Calculate if it is possible to lend funding:
//		2.1- check currentDebt (from other loans) and calculate newMaxAmount:
//		newMaxAmount = maxAmount - currentDebt
//		2.2- calculate optionOne (highest amount to lend):
//		optionOne = newMaxAmount
//		2.3- calculate optionTwo:
//		optionTwo = optionOne - 25%
//		2.4- calculate optionTwo:
//		optionThree = option/two - 25%
//		Example:
//		averageMonthlyIncome = 10000
//		maxAmount = 24000
//		currentDebit = 6000
//		newMaxAmount = 18000
//		optionOne = 18000
//		optionTwo = 13500
//		optionThree = 10125
//
//		if newMaxAmount < maxAmount
//			display optionOne
//			if optionTwo > 0
//				display optionTwo
//				if optionThree > 0
//					display optionThree
//		else
//			decline funding request
	
	
}
