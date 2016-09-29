package com.test.dao;

import com.test.entity.UserEntity;

public interface UserDao {
	/**
	 * 方法名与userDao.xml中语句的id值对应
	 * @param entity
	 */
	void save(UserEntity entity);
}
