package com.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dto.entity.InterestDeduction;

public interface InterestReductionService {
	public InterestDeduction addCriterion(InterestDeduction interestDeduction);
	public InterestDeduction getCriterionById(int id);
	public List<InterestDeduction> getAllCriteria();
	public boolean deleteCriterionById(int id);
	public boolean updateCriterion(InterestDeduction interestDeduction);
}
