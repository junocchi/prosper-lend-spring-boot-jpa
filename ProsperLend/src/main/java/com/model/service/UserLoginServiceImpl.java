package com.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.entity.UserLogin;
import com.model.persistence.UserLoginDao;

@Service
public class UserLoginServiceImpl implements UserLoginService {
	@Autowired
	private UserLoginDao dao;

	@Override  
	public boolean addUser(UserLogin user) {
		try {
    		if (dao.insertUserLoginData(user.getUserLoginName(),
				user.getPasscode()) > 0)
    			
    			return true;
		}
		catch(Exception ex) {
			return false;
		}
		return false;
}

	@Override
	public UserLogin getUserById(int id) {
		Optional<UserLogin> optional = dao.findById(id);
		if (optional.isPresent())
			return optional.get();
		else
			return null;
	}

	@Override
	public UserLogin getUserByUsername(String username) {
		return dao.findUserByUsername(username);
	}

	@Override
	public List<UserLogin> getAllUsers() {
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
	public boolean updatePassword(UserLogin user) {
		return dao.updatePassword(user.getSalt(), user.getPasscode(), user.getUserLoginId()) > 0;
	}

}
