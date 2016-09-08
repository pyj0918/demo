package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/springmvc")
@Controller
public class MyTest3 {
	
	/**
	 * params={"username","age!=10"}:请求必须包含username和age，两个参数，且age不能等于10
	 * @return
	 */
	@RequestMapping(value="testparamsandheaders",params={"username","age!=10"},headers={"accept-language=zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3"})
	public String testParamAndHeader(){
		System.out.println("helloword");
		return "success";
	}
}
