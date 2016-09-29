package com.test.controller;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.service.IUserService;

//使用spring的测试框架
@RunWith(SpringJUnit4ClassRunner.class)
// 加载spring的配置文件
@ContextConfiguration("/applicationContext.xml")
public class AppController {

	@Resource(name = "userService")
	private IUserService userService;

	@Test
	public void testSave() {
		userService.save();
	}
}
