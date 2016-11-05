package com.test.dao;

import com.test.entity.TeacherEntity;
import com.test.entity.UserEntity;

public interface IUserDao {
	int save(UserEntity entity) throws Exception;

	void save(UserEntity entity, TeacherEntity teacherEntity) throws Exception;
}
