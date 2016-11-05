package com.test.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.IUserDao;
import com.test.entity.TeacherEntity;
import com.test.entity.UserEntity;

@Repository(value = "userDao")
public class UserDaoImpl extends DaoBase implements IUserDao {

	@Override
	public int save(UserEntity entity) throws Exception {
		return sessionTemplate.insert(userStatement.replace("{sqlId}", "save"), entity);
	}

	@Transactional
	@Override
	public void save(UserEntity entity, TeacherEntity teacherEntity) throws Exception {
		sessionTemplate.insert(userStatement.replace("{sqlId}", "save"), entity);
		sessionTemplate.insert(teacherStatement.replace("{sqlId}", "insertTeacher"), teacherEntity);

	}
}
