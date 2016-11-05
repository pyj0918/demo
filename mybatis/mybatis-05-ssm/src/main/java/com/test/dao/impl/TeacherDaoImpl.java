package com.test.dao.impl;

import org.springframework.stereotype.Repository;

import com.test.dao.ITeacherDao;
import com.test.entity.TeacherEntity;

@Repository(value = "teacherDao")
public class TeacherDaoImpl extends DaoBase implements ITeacherDao {

	@Override
	public int save(TeacherEntity entity) throws Exception {
		return sessionTemplate.insert(teacherStatement.replace("{sqlId}", "insertTeacher"), entity);
	}

}
