package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/springmvc")
@Controller
public class MyTest4 {
	
	/**
	 * ֧��ͨ���
	 * *:֧�ֶ���ַ�
	 * ?:֧�ֵ����ַ�
	 * **:֧�ֶ��
	 * @return
	 */
	@RequestMapping(value="test/**/**/abc")
	public String test(){
		System.out.println("helloword");
		return "success";
	}
}
