package com.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.entity.Businesses;
import com.model.persistence.BusinessDao;

@Service
public class BusinessServiceImpl implements BusinessService{
	
    @Autowired
    private BusinessDao dao;
    
    public List<Businesses> getAllBusinesses() {
        return dao.findAll();
    }

    public Businesses getBusinessById(int businessId) {
		Businesses business = dao.findById(businessId).orElse(null);
		return business;
    }

    public boolean AddBusiness(Businesses business) {
    	try {
    		if(dao.addBusisness( 
    				business.getUserLogin().getUserLoginId(), business.getBusinessName(),
    				business.getBusinessAdminEmail(), business.getMerchantId())>0)
    			
    			
    			return true;
    		}
    		catch(Exception ex) {
    			return false;
    		}
    		return false;
    }
    

    public Businesses deleteBusiness(int businessId) {
        Businesses business = getBusinessById(businessId);
        if (business != null)
        	dao.deleteById(businessId);
        return business;
    }
    
    
    public boolean updateBusinessEmail(int businessId, String newEmail) {
       
        if(dao.updateBusinessEmail(businessId, newEmail)>0)
			return true;
		else
			return false;

}
    
}
