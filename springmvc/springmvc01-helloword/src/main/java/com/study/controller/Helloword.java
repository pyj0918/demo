package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Controller
public class Helloword {
	
	/**
	 * 1.使用@RequestMapping注解来映射请求的url
	 * 2.返回值会通过视图解析器解析为实际的物理视图，对于InternalResourceViewResolver视图解析器，会做如下解析：
	 * 通过：前缀+返回值+后缀，得到实际的物理视图，然后做转发
	 * 如：/WEB-INF/views/success.jsp
	 * @return
	 */
	@RequestMapping("/helloword")
	public String hello() {
		InternalResourceViewResolver d;
		System.out.println("helloword");
		return "success";
	}
}
