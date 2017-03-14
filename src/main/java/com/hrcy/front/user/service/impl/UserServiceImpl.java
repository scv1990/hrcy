package com.hrcy.front.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrcy.front.user.dao.UserMapper;
import com.hrcy.front.user.domain.User;
import com.hrcy.front.user.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper mUserMapper;

	@Override
	public boolean hasMatchUser(User user) {
		int count = mUserMapper.getMatchCount(user);
		if(count > 0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public User findUserByUserName(User user) {
		return mUserMapper.findUserByUserName(user);
	}
	

}
