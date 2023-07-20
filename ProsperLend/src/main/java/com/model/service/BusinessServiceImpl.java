package com.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.entity.Business;
import com.model.persistence.BusinessDao;

@Service
public class BusinessServiceImpl implements BusinessService{
	
    @Autowired
    private BusinessDao dao;
    
    public List<Business> getAllBusinesses() {
        return dao.findAll();
    }

    public Business getBusinessById(int businessId) {
		Business business = dao.findById(businessId).orElse(null);
		return business;
    }

    public Business insertBusiness(Business business) {
    	if (getBusinessById(business.getBusinessId())==null)
    		return dao.save(business);
    	else
    		return null;
    }
    

    public Business deleteBusiness(int businessId) {
        Business business = getBusinessById(businessId);
        if (business != null)
        	dao.deleteById(businessId);
        return business;
    }
    
    
    public Business updateBusinessEmail(int businessId, String newEmail) {
        Business business = getBusinessById(businessId);
        if (business != null) {
            business.setBusinessAdminEmail(newEmail);
            return dao.save(business);
        }
        return null;
    }

}
