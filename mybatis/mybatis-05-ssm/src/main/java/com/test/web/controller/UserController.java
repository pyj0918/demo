package com.test.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.service.IUserService;

@Controller
public class UserController extends BaseController{
	
	@Resource(name="userService")
	private IUserService userService;
	
	@RequestMapping("/test")
	public String test(HttpServletRequest request,HttpServletResponse response) {
		try {
			userService.saveUserAndTeacher();
			write(response,"123");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
