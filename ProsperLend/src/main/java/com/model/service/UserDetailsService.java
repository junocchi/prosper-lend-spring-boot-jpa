package com.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dto.entity.UserDetails;

public interface UserDetailsService {
	public boolean addUser(UserDetails user);
	public UserDetails getUserById(int id);
	public UserDetails getUserByUsername(String username);
	public List<UserDetails> getAllUsers();
	public boolean deleteUserById(int id);
	public boolean updatePassword(UserDetails user);
	public boolean matchUsernamePassword(String username, String password);
}
