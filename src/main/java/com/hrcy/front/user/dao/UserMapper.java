package com.hrcy.front.user.dao;

import com.hrcy.front.user.domain.User;

public interface UserMapper {
	public void getUserById();
	
	public User findUserByUserName(User User);
	
	public int getMatchCount(User user);

}
