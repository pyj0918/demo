package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/springmvc")
@Controller
public class MyTest7RequestParam {

	//@RequestParam 来映射请求参数
	//value 值即请求参数的参数名
	//required 该参数是否必须，默认为true
	//defaultValue 请求参数默认值

	
	@RequestMapping("testparams")
	public String testparams(
			@RequestParam("username") String username,
			@RequestParam(value = "age", required = false, defaultValue = "0") int age) {
		System.out.println("username:" + username + ",age:" + age);
		return "success";
	}

}
