package com.model.service;

import java.util.List;

import com.dto.entity.Businesses;

public interface BusinessService {

	boolean addBusiness(Businesses business);
    public List<Businesses> getAllBusinesses();
    public Businesses deleteBusiness(int businessId);
    public boolean updateBusinessEmail(int businessId, String newEmail);
    

}
