package com.dto.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="InterestDeduction")
public class InterestDeduction {
	@Id
	private int interestDeductionId;
	private String items;
	private double deductionAmount;
	
	public InterestDeduction(int interestDeductionId, String items, double deductionAmount) {
		super();
		this.interestDeductionId = interestDeductionId;
		this.items = items;
		this.deductionAmount = deductionAmount;
	}

	public InterestDeduction() {
		super();
	}

	public int getInterestDeductionId() {
		return interestDeductionId;
	}

	public void setInterestDeductionId(int interestDeductionId) {
		this.interestDeductionId = interestDeductionId;
	}

	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

	public double getDeductionAmount() {
		return deductionAmount;
	}

	public void setDeductionAmount(double deductionAmount) {
		this.deductionAmount = deductionAmount;
	}

	@Override
	public String toString() {
		return "InterestDeduction [interestDeductionId = " + interestDeductionId + ", items = " + items
				+ ", deductionAmount = " + deductionAmount + "]";
	}
}
