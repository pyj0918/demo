package com.test.controller;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.service.IUserService;

//ʹ��spring�Ĳ��Կ��
@RunWith(SpringJUnit4ClassRunner.class)
// ����spring�������ļ�
@ContextConfiguration("/applicationContext.xml")
public class AppController {

	@Resource(name = "userService")
	private IUserService userService;

	@Test
	public void testSave() {
		userService.save();
	}
}
