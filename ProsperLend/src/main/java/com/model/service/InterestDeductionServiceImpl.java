package com.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.entity.InterestDeduction;
import com.model.persistence.InterestDeductionDao;

@Service
public class InterestDeductionServiceImpl implements InterestDeductionService {
	@Autowired
	private InterestDeductionDao dao;
	
	@Override
	public InterestDeduction addCriterion(InterestDeduction interestDeduction) {
		return dao.save(interestDeduction);
	}

	@Override
	public InterestDeduction getCriterionById(int id) {
		Optional<InterestDeduction> optional = dao.findById(id);
		if (optional.isPresent())
			return optional.get();
		else
			return null;
	}

	@Override
	public List<InterestDeduction> getAllCriteria() {
		return dao.findAll();
	}

	@Override
	public boolean deleteCriterionById(int id) {
		if (getCriterionById(id) == null)
			return false;
		
		dao.deleteById(id);
		
		if (getCriterionById(id) == null)
			return true;
		else
			return false;
	}

	@Override
	public boolean updateCriterion(InterestDeduction interestDeduction) {
		if (dao.save(interestDeduction) == null)
			return false;
		else
			return true;
	}

}
