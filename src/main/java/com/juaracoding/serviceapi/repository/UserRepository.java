package com.juaracoding.serviceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juaracoding.serviceapi.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	public User findById(long id);
}
