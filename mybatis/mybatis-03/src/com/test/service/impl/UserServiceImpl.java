package com.test.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.UserDao;
import com.test.entity.UserEntity;
import com.test.service.IUserService;

@Service(value = "userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserDao userDao;

	@Override
	public void save() {
		UserEntity entity = new UserEntity(-1, "test222", new Date(), 2365);
		userDao.save(entity);
	}

}
