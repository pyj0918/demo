package com.test.controller;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.entity.User;
import com.test.mapper.UserMapper;

//使用spring的测试框架
@RunWith(SpringJUnit4ClassRunner.class)
// 加载spring的配置文件
@ContextConfiguration("/applicationContext.xml")
public class App {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void testInsert() {
		User user = new User(-1, "hello333", new Date(), 1345);
		userMapper.save(user);
	}
	
	@Test
	public void testUpdate() {
		userMapper.update(new User(2,"hello2",new Date(),11111));
	}
	
	@Test
	public void testDelete() {
		userMapper.delete(1);
	}
	
	@Test
	public void testFindById() {
		User user = userMapper.findById(2);
		System.out.println(user);
	}
	
	@Test
	public void testFindAll() {
		List<User> users = userMapper.findAll();
		System.out.println(users);
	}
	
}
