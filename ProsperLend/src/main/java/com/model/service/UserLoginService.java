package com.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dto.entity.UserLogin;

public interface UserLoginService {
	public boolean addUser(UserLogin user);
	public UserLogin getUserById(int id);
	public UserLogin getUserByUsername(String username);
	public List<UserLogin> getAllUsers();
	public boolean deleteUserById(int id);
	public boolean updatePassword(UserLogin user);
}
