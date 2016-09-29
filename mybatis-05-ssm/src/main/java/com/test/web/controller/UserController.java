package com.test.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.service.IUserService;

@Controller
public class UserController {
	
	@Resource(name="userService")
	private IUserService userService;
	
	@RequestMapping("/hello")
	public String hello() {
		userService.save();
		System.out.println("123");
		return null;
	}
}
