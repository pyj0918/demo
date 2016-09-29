package com.test.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.test.entity.UserEntity;
import com.test.service.IUserService;

@Service(value = "userService")
public class UserServiceImpl extends BaseService implements IUserService {

	@Override
	public void save() {
		userDao.save(new UserEntity(-1,"nihao",new Date(),56985));
	}

}
