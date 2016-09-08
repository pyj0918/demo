package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/springmvc")
@Controller
public class MyTest5 {
	
	/**
	 * Ó³ÉäurlÖÐÕ¼Î»·û
	 * @param id
	 * @return
	 */
	@RequestMapping("testpathvar/{id}")
	public String testPathVariable(@PathVariable("id") Integer id){
		System.out.println("id:"+id);
		return "success";
	}
}
