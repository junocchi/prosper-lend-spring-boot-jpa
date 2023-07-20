package com.model.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dto.entity.InterestDeduction;

@Repository
public interface InterestDeductionDao extends JpaRepository<InterestDeduction, Integer>{
	
}
