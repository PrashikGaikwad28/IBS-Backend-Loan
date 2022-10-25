package com.ibs.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibs.demo.model.User;
import com.ibs.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	
	public User findByEmail(String emailId) {
		return repository.findByEmailId(emailId);
	}
	
	public User findByUserName(String userName) {
		return repository.findByUserName(userName);
	}
}
