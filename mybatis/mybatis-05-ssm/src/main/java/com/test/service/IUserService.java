package com.test.service;

public interface IUserService {
	/**
	 * 保存用户
	 */
	void save();
	/**
	 * 保存用户和老师，用来测试事物
	 */
	void saveUserAndTeacher();
}
