package com.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dto.entity.UserDetails;
import com.model.persistence.UserDetailsDao;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserDetailsDao dao;

	@Override  
	public boolean addUser(UserDetails user) {
		try {
    		if (dao.insertUserLoginData(user.getUserLoginName(),
				user.getPasscode(), user.getBusinessName(), user.getBusinessAdminEmail(), user.getMerchantId()) > 0)
    			
    			return true;
		}
		catch(Exception ex) {
			return false;
		}
		return false;
}

	@Override
	public UserDetails getUserById(int id) {
		 UserDetails user = dao.findById(id).orElse(null);
		 return user;
	}

	@Override
	public UserDetails getUserByUsername(String username) {
		return null;
	}

	@Override
	public List<UserDetails> getAllUsers() {
		return dao.findAll();
	}

	@Override
	public boolean deleteUserById(int id) {
		if (getUserById(id) == null)
			return false;
		
		dao.deleteById(id);
		
		if (getUserById(id) == null)
			return true;
		else
			return false;
	}

	@Override
	public boolean updatePassword(UserDetails user) {
		return dao.updatePassword(user.getPasscode(), user.getUserLoginId()) > 0;
	}

}
