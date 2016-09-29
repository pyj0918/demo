package com.test.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.test.dao.IUserDao;
import com.test.entity.UserEntity;
import com.test.service.IUserService;

@Service(value = "userService")
public class UserServiceImpl implements IUserService {
	
	@Resource(name="userDao")
	private IUserDao userDao;

	@Override
	public void save() {
		UserEntity entity = new UserEntity(-1, "pyj222333", new Date(), 2365);
		userDao.save(entity);
	}

}
