package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 使用HiddenHttpMethodFilter来实现restful风格的操作
 * 
 * @author angelo
 * 
 */
@RequestMapping("/springmvc")
@Controller
public class MyTest6Rest {
	
	/**
	 * Rest风格的URL
	 * 以CRUD为例：
	 * 新增：/order POST
	 * 修改：/order/1  PUT
	 * 获取： /order/1  Get
	 * 删除： /order/1   delete
	 * 
	 * 如何发送put请求和delete请求
	 * 1.配置HiddenHttpMethodFilter
	 * 2.需要发送post请求
	 * 3.需要在发送post请求时携带一个name="_method"的隐藏域，值为delete或put
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
