package com.test.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDao {
	@Autowired
	protected SqlSessionFactoryBean sqlsessionFactory;

	protected SqlSession getSession() {
		try {
			return sqlsessionFactory.getObject().openSession();
		} catch (Exception e) {
			throw new RuntimeException("ªÒ»°sqlsession“Ï≥£", e);
		}
	}
}
