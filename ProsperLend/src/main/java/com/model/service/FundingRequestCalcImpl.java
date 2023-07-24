package com.model.service;

import org.springframework.stereotype.Service;

@Service

public class FundingRequestCalcImpl implements FundingRequestCalc{

	
	@Override
	public double fundingRequest() {
		
		double averageMonthlyIncome = 100000;
		double currentDebt = 1000;
		
		double maxAmount = maxAmountCalc(averageMonthlyIncome);
		double newMaxAmount = NewmaxAmountCalc(maxAmount,currentDebt);
		
		double funding = options(newMaxAmount, maxAmount );
		
		
		return funding;
		
		
		
	}

	@Override
	public double maxAmountCalc(double averageMonthlyIncome) {
		
	double maxAmount = averageMonthlyIncome / 10 * 24;
		
		return maxAmount;
	}
	
	
	
	
	
	@Override
	public double NewmaxAmountCalc(double maxAmount, double currentDebt ) {
		
	double newMaxAmount = maxAmount - currentDebt;
		
		return newMaxAmount;
	}
	
	@Override
	public double options(double newMaxAmount, double maxAmount) {
		
	double optionOne = newMaxAmount;
	double optionTwo = optionOne - (optionOne*25/100);
	double optionThree = optionTwo - (optionTwo*25/100);
   
	if (newMaxAmount < maxAmount) {
		
		return optionOne;
	}
	
	else if (optionTwo > 0) {
		
		return optionTwo;
	}
		
	
	else if (optionThree > 0) {
		
	
		return optionThree;
	}
		
		
	else	
		
		System.out.println("Your funding request has been declined");
		
		return 0;
		
		
		
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
