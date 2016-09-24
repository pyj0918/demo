package com.util;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.test1.App1;

public class MyBatisUtil {
	public static SqlSessionFactory getFactory() {
		InputStream is = App1.class.getClassLoader().getResourceAsStream(
				"conf.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder()
				.build(is);
		return sessionFactory;
	}
}
