package com.test.service.impl;

import javax.annotation.Resource;

import com.test.dao.ITeacherDao;
import com.test.dao.IUserDao;

public class ServiceBase {
	@Resource(name = "userDao")
	protected IUserDao userDao;
	@Resource(name = "teacherDao")
	protected ITeacherDao teacherDao;
}
