package com.test.dao;

import com.test.entity.TeacherEntity;

public interface ITeacherDao {
	int save(TeacherEntity entity) throws Exception;
}
