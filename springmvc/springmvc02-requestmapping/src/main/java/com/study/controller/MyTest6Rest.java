package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * ʹ��HiddenHttpMethodFilter��ʵ��restful���Ĳ���
 * 
 * @author angelo
 * 
 */
@RequestMapping("/springmvc")
@Controller
public class MyTest6Rest {
	
	/**
	 * Rest����URL
	 * ��CRUDΪ����
	 * ������/order POST
	 * �޸ģ�/order/1  PUT
	 * ��ȡ�� /order/1  Get
	 * ɾ���� /order/1   delete
	 * 
	 * ��η���put�����delete����
	 * 1.����HiddenHttpMethodFilter
	 * 2.��Ҫ����post����
	 * 3.��Ҫ�ڷ���post����ʱЯ��һ��name="_method"��������ֵΪdelete��put
	 */
	
	
	

	@RequestMapping(value = "testpost", method = RequestMethod.POST)
	public String testPost() {
		System.out.println("restful post");
		return "success";
	}
	
	@RequestMapping(value = "testget/{id}", method = RequestMethod.GET)
	public String testGet(@PathVariable Integer id) {
		System.out.println("restful get:"+id);
		return "success";
	}
	
	@RequestMapping(value = "testput/{id}", method = RequestMethod.PUT)
	public String testPut(@PathVariable Integer id) {
		System.out.println("restful put:"+id);
		return "success";
	}
	
	@RequestMapping(value = "testdelete/{id}", method = RequestMethod.DELETE)
	public String testDelete(@PathVariable Integer id) {
		System.out.println("restful delete:"+id);
		return "success";
	}

}
