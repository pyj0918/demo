package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/springmvc")
@Controller
public class MyTest1 {
	
	/**
	 * @RequestMapping �������η�����Ҳ����������
	 * @return
	 */
	@RequestMapping("/testrequestmapping")
	public String test() {
		System.out.println("helloword");
		return "success";
	}
}
