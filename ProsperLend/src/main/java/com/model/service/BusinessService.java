package com.model.service;

import java.util.List;

import com.dto.entity.Business;

public interface BusinessService {

	public List<Business> getAllBusinesses();

	Business getBusinessById(int businessId);

	Business insertBusiness(Business business);

	Business deleteBusiness(int businessId);

	Business updateBusinessEmail(int businessId, String newEmail);
	
	

}
