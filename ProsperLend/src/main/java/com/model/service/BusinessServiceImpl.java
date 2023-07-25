//package com.model.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.dto.entity.Businesses;
//import com.model.persistence.BusinessDao;
//import com.model.persistence.UserLoginDao;
//
//@Service
//public class BusinessServiceImpl implements BusinessService{
//	
//    @Autowired
//    private BusinessDao dao;
//
//    @Override
//    public List<Businesses> getAllBusinesses() {
//        return dao.findAll();
//    }
//
//    public Businesses getBusinessById(int businessId) {
//		Businesses business = dao.findById(businessId).orElse(null);
//
//		
//    }
//    @Autowired
//    private UserLoginDao userDao;
//    
//    @Override
//    public List<Business> getAllBusinesses() {
//        return dao.findAll();
//    }
//
//    @Override
//    public Business getBusinessById(int businessId) {
//		Business business = dao.findById(businessId).orElse(null);
//>>>>>>> b0ac2b20f7375da63951e65d618c2a5fedef0370
//		return business;
//    }
//
//    @Override
//<<<<<<< HEAD
//    public boolean addBusiness(Businesses business) {
//    	try {
//    		if(dao.addBusisness( 
//    				business.getUserLogin().getUserLoginId(), business.getBusinessName(),
//    				business.getBusinessAdminEmail(), business.getMerchantId())>0)
//    			
//    			
//    			return true;
//    		}
//    		catch(Exception ex) {
//    			return false;
//    		}
//    		return false;
//    }
//    
//    @Override
//    public Businesses deleteBusiness(int businessId) {
//        Businesses business = getBusinessById(businessId);
//=======
//    public Business insertBusiness(Business business) {
//    	if (getBusinessById(business.getBusinessId())==null)
//    		return dao.save(business);
//    	else
//    		return null;
//    }
//    
//    @Override
//    public Business deleteBusiness(int businessId) {
//        Business business = getBusinessById(businessId);
//>>>>>>> b0ac2b20f7375da63951e65d618c2a5fedef0370
//        if (business != null)
//        	dao.deleteById(businessId);
//        return business;
//    }
//    
//    @Override
//<<<<<<< HEAD
//    public boolean updateBusinessEmail(int businessId, String newEmail) {
//       
//        if(dao.updateBusinessEmail(businessId, newEmail)>0)
//			return true;
//		else
//			return false;
//
//=======
//    public Business updateBusinessEmail(int businessId, String newEmail) {
//        Business business = getBusinessById(businessId);
//        if (business != null) {
//            business.setBusinessAdminEmail(newEmail);
//            return dao.save(business);
//        }
//        return null;
//    }
//    
//>>>>>>> b0ac2b20f7375da63951e65d618c2a5fedef0370
//}
//    
//}
