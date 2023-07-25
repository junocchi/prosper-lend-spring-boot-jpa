package com.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.entity.Business;
import com.model.persistence.BusinessDao;
import com.model.persistence.UserLoginDao;

@Service
public class BusinessServiceImpl implements BusinessService{
	
    @Autowired
    private BusinessDao dao;
    
    @Autowired
    private UserLoginDao userDao;
    
    @Override
    public List<Business> getAllBusinesses() {
        return dao.findAll();
    }

    @Override
    public Business getBusinessById(int businessId) {
		Business business = dao.findById(businessId).orElse(null);
		return business;
    }

    @Override
    public Business insertBusiness(Business business) {
    	if (getBusinessById(business.getBusinessId())==null)
    		return dao.save(business);
    	else
    		return null;
    }
    
    @Override
    public Business deleteBusiness(int businessId) {
        Business business = getBusinessById(businessId);
        if (business != null)
        	dao.deleteById(businessId);
        return business;
    }
    
    @Override
    public Business updateBusinessEmail(int businessId, String newEmail) {
        Business business = getBusinessById(businessId);
        if (business != null) {
            business.setBusinessAdminEmail(newEmail);
            return dao.save(business);
        }
        return null;
    }
    
}
