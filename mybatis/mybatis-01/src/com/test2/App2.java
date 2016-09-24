package com.test2;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.test1.User;
import com.test3.UserMapper;
import com.util.MyBatisUtil;

public class App2 {
	public static void main(String[] args) {

	}

	@Test
	public void testAdd() {
		// 默认手动提交
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
		// 默认手动提交
		SqlSession session = MyBatisUtil.getFactory().openSession();
		int row = session.update("com.test2.userMapper.updateUser", new User(7,
				"daye", 333));
		session.commit();
		session.close();
		System.out.println(row);
	}

	@Test
	public void testDelete() {
		// 默认手动提交
		SqlSession session = MyBatisUtil.getFactory().openSession();
		int row = session.delete("com.test2.userMapper.deleteUser", 13);
		session.commit();
		session.close();
		System.out.println(row);
	}

	@Test
	public void testSelectOne() {
		SqlSession session = MyBatisUtil.getFactory().openSession();
		User user = session.selectOne("com.test2.userMapper.getUser", 1);
		session.close();
		System.out.println(user);
	}

	@Test
	public void testSelectAll() {
		SqlSession session = MyBatisUtil.getFactory().openSession();
		List<User> users = session.selectList("com.test2.userMapper.getAll");
		session.close();
		System.out.println(users);
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
