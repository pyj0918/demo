package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/springmvc")
@Controller
public class MyTest8POJO {
	@RequestMapping("/testpojo")
	public String testpojo(User user) {
		System.out.println(user.toString());
		return "success";
	}
}
