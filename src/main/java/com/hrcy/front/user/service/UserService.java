package com.hrcy.front.user.service;

import com.hrcy.front.user.domain.User;

public interface UserService {
	public boolean hasMatchUser(User user);
	
	public User findUserByUserName(User user);

}
