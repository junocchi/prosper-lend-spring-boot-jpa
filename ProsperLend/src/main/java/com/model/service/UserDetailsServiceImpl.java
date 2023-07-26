package com.model.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

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
			Random rand = new Random();
			int salt = rand.nextInt(999999 - 100000 + 1) + 100000;

			if (dao.insertUserLoginData(user.getUserLoginName(), String.valueOf(salt), user.getPasscode(),
					String.valueOf(salt), user.getBusinessName(), user.getBusinessAdminEmail(),
					user.getMerchantId(), user.getImage()) > 0)
				return true;
		} catch (Exception ex) {
			System.out.println("Service addUser failed.");
			return false;
		}
		return false;
	}

	@Override
	public UserDetails getUserById(int id) {
		UserDetails user = dao.findById(id).orElse(null);
		System.out.println(user);
		return user;
	}

	
	
	@Override
	public UserDetails getUserByUsername(String username) {
		return dao.getUserByUsername(username);
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

	@Override
	public boolean matchUsernamePassword(String username, String password) {
		System.out.println("Match: " + dao.matchUsernamePassword(username, password));
		return dao.matchUsernamePassword(username, password) != null;
	}
	
	
//	@Override
//	public boolean updateEmail(UserDetails user) {
//		
//		if(dao.save(user) != null)
//			return true;
//		else
//			return false;
//	}

	
	@Override
	public boolean updateEmail(UserDetails user) {
	    UserDetails existingUser = dao.getUserByUsername(user.getUserLoginName());
	    if (existingUser != null) {
	        existingUser.setBusinessAdminEmail(user.getBusinessAdminEmail());
	        return dao.save(existingUser) != null;
	    } else {
	        return false;
	    }
	}
	
	@Override
	public boolean updateLoginName(UserDetails user) {
	    UserDetails existingUser = dao.getUserByUsername(user.getUserLoginName());
	    if (existingUser != null) {
	        existingUser.setUserLoginName(user.getUserLoginName());
	        return dao.save(existingUser) != null;
	    } else {
	        return false;
	    }
	}
	
	@Override
	public boolean updateMerchantId(UserDetails user) {
	    UserDetails existingUser = dao.getUserByUsername(user.getUserLoginName());
	    if (existingUser != null) {
	        existingUser.setMerchantId(user.getMerchantId());
	        return dao.save(existingUser) != null;
	    } else {
	        return false;
	    }
	}
}

