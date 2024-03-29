package com.juaracoding.serviceapi.services;

import java.util.List;
import java.util.Optional;

import com.juaracoding.serviceapi.entity.User;

public interface ModelUsersInterface {
	
	public List<User> getAllUser();
	public Optional<User> getUserByEmail(String email);
	public User getUserByName(String name);
	
	public User addUser (User user);
	public User getUserById(String id);
	public void deleteUser(String id);

}
