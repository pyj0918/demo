package com.test2;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.test1.User;
import com.util.MyBatisUtil;

public class App2 {
	public static void main(String[] args) {

	}

	@Test
	public void testAdd() {
		// Ĭ���ֶ��ύ
		SqlSession session = MyBatisUtil.getFactory().openSession();
		User entity = new User();
		entity.setAge(34);
		entity.setName("hello");
		int row = session.insert("com.test2.userMapper.addUser", entity);
		session.commit();
		session.close();
		System.out.println(row);
	}

	@Test
	public void testUpdate() {
		// Ĭ���ֶ��ύ
		SqlSession session = MyBatisUtil.getFactory().openSession();
		int row = session.update("com.test2.userMapper.updateUser", new User(7,
				"daye", 333));
		session.commit();
		session.close();
		System.out.println(row);
	}

	@Test
	public void testDelete() {
		// Ĭ���ֶ��ύ
		SqlSession session = MyBatisUtil.getFactory().openSession();
		int row = session.delete("com.test2.userMapper.deleteUser",13);
		session.commit();
		session.close();
		System.out.println(row);
	}
	
	@Test
	public void testSelectOne() {
		SqlSession session = MyBatisUtil.getFactory().openSession();
		User user = session.selectOne("com.test2.userMapper.getUser",1);
		session.close();
		System.out.println(user);
	}
	
	@Test
	public void testSelectAll() {
		SqlSession session = MyBatisUtil.getFactory().openSession();
		User user = session.selectOne("com.test2.userMapper.getAll");
		session.close();
		System.out.println(user);
	}
}
