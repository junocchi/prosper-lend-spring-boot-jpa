package com.model.service;

public interface FundingRequestCalc {

	
	public double fundingRequest();
	public double maxAmountCalc(double averageMonthlyIncome);
	double NewmaxAmountCalc(double maxAmount ,double currentDebt);
	double options(double newmaxAmount, double currentDebt);
	
	
}
