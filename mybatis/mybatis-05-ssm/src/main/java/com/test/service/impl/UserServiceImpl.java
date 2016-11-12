package com.test.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.entity.TeacherEntity;
import com.test.entity.UserEntity;
import com.test.service.IUserService;

@Service(value = "userService")
public class UserServiceImpl extends ServiceBase implements IUserService {

	@Override
	public void save() {
		try {
			userDao.save(new UserEntity(-1, "nihao", new Date(), 56985));
			System.out.println("333");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 注意点: 1. @Transactional注解起作用的方法必须是public类型   2.该方法必须抛出异常. 3.MySQL数据库类型的选择(InnoDB）
	 */
	@Transactional
	@Override
	public void saveUserAndTeacher() {
		test();
	}

	private void test() {
		try {
			UserEntity user = new UserEntity(-1, "nihao", new Date(), 56985);
			userDao.save(user);
			System.out.println(user.getId());
			teacherDao.save(new TeacherEntity(1, "pyj"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
