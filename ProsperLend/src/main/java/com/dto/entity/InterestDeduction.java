package com.dto.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="InterestDeductions")


public class InterestDeduction {
	@Id 
	private int interestDeductionId;
	private String items;
	private Double deductionAmount;
	
	public InterestDeduction(int interestDeductionId, String items, Double deductionAmount) {
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

	public Double getDeductionAmount() {
		return deductionAmount;
	}

	public void setDeductionAmount(Double deductionAmount) {
		this.deductionAmount = deductionAmount;
	}

	@Override
	public String toString() {
		return "InterestDeduction [interestDeductionId = " + interestDeductionId + ", items = " + items
				+ ", deductionAmount = " + deductionAmount + "]";
	}
}
