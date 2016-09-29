package com.test3;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.bean.User;
import com.util.MyBatisUtil;

public class App3 {
	public static void main(String[] args) {

	}

	// ʹ��ע��ķ�ʽ�������������
	@Test
	public void testAnnotation() {
		SqlSession session = MyBatisUtil.getFactory().openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		User entity = new User();
		entity.setAge(3677);
		entity.setName("hello333");
		int row = mapper.add(entity);
		session.commit();
		session.close();
		System.out.println(row);
	}
}
