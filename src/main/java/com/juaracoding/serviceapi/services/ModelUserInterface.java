package com.juaracoding.serviceapi.services;

import java.util.List;

import com.juaracoding.serviceapi.entity.User;


public interface ModelUserInterface {

	public List<User> getAllUser();
	
	public User addUser (User user);
	public User getUserById(String id);
	public void deleteUser(String id);
}
