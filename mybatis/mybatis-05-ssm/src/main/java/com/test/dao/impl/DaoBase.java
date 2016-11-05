package com.test.dao.impl;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class DaoBase {

	//@Autowired
	//protected SqlSessionFactoryBean sqlsessionFactory;
	//protected SqlSession session = null;
	@Resource
	protected SqlSessionTemplate  sessionTemplate;

	protected static String userStatement = "com.test.mapper.UserMapper.{sqlId}";
	protected static String teacherStatement = "com.test.mapper.TeacherMapper.{sqlId}";

//	protected SqlSession getSession(boolean autoCommit) {
//		try {
//			return sqlsessionFactory.getObject().openSession(autoCommit);
//		} catch (Exception e) {
//			throw new RuntimeException("ªÒ»°sqlsession“Ï≥£", e);
//		}
//	}
}
