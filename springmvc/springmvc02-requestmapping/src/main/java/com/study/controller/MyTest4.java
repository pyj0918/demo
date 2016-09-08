package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/springmvc")
@Controller
public class MyTest4 {
	
	/**
	 * 支持通配符
	 * *:支持多个字符
	 * ?:支持单个字符
	 * **:支持多层
	 * @return
	 */
	@RequestMapping(value="test/**/**/abc")
	public String test(){
		System.out.println("helloword");
		return "success";
	}
}
