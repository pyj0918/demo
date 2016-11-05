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
