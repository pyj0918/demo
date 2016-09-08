package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/springmvc")
@Controller
public class MyTest7RequestParam {

	//@RequestParam ��ӳ���������
	//value ֵ����������Ĳ�����
	//required �ò����Ƿ���룬Ĭ��Ϊtrue
	//defaultValue �������Ĭ��ֵ

	
	@RequestMapping("testparams")
	public String testparams(
			@RequestParam("username") String username,
			@RequestParam(value = "age", required = false, defaultValue = "0") int age) {
		System.out.println("username:" + username + ",age:" + age);
		return "success";
	}

}
