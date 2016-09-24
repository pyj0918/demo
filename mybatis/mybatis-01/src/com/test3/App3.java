package com.test3;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.test1.User;
import com.util.MyBatisUtil;

public class App3 {
	public static void main(String[] args) {

	}

	// 使用注解的方式，进行添加数据
	@Test
	public void testAnnotation() {
		SqlSession session = MyBatisUtil.getFactory().openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		User entity = new User();
		entity.setAge(36);
		entity.setName("hello333");
		int row = mapper.add(entity);
		session.commit();
		session.close();
		System.out.println(row);
	}
}
