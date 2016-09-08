package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Controller
public class Helloword {
	
	/**
	 * 1.ʹ��@RequestMappingע����ӳ�������url
	 * 2.����ֵ��ͨ����ͼ����������Ϊʵ�ʵ�������ͼ������InternalResourceViewResolver��ͼ���������������½�����
	 * ͨ����ǰ׺+����ֵ+��׺���õ�ʵ�ʵ�������ͼ��Ȼ����ת��
	 * �磺/WEB-INF/views/success.jsp
	 * @return
	 */
	@RequestMapping("/helloword")
	public String hello() {
		InternalResourceViewResolver d;
		System.out.println("helloword");
		return "success";
	}
}
