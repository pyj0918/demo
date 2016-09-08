package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/springmvc")
@Controller
public class MyTest1 {
	
	/**
	 * @RequestMapping 可以修饰方法，也可以修饰类
	 * @return
	 */
	@RequestMapping("/testrequestmapping")
	public String test() {
		System.out.println("helloword");
		return "success";
	}
}
