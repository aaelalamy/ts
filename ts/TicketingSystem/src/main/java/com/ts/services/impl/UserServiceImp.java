package com.ts.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ts.models.User;
import com.ts.repositories.application.UserRepository;
import com.ts.services.interfaces.UserService;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User findUser(String username, String password) {
		return userRepository.findByUsernameAndPassword(username, password);
	}

}
