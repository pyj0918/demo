package com.test.service.impl;

import javax.annotation.Resource;

import com.test.dao.IUserDao;

public class BaseService {
	@Resource(name="userDao")
	protected IUserDao userDao;
}
