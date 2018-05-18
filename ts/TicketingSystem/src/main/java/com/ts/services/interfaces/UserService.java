package com.ts.services.interfaces;

import com.ts.models.User;

public interface UserService {

	public User findUser(String username, String password);
}
